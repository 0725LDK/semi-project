package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;


@WebServlet("/customer/customerQuestionModify")
public class CustomerQuestionModifyController extends HttpServlet {
	
	//고객센터 수정 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		int ordersCode = Integer.parseInt(request.getParameter("ordersCode"));
		String category = request.getParameter("category");
		
		request.setAttribute("questionCode", questionCode);
		request.setAttribute("ordersCode", ordersCode);
		request.setAttribute("category", category);
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerQuestionModify.jsp").forward(request, response);
	}

	//고객센터 수정 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		String questionMemo = request.getParameter("questionMemo");
		
		Question question = new Question();
		question.setQuestionCode(questionCode);
		question.setQuestionMemo(questionMemo);
		
		QuestionService questionService = new QuestionService();
		questionService.customerGetupdateQuestion(question);
		
		System.out.println("고객센터 수정 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerQuestion");
		
	}

}