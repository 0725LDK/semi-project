package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartService;
import vo.Cart;
import vo.Customer;

/**
 * Servlet implementation class CustomerCartRemoveController
 */
@WebServlet("/customer/customerCartRemove")
public class CustomerCartRemoveController extends HttpServlet {
	private CartService cartService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		// 세션 로그인 아이디
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartController");
		// 삭제할 goodsCode
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		System.out.println(goodsCode + " : goodsCode CustomerCartRemoveController");
		
		Cart cart = new Cart();
		cart.setCustomerId(customerId);
		cart.setGoodsCode(goodsCode);
		
		cartService = new CartService();
		int result = cartService.getRemoveCartOne(cart);
		
		if(result == 0) {
			System.out.println("삭제실패 CustomerCartRemoveController");
		} else {
			System.out.println("삭제성공 CustomerCartRemoveController");
			// customerCart.jsp
			response.sendRedirect(request.getContextPath()+"/customer/customerCart");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
