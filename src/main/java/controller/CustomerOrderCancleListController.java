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
 * Servlet implementation class CustomerCancleController
 */
@WebServlet("/customer/customerOrderCancleList")
public class CustomerOrderCancleListController extends HttpServlet {
	
	// 취소/구매내역
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// 로그인중인 session id확인
		Customer loginCustomer = new Customer();
		loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId + " customerId ,CustomerReviewAddController");
		request.setAttribute("customerId", customerId);
		
		ArrayList<HashMap<String,Object>> list = null;
		OrderService orderService = new OrderService();
		list = orderService.customerOrderCancleList(customerId);
		
		request.setAttribute("orderList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerOrderCancle.jsp").forward(request, response);
	}

}