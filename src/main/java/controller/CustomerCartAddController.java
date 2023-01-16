package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartService;


@WebServlet("/customer/customerCartAdd")
public class CustomerCartAddController extends HttpServlet {
    private CartService cartService;
    private ArrayList<HashMap<String, Object>> list;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		HttpSession session = request.getSession();		
		// 비회원 장바구니
		if(session.getAttribute("loginCustomer") == null) { 
			System.out.println("CustomerCartAdd 비회원 장바구니");
				
			int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			// 세션에 이미 장바구니가 있다면 이어서 상품 담기
			if(session.getAttribute("list") != null) {
				System.out.println("비회원 세션 장바구니");
				list = (ArrayList<HashMap<String, Object>>)session.getAttribute("list");				
				// 비회원 장바구니 중복 체크
				for(HashMap<String, Object> m : list) {
					if( (int)m.get("goodsCode") == goodsCode ) {
						System.out.println("장바구니 중복 상품");

						return;
					}
				}				
			} else {
				System.out.println("비회원 세션 빈 장바구니");
				ArrayList<HashMap<String, Object>> list = new ArrayList<>(); 
			}
			
			cartService = new CartService();
			HashMap<String, Object> m = cartService.addCart(goodsCode);
			m.put("quantity", quantity);
			list.add(m);
			
			
			session.setAttribute("list", list);
			System.out.println("장바구니 추가 성공");

			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
	}

}
