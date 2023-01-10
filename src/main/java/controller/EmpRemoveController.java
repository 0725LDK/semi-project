package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;


@WebServlet("/emp/empRemove")
public class EmpRemoveController extends HttpServlet {

	//직원 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int empCode = Integer.parseInt(request.getParameter("empCode"));
		String empId = request.getParameter("empId");

		EmpService empService = new EmpService();
		empService.deleteEmpAndAddOutId(empCode, empId);

		System.out.println("직원 삭제 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empList");
	}
}