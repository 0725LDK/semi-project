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


@WebServlet("/customer/customerRemove")
public class CustomerRemoveController extends HttpServlet {
	private CustomerService customerService;
	//회원 탈퇴 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		// customerRemove.jsp
		request.getRequestDispatcher("/WEB-INF/view/customer/customerRemove.jsp").forward(request, response);
	}

	//회원 탈퇴 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int row = 0;
		int pwCk = 0;
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		System.out.println(customerId + " : customerId, CustomerRemoveController");
		System.out.println(customerPw + " : customerPw, CustomerRemoveController");
		
		// 탈퇴시 비밀번호 확인
		this.customerService = new CustomerService();
		pwCk = customerService.getPasswordCheck(customerId, customerPw);
		if(pwCk == 0) {
			System.out.println("회원탈퇴 실패 비밀번호 오류 CustomerRemoveController");
			response.sendRedirect(request.getContextPath()+"/customer/customerRemove");
		}
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerPw(customerPw);
		
		this.customerService = new CustomerService();
		row = customerService.getRemoveCustomer(customer);
		
		if(row == 0) {
			System.out.println("회원탈퇴 실패 CustomerRemoveController");
			response.sendRedirect(request.getContextPath()+"/customer/customerRemove");
		} else {
			System.out.println("회원탈퇴 성공 CustomerRemoveController");
			HttpSession session = request.getSession();
			session.invalidate(); // 세션 초기화
			response.sendRedirect(request.getContextPath()+"/home/intro");
		}
	}
		

}
