package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

@WebServlet("/emp/empCustomerOrderStateModify")
public class EmpCustomerOrderStateModifyController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		String orderState = request.getParameter("orderState");
		System.out.println(orderCode+"<---주문번호");
		System.out.println(orderState+"<---주문상태");
				
		
		OrderService orderService = new OrderService();
		orderService.empCustomerOrderStateUpdate(orderState, orderCode);
		
		System.out.println("직원 고객주문내역 상태 변경 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empCustomerOrder");
	}
}
