package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;


@WebServlet("/emp/empCustomerOrder")
public class EmpCustomerOrderController extends HttpServlet {
	
	//회원 주문 내역
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<HashMap<String,Object>> list = null;
		OrderService orderService = new OrderService();
		list = orderService.empGetOrderListAll();
	
		request.setAttribute("orderList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/empCustomerOrder.jsp").forward(request, response);
	}

}