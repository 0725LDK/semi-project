package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;
import vo.Emp;


@WebServlet("/emp/empModify")
public class EmpModifyController extends HttpServlet {
	
	//직원정보 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		
		request.setAttribute("empCode", empCode);
		request.setAttribute("empId", empId);
		request.setAttribute("empName", empName);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empModify.jsp").forward(request, response);
	}

	//직원정보 수정액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		int authCode = Integer.parseInt(request.getParameter("authCode"));
		String empName = request.getParameter("empName");
		String active = request.getParameter("active");
		
		Emp emp = new Emp();
		emp.setEmpCode(empCode);
		emp.setAuthCode(authCode);
		emp.setEmpName(empName);
		emp.setActive(active);
		
		EmpService empService = new EmpService();
		empService.getEmpModifyInfo(emp);
		
		System.out.println("직원 정보 수정 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empList");
	}

}