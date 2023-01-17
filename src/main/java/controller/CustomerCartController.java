package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartService;
import vo.Cart;
import vo.Customer;


@WebServlet("/customer/customerCart")
public class CustomerCartController extends HttpServlet {
	private CartService cartService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 로그인 상태일때 장바구니
		if(session.getAttribute("loginCustomer") != null) {
			// 세션 로그인 아이디
			Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
			String customerId = loginCustomer.getCustomerId();
			System.out.println(customerId+" : customerId CustomerCartController");
			
			// 비회원으로 장바구니 상품 담고 -> 로그인 시
			if(session.getAttribute("productList") != null) {
				ArrayList<HashMap<String, Object>> productList = new ArrayList<HashMap<String, Object>>();
				productList = (ArrayList<HashMap<String, Object>>)session.getAttribute("productList");
				System.out.println(productList.size() +"list.size()"); // productList 크기 확인
				
				for(int i=0; i<productList.size(); i++) { // 장바구니 상품수만큼 반복
					String code = productList.get(i).get("goodsCode").toString(); // list에 저장된 goodsCode 가져오기
					String quantity = productList.get(i).get("cartQuantity").toString(); // list에 저장된 cartQuantity 가져오기
					int goodsCode = Integer.parseInt(code); 
					int cartQuantity = Integer.parseInt(quantity);
					System.out.println(goodsCode+" : goodsCode CustomerCartController 비회원주문 입력");
					System.out.println(cartQuantity+" : cartQuantity CustomerCartController 비회원주문 입력");
					
					Cart cart = new Cart();
					cart.setCustomerId(customerId);
					cart.setGoodsCode(goodsCode);
					cart.setCartQuantity(cartQuantity);
					
					cartService = new CartService();
					// 넘어온값이 이미 장바구니에 있는지 확인
					int result = cartService.getSelectCartOneCk(cart);
					if(result == 0) { // 데이터가 없으면
						// 장바구니 db에 insert
						int row = cartService.getAddCart(cart);
						if(row == 0) {
							System.out.println("입력실패 CustomerCartController");
						} else {
							System.out.println("입력성공 CustomerCartController");
						}
					} else { // 이미 장바구니에있는 제품이면 수량만 +
						int upResult = cartService.getModifyCartQuantityBySum(cart);
						if(upResult == 0) {
							System.out.println("수량추가실패 CustomerCartController");
						} else {
							System.out.println("수량추가성공 CustomerCartController");
						}
					}
				}
				// 비회원 장바구니값 세션 삭제
				session.removeAttribute("productList");
			}		
			
			// 회원상태 상품페이지에서 장바구니 클릭시 넘어온값이 있으면 실행
			if(request.getParameter("goodsCode") != null && request.getParameter("goodsQuantity") != null) {
				// 상품페이지에서 장바구니 클릭시 넘어온값
				int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
				int cartQuantity = Integer.parseInt(request.getParameter("goodsQuantity"));
				System.out.println(goodsCode+" : goodsCode CustomerCartController 회원주문 입력");
				System.out.println(cartQuantity+" : cartQuantity CustomerCartController 회원주문 입력");
				
				Cart cart = new Cart();
				cart.setCustomerId(customerId);
				cart.setGoodsCode(goodsCode);
				cart.setCartQuantity(cartQuantity);
				
				cartService = new CartService();
				// 넘어온값이 이미 장바구니에 있는지 확인
				int result = cartService.getSelectCartOneCk(cart);
				if(result == 0) { // 데이터가 없으면
					// 장바구니 db에 insert
					int row = cartService.getAddCart(cart);
					if(row == 0) {
						System.out.println("입력실패 CustomerCartController");
					} else {
						System.out.println("입력성공 CustomerCartController");
					}
				} else { // 이미 장바구니에있는 제품이면 수량만 +
					int upResult = cartService.getModifyCartQuantityBySum(cart);
					if(upResult == 0) {
						System.out.println("수량추가실패 CustomerCartController");
					} else {
						System.out.println("수량추가성공 CustomerCartController");
					}
				}
				
			}
			
			// 회원 장바구니에 담긴 리스트
			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> m, n = new HashMap<String, Object>();
			cartService = new CartService();
			// 장바구니 리스트
			list = cartService.getSelectCartList(customerId);
			// 장바구니 가격 합계
			m = cartService.getSelectSumByCart(customerId);
			// 장바구니 수량 합계
			n = cartService.getSelectCartQuantitySum(customerId);
			// view로 값 넘기기
			request.setAttribute("list", list);
			request.setAttribute("m", m);
			request.setAttribute("n", n);
		}
		
		// 비회원 장바구니 
		if(session.getAttribute("loginCustomer") == null) {
			if(request.getParameter("goodsCode") != null && request.getParameter("goodsQuantity") != null) {
				int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
				int cartQuantity = Integer.parseInt(request.getParameter("goodsQuantity"));
				System.out.println(goodsCode+" : goodsCode CustomerCartController");
				System.out.println(cartQuantity+" : cartQuantity CustomerCartController");
		
				HashMap<String, Object> m = new HashMap<String, Object>();
				cartService = new CartService();
				m = cartService.addCart(goodsCode);
				
				ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>)session.getAttribute("productList");
				if(list == null) { // 비회원 처음 장바구니 클릭시
					list = new ArrayList<HashMap<String, Object>>(); // list초기화
					session.setAttribute("productList", list); // list 세션 생성
					m.put("cartQuantity", cartQuantity); // 선택한 수량 저장
					list.add(m);
					System.out.println("처음 장바구니 입력");
				} else { // 비회원 장바구니 생성되어 있으면
					for(HashMap<String, Object> map : list) {
						// 장바구니 중복상품 확인
						if((int)map.get("goodsCode") == goodsCode) { // 중복상품이면 수량만 추가
							System.out.println("중복상품");
							map.put("cartQuantity", (int)map.get("cartQuantity")+cartQuantity);
							request.setAttribute("productList", list);
							request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
							return;
						} 
					}
					System.out.println("중복아닌상품");
					m.put("cartQuantity", cartQuantity);
					list.add(m);
				}
				// 비회원 장바구니 리스트 값
				request.setAttribute("productList", list);
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
	}
}
