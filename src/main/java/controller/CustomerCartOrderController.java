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

import service.CartService;
import service.CustomerService;
import service.OrderService;
import vo.Customer;
import vo.CustomerAddress;
import vo.Order;


@WebServlet("/customer/customerCartOrder")
public class CustomerCartOrderController extends HttpServlet {
	private CartService cartService;
	private CustomerService customerService;
	private OrderService orderService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		// 세션 로그인 아이디
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartOrderController");
		
		ArrayList<CustomerAddress> ca = new ArrayList<CustomerAddress>();
		Customer customer = new Customer();
		customerService = new CustomerService();
		// 주문 회원정보
		customer = customerService.getSelectCustomerOne(customerId);
		// 회원주소 리스트
		ca = customerService.getSelectCustomerAddressList(customerId);
		// 장바구니에 담긴 리스트
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> m, n = new HashMap<String, Object>();
		cartService = new CartService();
		// 장바구니 리스트
		list = cartService.getSelectCartList(customerId);
		// 장바구니 가격 합계
		m = cartService.getSelectSumByCart(customerId);
		// 장바구니 수량 합계
		n = cartService.getSelectCartQuantitySum(customerId);
		
		request.setAttribute("list", list); // 장바구니 리스트
		request.setAttribute("m", m); // 장바구니 가격 합계
		request.setAttribute("n", n); // 장바구니 수량 합계
		request.setAttribute("customer", customer); // 주문회원정보
		request.setAttribute("ca", ca); // 회원주소 리스트
		
		request.getRequestDispatcher("/WEB-INF/view/customer/customerCartOrder.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리 인코딩
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 로그인 안되어있으면 /home/login
		if(session.getAttribute("loginCustomer") == null) {
			response.sendRedirect(request.getContextPath()+"/home/login");
			return;
		}
		// 세션 로그인 아이디
		Customer loginCustomer = (Customer)session.getAttribute("loginCustomer");
		String customerId = loginCustomer.getCustomerId();
		System.out.println(customerId+" : customerId CustomerCartOrderController");
		// 주문시 선택한 주소
		String address = request.getParameter("address");
		System.out.println(address+" : address CustomerCartOrderController");
		// 주소 code값 받기
		customerService = new CustomerService();
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress = customerService.getSelectCustomerAddressCode(customerId, address);
		int customerAddressCode = customerAddress.getAddressCode();
		System.out.println(customerAddressCode+" : customerAddressCode CustomerCartOrderController");
		// 주문 가격
		int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
		System.out.println(orderPrice+" : orderPrice CustomerCartOrderController");
		String orderState = "결제"; 
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		cartService = new CartService();
		list = cartService.getSelectCartList(customerId);
		System.out.println(list.size() +"list.size()"); // list 크기 확인
		
		orderService = new OrderService();
		
		String code = null;
		String quantity = null;
		String price = null;
		for(int i=0; i<list.size(); i++) { // 장바구니에 있는 상품수만큼 반복
			code = list.get(i).get("goodsCode").toString(); // list에 저장된 goodsCode 가져오기
			quantity = list.get(i).get("cartQuantity").toString(); // list에 저장된 cartQuantity 가져오기
			int goodsCode = Integer.parseInt(code);
			int orderQuantity = Integer.parseInt(quantity);
			
			Order order = new Order();
			order.setGoodsCode(goodsCode);
			order.setOrderQuantity(orderQuantity);
			order.setOrderPrice(orderPrice);
			order.setCustomerId(customerId);
			order.setOrderState(orderState);
			order.setAddressCode(customerAddressCode);
			
			int row = orderService.customerGetAddOrder(order);
			if(row == 0) {
				System.out.println("주문실패 CustomerCartOrderController, customerGetAddOrder");
			} else {
				System.out.println("주문성공 CustomerCartOrderController, customerGetAddOrder");
			}
			
			if(i == (list.size()-1)) { // order테이블 입력이 끝난후 
				// /customer/customerOrderList
				response.sendRedirect(request.getContextPath()+"/customer/customerOrderList");
			}
			
		}
		

		
	}

}
