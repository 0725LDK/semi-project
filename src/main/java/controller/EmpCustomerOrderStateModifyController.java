package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.OrderService;

@WebServlet("/emp/empCustomerOrderStateModify")
public class EmpCustomerOrderStateModifyController extends HttpServlet {
	
	//관리자 회원 배송 상태 변경
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String orderState = request.getParameter("orderState");
		System.out.println(orderCode+"<---주문번호");
		System.out.println(orderState+"<---주문상태");
		
		OrderService orderService = new OrderService();
		orderService.empCustomerOrderStateUpdate(orderState, orderCode);
		
		System.out.println("직원 고객주문내역 상태 변경 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empCustomerOrder?currentPage="+currentPage);
	}
}
