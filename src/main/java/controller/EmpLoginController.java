package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.EmpService;
import vo.Customer;
import vo.Emp;


@WebServlet("/home/empLogin")
public class EmpLoginController extends HttpServlet {
	private CustomerService customerService;
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//login.jsp
		request.getRequestDispatcher("/WEB-INF/view/home/empLogin.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 되어있으면 /home/intro
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/home/intro");
			return;
		}
		
		// login.jsp에서 넘어온 값 확인
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		System.out.println(loginId+" = loginId");
		System.out.println(loginPw+" = loginPw");
		
		// 고객 로그인 확인
		Customer paramCustomer = new Customer();
		paramCustomer.setCustomerId(loginId);
		paramCustomer.setCustomerPw(loginPw);
		
		this.customerService = new CustomerService();
		Customer returnCustomer =  customerService.CustomerLogin(paramCustomer);
		
		// 고객 로그인 성공 session에 저장
		if(returnCustomer != null) {
			System.out.println("고객로그인 성공");
			session.setAttribute("loginCustomer", returnCustomer);
			// 미로그인시 장바구니에 상품 담은후 주문하기 클릭시 로그인 -> 장바구니페이지로 이동
			if(session.getAttribute("productList") != null) {
				System.out.println("고객로그인 성공 장바구니로");
				response.sendRedirect(request.getContextPath()+"/customer/customerCart");
				return;
			}
			response.sendRedirect(request.getContextPath()+"/home/main");
			return;
		}
		
		// 직원 로그인 확인
		Emp paramEmp = new Emp();
		paramEmp.setEmpId(loginId);
		paramEmp.setEmpPw(loginPw);
		
		this.empService = new EmpService();
		Emp returnEmp = empService.EmpLogin(paramEmp);
		if(returnEmp == null) {
			System.out.println("로그인 실패 : LoginController");
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		// 직원 로그인 성공 session에 저장
		System.out.println("직원로그인 성공");
		session.setAttribute("loginEmp", returnEmp);
		response.sendRedirect(request.getContextPath()+"/emp/empOne");

	}

}
