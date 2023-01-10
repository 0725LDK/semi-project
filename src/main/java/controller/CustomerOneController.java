package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import vo.Customer;


@WebServlet("/customer/customerOne")
public class CustomerOneController extends HttpServlet {
	private CustomerService customerService;
	//고객정보 마이페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		// 로그인중인 session id확인
		Customer loginCustomer = new Customer();
		loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId + " customerId ,CustomerOneController");
		// 회원정보 받아오기
		Customer customer = new Customer();
		customerService = new CustomerService();
		customer = customerService.getSelectCustomerOne(customerId);
		
		request.setAttribute("customer", customer);
		
		
		// customerOne.jsp
		request.getRequestDispatcher("/WEB-INF/view/customer/customerOne.jsp").forward(request, response);
	}

	
}