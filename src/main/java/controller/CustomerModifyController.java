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

@WebServlet("/customer/customerModify")
public class CustomerModifyController extends HttpServlet {
	private CustomerService customerService;
	//고객 정보 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		// customerModify.jsp
		request.getRequestDispatcher("/WEB-INF/view/customer/customerModify.jsp").forward(request, response);
	}

	//고객 정보 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		
		int row = 0;
		int result = 0;
		// cutomerModify 폼 에서 받아온 값
		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String customerPw = request.getParameter("customerPw");
		String newPw = request.getParameter("newPw");
		String newPwCk = request.getParameter("newPwCk");
		String customerPhone = request.getParameter("customerPhone");
		System.out.println(customerId+" : customerId CustomerModifyController");
		System.out.println(customerName+" : customerName CustomerModifyController");
		System.out.println(customerPw+" : customerPw CustomerModifyController");
		System.out.println(newPw+" : newPw CustomerModifyController");
		System.out.println(newPwCk+" : newPwCk CustomerModifyController");
		System.out.println(customerPhone+" : customerPhone CustomerModifyController");
		
		// 변경할 비밀번호 일치 확인
		if(!newPw.equals(newPwCk)) {
			System.out.println("변경할 비밀번호 체크 미일치 CustomerModifyController");
			response.sendRedirect(request.getContextPath()+"/customer/customerModify");
			return;
		}
		// 현재 비밀번호 일치 확인
		this.customerService = new CustomerService();
		row = customerService.getPasswordCheck(customerId, customerPw);
		if(row == 0) {
			System.out.println("현재 비밀번호 미일치 CustomerModifyController");
			response.sendRedirect(request.getContextPath()+"/customer/customerModify");
			return;
		}
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerPw(newPw);
		customer.setCustomerPhone(customerPhone);
		
		result = customerService.getModifyCustomer(customer);
		if(result == 0) {
			System.out.println("회원정보 수정 실패 CustomerModifyController");
			response.sendRedirect(request.getContextPath()+"/customer/customerModify");
			return;
		}
		
		System.out.println("회원정보 수정 성공 CustomerModifyController");
		response.sendRedirect(request.getContextPath()+"/customer/customerOne");
	}

}
