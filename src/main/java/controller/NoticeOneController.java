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

import service.GoodsService;
import service.NoticeService;
import vo.Customer;


@WebServlet("/notice/noticeOne")
public class NoticeOneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String goodsCategory = null;	
		if(request.getParameter("goodsCategory") != null){
			goodsCategory = request.getParameter("goodsCategory");
		}
		System.out.println(goodsCategory + "<-- NoticeOneController goodsCategory"); //디버깅
		
		GoodsService goodsService = new GoodsService();
		ArrayList<HashMap<String, Object>> list = goodsService.getGoodsCategoryList(goodsCategory);
		
		request.setAttribute("list", list);
		System.out.println(list+"<--NoticeOneController list");		
		
		
		
		
		// NoticeOne
		int noticeCode = 0;	
		if(request.getParameter("noticeCode") != null){
			noticeCode = Integer.parseInt(request.getParameter("noticeCode"));
		}
		// 디버깅
		System.out.println(noticeCode + "<-- GoodsOneController goodsCode"); 
		
	    HashMap<String, Object> map = new HashMap<String, Object>();
		NoticeService noticeService = new NoticeService();
		map = noticeService.getNoticeOne(noticeCode);
	    
		request.setAttribute("map", map); // view 페이지와 공유할 모델데이터 저장
			
		//view
		request.getRequestDispatcher("/WEB-INF/view/goods/goodsList.jsp").forward(request, response);
	}


}
