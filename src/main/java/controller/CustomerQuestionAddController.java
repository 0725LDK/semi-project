package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import vo.Question;


@WebServlet("/customer/customerQuestionAdd")
public class CustomerQuestionAddController extends HttpServlet {
	
	private QuestionService questionService;
	
	//고객센터 추가 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ordersCode = Integer.parseInt(request.getParameter("ordersCode"));
		System.out.println(ordersCode);
		request.setAttribute("ordersCode", ordersCode);
		
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerQuestionAdd.jsp").forward(request, response);
	}

	//고객센터 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int ordersCode = Integer.parseInt(request.getParameter("ordersCode"));
		String category = request.getParameter("category");
		String questionMemo = request.getParameter("questionMemo");
		System.out.println(ordersCode + "<---고객센터 주문번호");
		System.out.println(category + "<---고객센터 문의사항");
		System.out.println(questionMemo + "<---고객센터 문의내용");
		

		Question question = new Question();
		question.setOrdersCode(ordersCode);
		question.setCategory(category);
		question.setQuestionMemo(questionMemo);
		
		this.questionService = new QuestionService();
		questionService.customerGetAddQuestion(ordersCode, question);
		
		System.out.println("문의사항 추가 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerQuestion");
	}

}