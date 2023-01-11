package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Order;

public class OrderDao {
	
	//고객 주문 내역 리스트 업(취소제외)
	public ArrayList<HashMap<String,Object>> customerOrderList(Connection conn, String customerId)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " WHERE od.customer_id = ? AND od.order_state != '취소' ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> o = new HashMap<String,Object>();
			o.put("orderCode",rs.getInt("orderCode"));
			o.put("goodsname",rs.getString("goodsname"));
			o.put("customerId",rs.getString("customerId"));
			o.put("address",rs.getString("address"));
			o.put("orderQuantity",rs.getInt("orderQuantity"));
			o.put("orderPrice",rs.getInt("orderPrice"));
			o.put("orderState",rs.getString("orderState"));
			o.put("reviewMemo",rs.getString("reviewMemo"));
			o.put("createdate",rs.getString("createdate"));
			list.add(o);
		}
		return list;
	}
	
	//고객 상품 구입 & orderList 추가
	public int addCustomerOrder(Connection conn, Order order) throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO orders(goods_code,customer_id,address_code,order_quantity,order_price,order_state,createdate)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, order.getGoodsCode());
		stmt.setString(2, order.getCustomerId());
		stmt.setInt(3, order.getAddressCode());
		stmt.setInt(4, order.getOrderQuantity());
		stmt.setInt(5, order.getOrderPrice());
		stmt.setString(6, order.getOrderState());
		
		row = stmt.executeUpdate();

		return row;
	}
	
	//고객 주문내역 결제상태 수정
	public int updateCustomerOrderState(Connection conn, String orderState, int orderCode) throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE orders SET order_state = ? WHERE order_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, orderState);
		stmt.setInt(2, orderCode);
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//고객 주문내역 구매 확정 한정 리뷰 작성
	public int addOrderConfirmReview(Connection conn, int orderCode, String reviewMemo)throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO review(order_code, review_memo, createdate)VALUES(?,?,CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		stmt.setString(2, reviewMemo);
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//리뷰 삭제
	public int deleteOrderReview(Connection conn, int orderCode) throws Exception
	{
		int row = 0;
		
		String sql = "DELETE FROM review WHERE order_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//관리자 전체 고객 주문 내역 확인
	public ArrayList<HashMap<String,Object>> empOrderListAll(Connection conn)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> o = new HashMap<String,Object>();
			o.put("orderCode",rs.getInt("orderCode"));
			o.put("goodsname",rs.getString("goodsname"));
			o.put("customerId",rs.getString("customerId"));
			o.put("address",rs.getString("address"));
			o.put("orderQuantity",rs.getInt("orderQuantity"));
			o.put("orderPrice",rs.getInt("orderPrice"));
			o.put("orderState",rs.getString("orderState"));
			o.put("reviewMemo",rs.getString("reviewMemo"));
			o.put("createdate",rs.getString("createdate"));
			list.add(o);
		}
		return list;
	}
	
	//관리자 고객 주문 내역 상태 변경
	public int empCustomerOrderStateUpdate(Connection conn, String orderState, int orderCode) throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE orders SET order_state = ? WHERE order_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, orderState);
		stmt.setInt(2, orderCode);
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//고객 주문 취소 내역 
	public ArrayList<HashMap<String,Object>> customerOrderCancleList(Connection conn, String customerId)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " WHERE od.customer_id = ?  AND od.order_state = '취소' ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> o = new HashMap<String,Object>();
			o.put("orderCode",rs.getInt("orderCode"));
			o.put("goodsname",rs.getString("goodsname"));
			o.put("customerId",rs.getString("customerId"));
			o.put("address",rs.getString("address"));
			o.put("orderQuantity",rs.getInt("orderQuantity"));
			o.put("orderPrice",rs.getInt("orderPrice"));
			o.put("orderState",rs.getString("orderState"));
			o.put("createdate",rs.getString("createdate"));
			list.add(o);
		}
		return list;
	}
	
	//고객 주문 취소 
	public int updateCustomerOrderStateCancle(Connection conn, int orderCode) throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE orders SET order_state = '취소' WHERE order_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		row = stmt.executeUpdate();
		
		return row;
	}
}
