package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpSumController
 */
@WebServlet("/emp/empSum")
public class EmpSumController extends HttpServlet {
	
	//판매합계데이터
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/emp/empSum.jsp").forward(request, response);
	}

	
	

}
