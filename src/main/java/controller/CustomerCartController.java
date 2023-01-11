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
import vo.Customer;


@WebServlet("/customer/customerCart")
public class CustomerCartController extends HttpServlet {
	private CartService cartService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 0;
		HttpSession session = request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartController");
		
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		System.out.println(goodsCode+" : goodsCode CustomerCartController");

	
		HashMap<String, Object> m = new HashMap<String, Object>();
		cartService = new CartService();
		m = cartService.getSelectGoodsOne(goodsCode);
		
		row = cartService.getAddCart(customerId, goodsCode);
		if(row == 0) {
			System.out.println("cart입력실패");
		}
		
		//Goods goods = new Goods();
		//goods.setGoodsCode(goodsCode);
		//goods.setGoodsName(goodsName);
		//goods.setGoodsPrice(goodsPrice);
		
		//int product = Integer.parseInt(request.getParameter("goodsCode"));
		ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>)session.getAttribute("productList");
		if(list == null) {
			list = new ArrayList<HashMap<String, Object>>();
			session.setAttribute("productList", list);
		}
		list.add(m);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCart.jsp").forward(request, response);
	}

}
