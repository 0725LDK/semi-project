package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;


@WebServlet("/emp/empNoticeList")
public class EmpNoticeListController extends HttpServlet {
	private NoticeService noticeService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		noticeService = new NoticeService();
		ArrayList<HashMap<String, Object>> list = noticeService.getNoticeList();
		request.setAttribute("list", list);
		System.out.println(list+"<--EmpNoticeListController list");		
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empNoticeList.jsp").forward(request, response);
	}

	
}
