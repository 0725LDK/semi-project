package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;


@WebServlet("/goods/goodsMain")
public class GoodsMainController extends HttpServlet {
	private GoodsService goodsService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색 기능
		request.setCharacterEncoding("UTF-8"); // 한글 처리
		String goodsSearch = request.getParameter("goodsSearch");	
		System.out.println("goodsSearch : " + goodsSearch);			
				
		goodsService = new GoodsService();	
		
		// 전체 상품 
		ArrayList<HashMap<String, Object>> list = goodsService.getGoodsList(goodsSearch);
		request.setAttribute("list", list);
		request.setAttribute("goodsSearch", goodsSearch); // view에서 필요		
		System.out.println(list+"<--MainController list");
		System.out.println(goodsSearch+"<--MainController list");		

		request.getRequestDispatcher("/WEB-INF/view/goods/goodsMain.jsp").forward(request, response);
	}

}
