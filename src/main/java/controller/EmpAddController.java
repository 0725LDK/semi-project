package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Emp;


@WebServlet("/emp/empAdd")
public class EmpAddController extends HttpServlet {
	private MemberService memberService;
	// emp 회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 되어있으면 /home/intro
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/home/intro");
		}
		
		// empAdd.jsp
		request.getRequestDispatcher("/WEB-INF/view/emp/empAdd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		
		int row = 0;
		// empAdd 폼 에서 받아온 값
		String empId = request.getParameter("empId");
		String empPw = request.getParameter("empPw");
		String pwCheck = request.getParameter("pwCheck");
		String empName = request.getParameter("empName");
		System.out.println(empId+" : empId EmpAddController");
		System.out.println(empPw+" : empPw EmpAddController");
		System.out.println(pwCheck+" : pwCheck EmpAddController");
		System.out.println(empName+" : empName EmpAddController");
		
		if(!empPw.equals(pwCheck)) {
			System.out.println("비밀번호 체크 미일치");
			response.sendRedirect(request.getContextPath()+"/emp/empAdd");
			return;
		}
		
		Emp emp = new Emp();
		emp.setEmpId(empId);
		emp.setEmpPw(empPw);
		emp.setEmpName(empName);
		
		this.memberService = new MemberService();
		row = memberService.getAddEmp(emp);
		
		if(row == 0) {
			System.out.println("직원 회원가입 실패, EmpAddController");
			response.sendRedirect(request.getContextPath()+"/emp/empAdd");
			return;
		}
		
		System.out.println("직원 회원가입 성공, EmpAddController");
		// login.jsp
		response.sendRedirect(request.getContextPath()+"/home/login");
	}

}