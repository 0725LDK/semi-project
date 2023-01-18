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


@WebServlet("/customer/customerReviewAdd")
public class CustomerReviewAddController extends HttpServlet {
	
	//리뷰 추가 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 로그인중인 session id확인
		Customer loginCustomer = new Customer();
		loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId + " customerId ,CustomerReviewAddController");
		request.setAttribute("customerId", customerId);
		
		int orderCode = Integer.parseInt(request.getParameter("orderCode"));
		String reviewMemo = request.getParameter("reviewMemo");
		
		OrderService orderService = new OrderService();
		orderService.addOrderConfirmReview(orderCode, customerId, reviewMemo);
		
		response.sendRedirect(request.getContextPath()+"/customer/customerOrderList?customerId="+customerId);
	}

	/*리뷰 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("리뷰 추가 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerReview");
	}*/

}