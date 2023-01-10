package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.OrderDao;
import util.DBUtil;
import vo.Order;

public class OrderService {
	private OrderDao orderDao;
	
	//고객 주문 내역 리스트
	public ArrayList<HashMap<String,Object>> customerGetOrderList()
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			orderDao = new OrderDao();
			list = orderDao.customerOrderList(conn); 
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	//고객 주문 - 주문 내역 추가
	public int customerGetAddOrder(Order order)
	{
		int row = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = orderDao.addCustomerOrder(conn, order);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
}
