package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import service.GoodsService;


@WebServlet("/home/main")
public class MainController extends HttpServlet {
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

		// 인기 상품
		int hit = 0;
		ArrayList<HashMap<String, Object>> hitList = goodsService.getGoodsHitList(hit);
		request.setAttribute("hitList", hitList);
		System.out.println(hitList+"<--MainController hitList");	
		
		// 신상품(상품 등록 순서로 출력-> 총 4개)
		ArrayList<HashMap<String, Object>> newList = goodsService.getGoodsNewList(0, 4);
		request.setAttribute("newList", newList);
		System.out.println(newList+"<--MainController newList");	
		
		// main.jsp
		request.getRequestDispatcher("/WEB-INF/view/home/main.jsp").forward(request, response);
	}
}
