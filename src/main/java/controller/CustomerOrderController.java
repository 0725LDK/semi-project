package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;
import service.GoodsService;
import service.OrderService;
import vo.Customer;
import vo.Order;


@WebServlet("/customer/customerOrder")
public class CustomerOrderController extends HttpServlet {
	
	//고객 주문 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		if(loginCustomer == null) { // 로그아웃 상태
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;

		}  
		
		String customerId = loginCustomer.getCustomerId();
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getSelectCustomerOne(customerId);
		request.setAttribute("customer", customer);
		
		int goodsQuantity = Integer.parseInt(request.getParameter("goodsQuantity"));
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		
		// goodsOne
		int goodsCode = 0;	
		if(request.getParameter("goodsCode") != null){
			goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		}
		// 디버깅
		System.out.println(goodsCode + "<-- GoodsOneController goodsCode"); 
		
	    HashMap<String, Object> map = new HashMap<String, Object>();
		GoodsService goodsService = new GoodsService();
		map = goodsService.getGoodsOne(goodsCode);    
		request.setAttribute("map", map); // view 페이지와 공유할 모델데이터 저장	
		request.setAttribute("goodsQuantity", goodsQuantity); 
		request.setAttribute("totalPrice", totalPrice); 	
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerOrder.jsp").forward(request, response);
	}
	
	//고객 주문 - 주문 리스트 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		String customerId = request.getParameter("customerId");
		System.out.println(customerId+"<--customerId controller");
		String address = request.getParameter("address");
		int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
		int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
		int usedPoint = Integer.parseInt(request.getParameter("usedPoint"));
		String orderState = "결제";
		
		Order order = new Order();
		order.setGoodsCode(goodsCode);
		order.setCustomerId(customerId);
		order.setOrderQuantity(orderQuantity);
		order.setOrderPrice(orderPrice);
		order.setOrderState(orderState);
		
		OrderService orderService = new OrderService();
		orderService.customerGetAddOrder(order, address, customerId);
		orderService.subCustomerOrderPoint(customerId, usedPoint);
		
		System.out.println("order 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerOrderList");
	}

}