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
import vo.Emp;


@WebServlet("/home/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//login.jsp
		request.getRequestDispatcher("/WEB-INF/view/home/login.jsp").forward(request, response);
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
		
		this.memberService = new MemberService();
		Customer returnCustomer =  memberService.CustomerLogin(paramCustomer);
		
		// 고객 로그인 성공 session에 저장
		if(returnCustomer != null) {
			System.out.println("고객로그인 성공");
			session.setAttribute("loginMember", returnCustomer);
			response.sendRedirect(request.getContextPath()+"/home/intro");
			return;
		}
		
		// 직원 로그인 확인
		Emp paramEmp = new Emp();
		paramEmp.setEmpId(loginId);
		paramEmp.setEmpPw(loginPw);
		
		this.memberService = new MemberService();
		Emp returnEmp = memberService.EmpLogin(paramEmp);
		if(returnEmp == null) {
			System.out.println("로그인 실패 : LoginController");
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		// 직원 로그인 성공 session에 저장
		System.out.println("직원로그인 성공");
		session.setAttribute("loginMember", returnEmp);
		response.sendRedirect(request.getContextPath()+"/home/intro");

	}

}
