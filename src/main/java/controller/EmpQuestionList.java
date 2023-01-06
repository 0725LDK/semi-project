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


@WebServlet("/emp/empQuestion")
public class EmpQuestionList extends HttpServlet {
	
	private QuestionService questionService;
	
	//고객센터 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ArrayList<HashMap<String,Object>> list = null;
		this.questionService = new QuestionService();
		list = questionService.empGetQuestionListByPage();
		
		request.setAttribute("questionList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empQuestionList.jsp").forward(request, response);
	}

}
