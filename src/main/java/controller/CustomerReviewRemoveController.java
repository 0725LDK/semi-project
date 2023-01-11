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


@WebServlet("/customer/customerReviewRemove")
public class CustomerReviewRemoveController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// 로그인중인 session id확인
		Customer loginCustomer = new Customer();
		loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId + " customerId ,CustomerReviewAddController");
		request.setAttribute("customerId", customerId);
		
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		
		
		OrderService orderService = new OrderService();
		orderService.deleteOrderReview(orderCode);
		
		System.out.println("리뷰 삭제 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerOrderList?customerId="+customerId);
	}

}