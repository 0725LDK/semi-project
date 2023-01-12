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
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		// 세션 로그인 아이디
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartController");
		
		// 상품페이지에서 장바구니 클릭시 넘어온값이 있으면 실행
		if(request.getParameter("goodsCode") != null && request.getParameter("orderQuantity") != null) {
			// 상품페이지에서 장바구니 클릭시 넘어온값
			int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
			int cartQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
			System.out.println(goodsCode+" : goodsCode CustomerCartController");
			System.out.println(cartQuantity+" : cartQuantity CustomerCartController");
			
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
		
		// 장바구니에 담긴 리스트
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> m = new HashMap<String, Object>();
		cartService = new CartService();
		// 장바구니 리스트
		list = cartService.getSelectCartList(customerId);
		// 장바구니 가격 합계
		m = cartService.getSelectSumByCart(customerId);

		request.setAttribute("list", list);
		request.setAttribute("m", m);

		request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
	}

}
