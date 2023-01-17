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
		
		//페이징 변수
		int firstPage = 1;
		int currentPage = 1;
		if(request.getParameter("currentPage") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		int lastPage = 0;
		int count = 0;//총 고객 리뷰 추가&삭제 수
		
		String search = request.getParameter("search");
		
		if(search == null)
		{
			list = empService.empReviewList(beginRow, rowPerPage);
			count = empService.empReviewListCount(beginRow, rowPerPage);
		}
		else if(search != null)
		{
			list = empService.empReviewListSearch(beginRow, rowPerPage, search);
			count = empService.empReviewListCountSearch(beginRow, rowPerPage, search);
		}
		
		lastPage = count/rowPerPage;
		if(count%rowPerPage !=0)
		{
			lastPage = lastPage+1;
		}
		
		System.out.println(lastPage+"<--emoReviewListCont lastPage");
		System.out.println(count+"<--emoReviewListCont lastPage");

		request.setAttribute("reviewList", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerReview.jsp").forward(request, response);
	}

	

}
