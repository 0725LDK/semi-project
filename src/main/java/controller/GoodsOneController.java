package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;

@WebServlet("/goods/goodsOne")
public class GoodsOneController extends HttpServlet {

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
		// goodsOne
		int goodsCode = 0;	
		int goodsPrice = 0;
		if(request.getParameter("goodsCode") != null){
			goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		}
		// 디버깅
		System.out.println(goodsCode + "<-- GoodsOneController goodsCode"); 
		
	    HashMap<String, Object> map = new HashMap<String, Object>();
		GoodsService goodsService = new GoodsService();
		map = goodsService.getGoodsOne(goodsCode);
		goodsPrice = (int)(map.get("goodsPrice"));
		System.out.println(goodsPrice+"<---goodsOneController goodsPrice 값");
		request.setAttribute("map", map); // view 페이지와 공유할 모델데이터 저장
		request.setAttribute("goodsPrice", goodsPrice);
		// view
		request.getRequestDispatcher("/WEB-INF/view/goods/goodsOne.jsp").forward(request, response);

	
	}
		
}
