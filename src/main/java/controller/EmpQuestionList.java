package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.QuestionService;


@WebServlet("/emp/empQuestionList")
public class EmpQuestionList extends HttpServlet {
	
	private QuestionService questionService;
	
	//고객센터 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		ArrayList<HashMap<String,Object>> list = null;
		this.questionService = new QuestionService();

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
		int count = 0;//총 고객 주문 수
		
		String search = request.getParameter("search");
		
		if(search == null)
		{
			list = questionService.empQuestionList(beginRow, rowPerPage);
			count = questionService.empQuestionListCount();
		}
		else if(search != null)
		{
			list = questionService.empQuestionListSearch(beginRow, rowPerPage, search);
			count = questionService.empQuestionListCountSearch(search);
		}
		
		lastPage = count/rowPerPage;
		if(count%rowPerPage !=0)
		{
			lastPage = lastPage+1;
		}
		
		request.setAttribute("questionList", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empQuestionList.jsp").forward(request, response);
	}

}