package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;
import vo.Emp;


@WebServlet("/emp/empList")
public class EmpListController extends HttpServlet {
	private EmpService empService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		empService = new EmpService();
		list = empService.getEmpList();
		
		request.setAttribute("list", list);
		
		
		// empList.jsp
		request.getRequestDispatcher("/WEB-INF/view/emp/empList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
