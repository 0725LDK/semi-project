package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import vo.Order;


@WebServlet("/customer/customerOrder")
public class CustomerOrderController extends HttpServlet {
	
	//고객 주문 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerOrder.jsp").forward(request, response);
	}
	
	//고객 주문 - 주문 리스트 추가 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		String customerId = request.getParameter("customerId");
		int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
		int orderPrice = Integer.parseInt(request.getParameter("totalPrice"));
		int address = Integer.parseInt(request.getParameter("address"));
		String orderState = "결제";
		
		Order order = new Order();
		order.setGoodsCode(goodsCode);
		order.setCustomerId(customerId);
		order.setOrderQuantity(orderQuantity);
		order.setOrderPrice(orderPrice);
		order.setAddressCode(address);
		order.setOrderState(orderState);
		
		OrderService orderService = new OrderService();
		orderService.customerGetAddOrder(order);
		
		System.out.println("order 성공");
		response.sendRedirect(request.getContextPath()+"/customer/customerOrderList");
	}

}