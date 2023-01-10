package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;
import vo.Customer;

/**
 * Servlet implementation class CustomerOrderStateModifyController
 */
@WebServlet("/customer/customerOrderStateModify")
public class CustomerOrderStateModifyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String orderState = request.getParameter("orderState");
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		
		System.out.println(orderState+"<---orderState값");
		System.out.println(orderCode+"<---orderCode값");
		
		// 로그인중인 session id확인
		Customer loginCustomer = new Customer();
		loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId + " customerId ,CustomerOrderStateModifyController");
		request.setAttribute("customerId", customerId);
		
		OrderService orderService = new OrderService();
		orderService.customerGetUpdateOrderState(orderState, orderCode);
		
		response.sendRedirect(request.getContextPath()+"/customer/customerOrderList?customerId="+customerId);
	}

	

}
