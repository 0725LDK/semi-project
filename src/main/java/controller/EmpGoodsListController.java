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



@WebServlet("/emp/empGoodsList")
public class EmpGoodsListController extends HttpServlet {
	private GoodsService goodsService;
	
	//상품정보 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goodsService = new GoodsService();
		ArrayList<HashMap<String, Object>> list = goodsService.getGoodList();
		request.setAttribute("list", list);
		System.out.println(list+"<--EmpGoodsListController list");

		request.getRequestDispatcher("/WEB-INF/view/emp/empGoodsList.jsp").forward(request, response);
		
		
		
		
		
	}

}
