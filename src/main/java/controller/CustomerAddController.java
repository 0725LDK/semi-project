package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Customer;
import vo.Customer_address;


@WebServlet("/customer/customerAdd")
public class CustomerAddController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 되어있으면 /home/intro
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/home/intro");
		}
		
		// customerAdd.jsp
		request.getRequestDispatcher("/WEB-INF/view/customer/customerAdd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		
		int row = 0;
		// cutomerAdd 폼 에서 받아온 값
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		String pwCheck = request.getParameter("pwCheck");
		String customerName = request.getParameter("customerName");
		String customerPhone = request.getParameter("customerPhone");
		String customerAddress = request.getParameter("customerAddress");
		System.out.println(customerId+" : customerId CustomerAddController");
		System.out.println(customerPw+" : customerPw CustomerAddController");
		System.out.println(pwCheck+" : pwCheck CustomerAddController");
		System.out.println(customerName+" : customerName CustomerAddController");
		System.out.println(customerPhone+" : customerPhone CustomerAddController");
		System.out.println(customerAddress+" : customerAddress CustomerAddController");
		
		if(!customerPw.equals(pwCheck)) {
			System.out.println("비밀번호 체크 미일치");
			response.sendRedirect(request.getContextPath()+"/customer/customerAdd");
			return;
		}
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerPw(customerPw);
		customer.setCustomerName(customerName);
		customer.setCustomerPhone(customerPhone);
		
		this.memberService = new MemberService();
		row = memberService.getAddCustomer(customer);
		
		if(row == 0) {
			System.out.println("고객 회원가입 실패, CustomerAddController");
			response.sendRedirect(request.getContextPath()+"/customer/customerAdd");
			return;
		}
		
		System.out.println("고객 회원가입 성공, CustomerAddController");
		// login.jsp
		response.sendRedirect(request.getContextPath()+"/home/login");
	}

}
