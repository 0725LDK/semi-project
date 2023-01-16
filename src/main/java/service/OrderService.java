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
	public int customerGetAddOrder(Order order, String address, String customerId)
	{
		int row = 0;
		int addressCode = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			addressCode = orderDao.customerAddressCodeGet(conn, address, customerId);
			System.out.println(address +"<--oderService addressCode");
			if(addressCode != 1)
			{
				System.out.println("주소코드 추출 실패");
				throw new Exception();
			}
			else if(addressCode == 1)
			{
				System.out.println("주소코드 추출 성공");
				row = orderDao.addCustomerOrder(conn, order, addressCode);
				if(row != 1)
				{
					System.out.println("주소코드 추출 성공 후 주문내역 추가 실패");
					throw new Exception();
				}
				else if(row == 1)
				{
					row = addressCode;
					System.out.println("주소코드 추출 성공 후 주문내역 추가 성공");
				}
			}
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
	
	//고객 주문 - 주문 내역 추가 By Cart
	public int customerGetAddOrderByCart(Order order, int addressCode)
	{
		int row = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = orderDao.addCustomerOrder(conn, order, addressCode);
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
	
	//고객 주문내역 구매 확정 한정 리뷰 작성 + 포인트 지급 + 리뷰히스토리 저장
	public int addOrderConfirmReview(int orderCode, String reviewMemo)
	{
		int row = 0;
		int result = 0;
		int addReviewHistory = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			row = orderDao.addOrderConfirmReview(conn, orderCode, reviewMemo);
			if(row != 1)
			{
				System.out.println("review 추가 실패");
				throw new Exception();
			}
			else if(row == 1)
			{
				System.out.println("review 추가 성공");
				result = orderDao.addCustomerReviewPoint(conn, orderCode);
				if(result != 1)
				{
					System.out.println("review 추가 후 point 적립 실패");
				}
				else if(result==1)
				{
					addReviewHistory = orderDao.addReviewHistory(conn, orderCode, reviewMemo);
					
					if(addReviewHistory != 1)
					{
						System.out.println("review 추가 후 point 적립 성공 후 reviewHistory 저장 실패");
					}
					else if(addReviewHistory == 1)
					{
						row = addReviewHistory ;
						System.out.println("review 추가 후 point 적립 성공 후 reviewHistory 저장 성공");
					}
				}
			}
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
	
	//고객 리뷰 삭제 + 포인트 차감
	public int deleteOrderReview(int orderCode)
	{
		int row = 0;
		int result = 0;
		orderDao = new OrderDao();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = orderDao.deleteOrderReview(conn, orderCode);
			if(row != 1)
			{
				System.out.println("review 삭제 실패");
				throw new Exception();
			}
			else if(row == 1)
			{
				System.out.println("review 삭제 성공");
				result = orderDao.subCustomerReviewPoint(conn, orderCode);
				if(result != 1)
				{
					System.out.println("review 삭제 성공 + 포인트 차감 실패");
					throw new Exception();
				}
				else if(result == 1)
				{
					row = result;
					System.out.println("review 삭제 성공 + 포인트 차감 성공");
				}
			}
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
