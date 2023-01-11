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


@WebServlet("/home/main")
public class MainController extends HttpServlet {
	private GoodsService goodsService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		goodsService = new GoodsService();
		ArrayList<HashMap<String, Object>> list = goodsService.getGoodsList();
		request.setAttribute("list", list);
		System.out.println(list+"<--GoodsListController  list");				

		
		// main.jsp
		request.getRequestDispatcher("/WEB-INF/view/home/main.jsp").forward(request, response);
	}



}
