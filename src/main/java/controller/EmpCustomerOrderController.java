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

import service.OrderService;


@WebServlet("/emp/empCustomerOrder")
public class EmpCustomerOrderController extends HttpServlet {
	
	//회원 주문 내역
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 확인
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null && session.getAttribute("loginEmp") == null && session.getAttribute("authCode") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		
		//페이징 변수
		int firstPage = 1;
		int currentPage = 1;
		if(request.getParameter("currentPage") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 10;
		int beginRow = (currentPage-1)*rowPerPage;
		int lastPage = 0;
		int count = 0;//총 고객 주문 수
		
		//검색 변수
		String search = request.getParameter("search");
		
		ArrayList<HashMap<String,Object>> list = null;
		OrderService orderService = new OrderService();
		
		if(search == null)
		{
			list = orderService.empGetOrderListAll(beginRow, rowPerPage);
			count = orderService.empOrderListCount();
		}
		else if(search != null)
		{
			list = orderService.empGetOrderListAllSearch(beginRow, rowPerPage, search);
			count = orderService.empOrderListCountSearch(search);
		}

		lastPage = count/rowPerPage;
		if(count%rowPerPage !=0)
		{
			lastPage = lastPage+1;
		}
	
		request.setAttribute("orderList", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerOrder.jsp").forward(request, response);
	}

}