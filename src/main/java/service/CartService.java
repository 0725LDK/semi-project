package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import dao.CartDao;
import util.DBUtil;

public class CartService {
	private CartDao cartDao;
	// CustomerCartController goodsOne 장바구니에담긴 상품정보
	public HashMap<String, Object> getSelectGoodsOne(int goodsCode) {
		HashMap<String, Object> m = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			m = cartDao.selectGoodsByOne(conn, goodsCode);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CustomerService : CustomerLogin");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public int getAddCart(String customerId, int goodsCode) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			result = cartDao.addCart(conn, customerId, goodsCode);
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getAddCart");
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
