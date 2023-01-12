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
import service.OrderService;

/**
 * Servlet implementation class EmpReviewListController
 */
@WebServlet("/emp/empCustomerReviewList")
public class EmpReviewListController extends HttpServlet {
	
	private EmpService empService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HashMap<String,Object>> list = null;
		this.empService = new EmpService();
		list = empService.empReviewList();
		request.setAttribute("reviewList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerReview.jsp").forward(request, response);
	}

	

}
