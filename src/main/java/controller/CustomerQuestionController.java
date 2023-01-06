package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;


@WebServlet("/customer/customerQuestion")
public class CustomerQuestionController extends HttpServlet {
	
	private QuestionService questionService; 
	
	//고객센터 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		ArrayList<HashMap<String,Object>> list =null;
		
		this.questionService = new QuestionService();
		list = questionService.getQuestionListByPage(questionCode);
		
		request.setAttribute("questionList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerQuestion.jsp").forward(request, response);
	}

}
