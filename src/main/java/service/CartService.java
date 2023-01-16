package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.CartDao;
import dao.GoodsDao;
import util.DBUtil;
import vo.Cart;

public class CartService {
	private CartDao cartDao;
	private GoodsDao goodsDao;
	
	// CustomerCartController 장바구니에 담긴 상품 정보 list
	public ArrayList<HashMap<String, Object>> getSelectCartList(String customerId) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			list = cartDao.selectCartList(conn, customerId);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectCartList");
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
		return list;
	}
	
	// CustomerCartController 장바구니테이블 insert
	public int getAddCart(Cart cart) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			result = cartDao.addCart(conn, cart);
			conn.commit();
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
	
	
	// 비회원 장바구니
	public HashMap<String, Object> addCart(int goodsCode) {
		HashMap<String, Object> m = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			goodsDao = new GoodsDao();
			m = goodsDao.selectGoodsOne(conn, goodsCode);
			
			conn.commit();
		} catch (Exception e) {
			try {
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
	
	
	
	
	// CustomerCartController 장바구니 상품가격 합계
	public HashMap<String, Object> getSelectSumByCart(String customerId) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			m = cartDao.selectCartListSumByCart(conn, customerId);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectSumByCart");
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
	
	// CustomerCartController 장바구니 상품수량 합계 
	public HashMap<String, Object> getSelectCartQuantitySum(String customerId) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			m = cartDao.selectCartQuantitySum(conn, customerId);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectCartQuantitySum");
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
	
	// CustomerCartController 현재 장바구니에 들어있는 상품인지 확인
	public int getSelectCartOneCk(Cart cart) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			result = cartDao.selectCartOneCk(conn, cart);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectCartOneCk");
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
	
	// CustomerCartController 현재 장바구니에 들어있으면 수량 +
	public int getModifyCartQuantityBySum(Cart cart) {
		int upResult = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			upResult = cartDao.modifyCartQuantityBySum(conn, cart);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectCartOneCk");
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
		return upResult;
	}
	
	// CustomerCartModifyController 수량 수정
	public int getModifyCartQuantity(Cart cart) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			result = cartDao.modifyCartQuantity(conn, cart);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectCartOneCk");
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
	
	// CustomerCartRemoveController 장바구니 상품 삭제
	public int getRemoveCartOne(Cart cart) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			cartDao = new CartDao();
			result = cartDao.removeCartOne(conn, cart);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CartService : getSelectCartOneCk");
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
