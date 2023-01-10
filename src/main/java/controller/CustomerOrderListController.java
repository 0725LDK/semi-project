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

import service.OrderService;
import vo.Customer;

/**
 * Servlet implementation class CustomerOrderListController
 */
@WebServlet("/customer/customerOrderList")
public class CustomerOrderListController extends HttpServlet {
	
	private OrderService orderService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		
		// 로그인중인 session id확인
		
		String customerId = request.getParameter("customerId");
		System.out.println(customerId);
		
		ArrayList<HashMap<String,Object>> list = null;
		this.orderService = new OrderService();
		list = orderService.customerGetOrderList(customerId);
	
		request.setAttribute("orderList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerOrderList.jsp").forward(request, response);
	}
}
