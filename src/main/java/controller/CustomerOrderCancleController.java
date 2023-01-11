package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

@WebServlet("/customer/customerOrderCancle")
public class CustomerOrderCancleController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		
		OrderService orderService = new OrderService();
		orderService.updateCustomerOrderStateCancle(orderCode);
		
		System.out.println("상품취소 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerOrderList");
	}

	
}
