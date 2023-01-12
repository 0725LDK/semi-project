package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;
import service.NoticeService;


@WebServlet("/emp/empNoticeOne")
public class EmpNoticeOneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		// 로그인 후에만 진입가능
	
		HttpSession session = request.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) { // 로그아웃 상태
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
	*/	
		
		// noticeOne
		int noticeCode = 0;	
		if(request.getParameter("noticeCode") != null){
			noticeCode = Integer.parseInt(request.getParameter("noticeCode"));
		}
		// 디버깅
		System.out.println(noticeCode + "<-- EmpNoticeOneController noticeCode"); 
		
	    HashMap<String, Object> map = new HashMap<String, Object>();
		NoticeService noticeService = new NoticeService();
		map = noticeService.getNoticeOne(noticeCode);
	    
		request.setAttribute("map", map); // view 페이지와 공유할 모델데이터 저장
		
		// view
		request.getRequestDispatcher("/WEB-INF/view/emp/empNoticeOne.jsp").forward(request, response);

	
	}
	

}
