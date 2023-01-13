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


@WebServlet("/customer/customerCartModify")
public class CustomerCartModifyController extends HttpServlet {
	private CartService cartService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		// 세션 로그인 아이디
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartModifyController");
		// 변경할 goodsCode, cartQuantity
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		int cartQuantity = Integer.parseInt(request.getParameter("cartQuantity"));
		System.out.println(goodsCode + " : goodsCode CustomerCartModifyController");
		System.out.println(cartQuantity + " : cartQuantity CustomerCartModifyController");
		
		Cart cart = new Cart();
		cart.setCustomerId(customerId);
		cart.setGoodsCode(goodsCode);
		cart.setCartQuantity(cartQuantity);
		
		cartService = new CartService();
		int result = cartService.getModifyCartQuantity(cart);
		if(result == 0) {
			System.out.println("수정실패 CustomerCartModifyController");
		} else {
			System.out.println("수정성공 CustomerCartModifyController");
			// /customer/customerCart
			response.sendRedirect(request.getContextPath()+"/customer/customerCart");
		}
		
	}

	
	

}
