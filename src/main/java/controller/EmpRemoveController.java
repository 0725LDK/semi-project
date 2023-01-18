package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmpService;


@WebServlet("/emp/empRemove")
public class EmpRemoveController extends HttpServlet {

	//직원 삭제
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

		EmpService empService = new EmpService();
		empService.deleteEmpAndAddOutId(empCode, empId);

		System.out.println("직원 삭제 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empList");
	}
}