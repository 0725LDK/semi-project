package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpService;

/**
 * Servlet implementation class EmpSumController
 */
@WebServlet("/emp/empSum")
public class EmpSumController extends HttpServlet {
	
	private EmpService empService;
	
	//판매합계데이터
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<HashMap<String,Object>> list = null;
		this.empService = new EmpService();
		list = empService.empSumAlcoholByCategory();
		request.setAttribute("sumByCategory", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empSum.jsp").forward(request, response);

	}
}
