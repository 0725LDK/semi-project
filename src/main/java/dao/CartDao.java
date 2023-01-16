package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Cart;


public class CartDao {
	
	// cartList 장바구니 내역확인
	public ArrayList<HashMap<String, Object>> selectCartList(Connection conn, String customerId) throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT c.goods_code goodsCode, c.cart_quantity cartQuantity, g.goods_name goodsName, g.goods_price goodsPrice, gi.filename filename"
				+ " FROM cart c"
				+ "		INNER JOIN goods g ON c.goods_code = g.goods_code"
				+ "		INNER JOIN goods_img gi ON c.goods_code = gi.goods_code"
				+ " WHERE c.customer_id = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("goodsCode", rs.getInt("goodsCode"));
			m.put("cartQuantity", rs.getInt("cartQuantity"));
			m.put("goodsName", rs.getString("goodsName"));
			m.put("goodsPrice", rs.getInt("goodsPrice"));
			m.put("filename", rs.getString("filename"));
			list.add(m);
		}
		return list;
	}
	
	// cart insert
	public int addCart(Connection conn, Cart cart) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO cart (goods_code, customer_id, cart_quantity)"
				+ " VALUES (?, ?, ?)";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cart.getGoodsCode());
		stmt.setString(2, cart.getCustomerId());
		stmt.setInt(3, cart.getCartQuantity());

		result = stmt.executeUpdate();
		
		return result;
	}
	
	// cartList 합계
	public HashMap<String, Object> selectCartListSumByCart(Connection conn, String customerId) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SUM(t.cartQuantity*t.goodsPrice) sumPrice"
				+ " FROM (SELECT c.goods_code goodsCode"
				+ "				, c.cart_quantity cartQuantity"
				+ "				, g.goods_price goodsPrice"
				+ " 	FROM cart c"
				+ "			INNER JOIN goods g ON c.goods_code = g.goods_code"
				+ " WHERE c.customer_id = 'goodee') t";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			m.put("sumPrice", rs.getInt("sumPrice"));
		}
		return m;
	}
	
	// cartQuantity 합계
	public HashMap<String, Object> selectCartQuantitySum(Connection conn, String customerId) throws Exception {
		HashMap<String, Object> m = new HashMap<String, Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SUM(t.cartQuantity) sumQuantity"
				+ "	FROM (SELECT c.goods_code goodsCode"
				+ "				, c.cart_quantity cartQuantity"
				+ "				, g.goods_price goodsPrice"
				+ "		FROM cart c\r\n"
				+ "			INNER JOIN goods g ON c.goods_code = g.goods_code"
				+ " 	WHERE c.customer_id = 'goodee') t";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			m.put("sumQuantity", rs.getInt("sumQuantity"));
		}
		return m;
	}
	
	// 현재 장바구니에 있는 상품인지 확인
	public int selectCartOneCk(Connection conn, Cart cart) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM cart"
				+ " WHERE goods_code = ? AND customer_id = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cart.getGoodsCode());
		stmt.setString(2, cart.getCustomerId());
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = 1; // 저장된 값이 있으면 
		}
		return result;
	}
	
	// 현재 장바구니에 있는 상품일시 수량 +
	public int modifyCartQuantityBySum(Connection conn, Cart cart) throws Exception {
		int upResult = 0;
		PreparedStatement stmt = null;
		String sql = "UPDATE cart SET cart_quantity = ? + cart_quantity"
				+ " WHERE goods_code = ? AND customer_id = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cart.getCartQuantity());
		stmt.setInt(2, cart.getGoodsCode());
		stmt.setString(3, cart.getCustomerId());
		
		upResult = stmt.executeUpdate();
		
		return upResult;
	}
	
	// 장바구니 수량 수정
	public int modifyCartQuantity(Connection conn, Cart cart) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "UPDATE cart SET cart_quantity = ?"
				+ " WHERE goods_code = ? AND customer_id = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cart.getCartQuantity());
		stmt.setInt(2, cart.getGoodsCode());
		stmt.setString(3, cart.getCustomerId());
		
		result = stmt.executeUpdate();
		
		return result;
	}
	
	// 장바구니 상품 삭제버튼
	public int removeCartOne(Connection conn, Cart cart) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM cart WHERE goods_code = ? AND customer_id = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, cart.getGoodsCode());
		stmt.setString(2, cart.getCustomerId());
		
		result = stmt.executeUpdate();
		
		return result;
	}
	
	// 구매완료시 장바구니상품 삭제
	public int removeCartById(Connection conn, String customerId) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM cart WHERE customer_id = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		
		result = stmt.executeUpdate();
		
		return result;
	}
	
}
