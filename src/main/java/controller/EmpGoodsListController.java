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

@WebServlet("/emp/empGoodsList")
public class EmpGoodsListController extends HttpServlet {
	private GoodsService goodsService;
	
	//관리자 상품 리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		// 검색 기능
		String goodsSearch = request.getParameter("goodsSearch");	
		System.out.println("goodsSearch : " + goodsSearch);			
				
		goodsService = new GoodsService();		
		ArrayList<HashMap<String, Object>> list = goodsService.getGoodsList(goodsSearch);
		request.setAttribute("list", list);
		request.setAttribute("goodsSearch", goodsSearch); // view에서 필요	
		
		System.out.println(list+"<--EmpGoodsListController list");
		System.out.println(goodsSearch+"<--EmpGoodsListController list");
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empGoodsList.jsp").forward(request, response);
	}
}