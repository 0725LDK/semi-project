package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.QuestionService;
import vo.QuestionComment;


@WebServlet("/emp/empQuestionAdd")
public class EmpQuestionAddController extends HttpServlet {
	
	//관리자 고객센터 문의 답변 폼 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		String questionMemo = request.getParameter("questionMemo");
		System.out.println(questionCode);
		
		request.setAttribute("questionCode", questionCode);
		request.setAttribute("questionMemo", questionMemo);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empQuestionAdd.jsp").forward(request, response);
	}

	//관리자 고객센터 문의 답변 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int questionCode = Integer.parseInt(request.getParameter("questionCode"));
		String commentMemo = request.getParameter("commentMemo");
		
		QuestionComment questionComment = new QuestionComment();
		questionComment.setQuestionCode(questionCode);
		questionComment.setCommentMemo(commentMemo);
		
		QuestionService questionService = new QuestionService();
		questionService.empGetAddQuestion(questionComment);
		
		System.out.println("문의사항 답변 추가 성공");
		response.sendRedirect(request.getContextPath()+"/emp/empQuestionList");
	}

}