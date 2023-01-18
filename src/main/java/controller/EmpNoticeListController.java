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

import service.NoticeService;


@WebServlet("/emp/empNoticeList")
public class EmpNoticeListController extends HttpServlet {
	private NoticeService noticeService;
	
	//관리자 이벤트 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		noticeService = new NoticeService();
		ArrayList<HashMap<String, Object>> list = noticeService.getNoticeList();
		request.setAttribute("list", list);
		System.out.println(list+"<--EmpNoticeListController list");		
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empNoticeList.jsp").forward(request, response);
	}

	
}
