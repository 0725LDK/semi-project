package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import vo.Customer;


public class CartDao {
	
	// goods list
	public HashMap<String, Object> selectGoodsByOne(Connection conn, int goodsCode) throws Exception {
		HashMap<String, Object> m = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, i.filename filename"
				+ " FROM goods g"
				+ " INNER JOIN goods_img i"
				+ " ON g.goods_code = i.goods_code"
				+ " WHERE g.goods_code = ?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			m = new HashMap<String, Object>();
			m.put("goodsCode", rs.getInt("goodsCode"));
			m.put("goodsName", rs.getString("goodsName"));
			m.put("goodsPrice", rs.getInt("goodsPrice"));
			m.put("filename", rs.getString("filename"));			
		}
		
		return m;
	}
	
	// cart insert
	public int addCart(Connection conn, String customerId, int goodsCode) throws Exception {
		int result = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO cart (goods_code, customer_id, cart_quantity)"
				+ " VALUES (?, ?, '1')";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		stmt.setString(2, customerId);

		
		result = stmt.executeUpdate();
		
		return result;
	}
	
}
