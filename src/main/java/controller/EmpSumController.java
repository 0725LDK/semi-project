package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CounterDao;
import service.CounterService;
import service.EmpService;

/**
 * Servlet implementation class EmpSumController
 */
@WebServlet("/emp/empSum")
public class EmpSumController extends HttpServlet {
	
	private EmpService empService;
	private CounterService counterService;
	
	//판매합계데이터 + 사이트 접속자수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//판매합계데이터
		ArrayList<HashMap<String,Object>> list = null;
		this.empService = new EmpService();
		list = empService.empSumAlcoholByCategory();
		request.setAttribute("sumByCategory", list);
		
		//사이트 접속자수
		counterService = new CounterService();
		try {
			int todayCount = counterService.selectTodayCount();
			System.out.println("todayCount : "+ todayCount);
			request.setAttribute("todayCount", todayCount);
			
			int totalCount = counterService.selectTotalCount();
			System.out.println("totalCount : "+ totalCount);
			request.setAttribute("totalCount", totalCount);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empSum.jsp").forward(request, response);

	}
}
