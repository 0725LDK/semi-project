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
	public ArrayList<HashMap<String,Object>> customerGetOrderList(String customerId)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			orderDao = new OrderDao();
			list = orderDao.customerOrderList(conn, customerId); 
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
	
	//고객 주문내역 결제상태 수정
	public int  customerGetUpdateOrderState(String orderState, int orderCode)
	{
		int row = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			row = orderDao.updateCustomerOrderState(conn, orderState, orderCode);
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
	
	//고객 주문내역 구매 확정 한정 리뷰 작성
	public int addOrderConfirmReview(int orderCode, String reviewMemo)
	{
		int row = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			row = orderDao.addOrderConfirmReview(conn, orderCode, reviewMemo);
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
	
	//고객 리뷰 삭제
	public int deleteOrderReview(int orderCode)
	{
		int row = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = orderDao.deleteOrderReview(conn, orderCode);
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
	
	//관리자 전체 고객 주문 내역 확인 
	public ArrayList<HashMap<String,Object>> empGetOrderListAll()
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			orderDao = new OrderDao();
			list = orderDao.empOrderListAll(conn); 
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
		
	//관리자 고객 주문 내역 상태 변경
	public int empCustomerOrderStateUpdate(String orderState, int orderCode)
	{
		int row = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			row = orderDao.empCustomerOrderStateUpdate(conn, orderState, orderCode);
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
	
	//고객 취소 내역 리스트
	public ArrayList<HashMap<String,Object>> customerOrderCancleList(String customerId)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			orderDao = new OrderDao();
			list = orderDao.customerOrderCancleList(conn, customerId); 
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
	
	//고객 주문 취소
	public int updateCustomerOrderStateCancle(int orderCode)
	{
		int row = 0;
		
		orderDao = new OrderDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			row = orderDao.updateCustomerOrderStateCancle(conn, orderCode);
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
