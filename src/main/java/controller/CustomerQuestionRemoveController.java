package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;


@WebServlet("/customer/customerQuestionRemove")
public class CustomerQuestionRemoveController extends HttpServlet {
       
	//고객센터 삭제 액션
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		
		QuestionService questionService = new QuestionService();
		
		int row = questionService.getDeleteQuestion(questionCode);
		if(row != 1)
		{
			System.out.println("삭제실패");
			response.sendRedirect(request.getContextPath()+"/customer/customerQuestion");
			return;
		}
		
		System.out.println("고객센터 삭제 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerQuestion");
	}

	
	

}
