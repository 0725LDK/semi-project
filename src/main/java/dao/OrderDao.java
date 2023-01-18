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
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsName, od.customer_id customerId "
				+ "		 , ca.address address, order_quantity orderQuantity, order_price orderPrice "
				+ "		 , order_state orderState, od.createdate createdate, re.review_memo reviewMemo "
				+ "		 , rh.order_code rhistoryCode, rh.review_memo rhistoryMemo "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address ca ON od.address_code = ca.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " LEFT OUTER JOIN review_history rh ON od.order_code = rh.order_code "
				+ " WHERE od.customer_id= ? AND order_state != '취소'";
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
			o.put("reviewMemo",rs.getString("reviewMemo"));
			o.put("rhistoryCode",rs.getInt("rhistoryCode"));
			o.put("rhistoryMemo",rs.getString("rhistoryMemo"));
			
			list.add(o);
		}
		return list;
	}
	
	//고객 상품 구입 시 주소 코드 추출
	public int customerAddressCodeGet(Connection conn, String address, String customerId) throws Exception
	{
		int addressCode = 0;
		
		String sql = " SELECT ca.address_code addressCode "
				+ " FROM customer_address ca "
				+ " INNER JOIN customer cu ON ca.customer_id = cu.customer_id "
				+ " WHERE ca.address = ? AND cu.customer_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, address);
		stmt.setString(2, customerId);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
		{
			addressCode = rs.getInt("addressCode");
		}
		System.out.println(address +"<--oderDao addressCode");
		return addressCode;
	}
	
	//고객 상품 구입 & orderList 추가
	public int addCustomerOrder(Connection conn, Order order, int addressCode) throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO orders(goods_code,customer_id,address_code,order_quantity,order_price,order_state,createdate)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, order.getGoodsCode());
		stmt.setString(2, order.getCustomerId());
		stmt.setInt(3, addressCode);
		stmt.setInt(4, order.getOrderQuantity());
		stmt.setInt(5, order.getOrderPrice());
		stmt.setString(6, order.getOrderState());
		
		row = stmt.executeUpdate();

		return row;
	}
	
	//상품구매시 포인트 차감
	public int subCustomerOrderPoint(Connection conn, String customerId, int usedPoint)throws Exception
	{
		int result = 0;
		
		String sql = "INSERT INTO point_history(customer_id,point_kind,POINT,createdate)VALUES(?,'상품구매',?,CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, usedPoint);
		result = stmt.executeUpdate();
		
		return result;
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
	public int addOrderConfirmReview(Connection conn,int orderCode, String customerId, String reviewMemo)throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO review(order_code, review_memo, createdate)VALUES(?,?,CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		stmt.setString(2, reviewMemo);
		row = stmt.executeUpdate();
		
		return row;
	}
	//리뷰 히스토리에 저장
	public int addReviewHistory(Connection conn, int orderCode, String reviewMemo)throws Exception
	{
		int addReviewHistory = 0;
		
		String sql = "INSERT INTO review_history(order_code, review_memo, createdate)VALUES(?,?,CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderCode);
		stmt.setString(2, reviewMemo);
		addReviewHistory = stmt.executeUpdate();
		
		return addReviewHistory;
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
	
	//관리자 전체 고객 주문 내역 확인(취소제외 + 검색어 없을때)
	public ArrayList<HashMap<String,Object>> empOrderListAll(Connection conn, int beginRow, int rowPerPage)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " WHERE order_state != '취소'"
				+ " LIMIT ? , ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
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
	
	//관리자 전체 고객 주문 내역 총 건 수(취소제외 + 검색어 없을때)
	public int empOrderListCount(Connection conn) throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count "
				+ "		FROM orders od "
				+ "		INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ "		INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ "		LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ "		WHERE order_state != '취소' ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		
		return count;
	}
	
	//관리자 전체 고객 주문 내역 확인(취소제외 + 검색어 있을때)
	public ArrayList<HashMap<String,Object>> empOrderListAllSearch(Connection conn, int beginRow, int rowPerPage, String search)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " WHERE order_state != '취소' AND od.customer_id LIKE ? "
				+ " LIMIT ? , ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+search+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
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
	
	//관리자 전체 고객 주문 내역 총 건 수(취소제외 + 검색어 있을때)
	public int empOrderListCountSearch(Connection conn,String search) throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count "
				+ "		FROM orders od "
				+ "		INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ "		INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ "		LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ "		WHERE order_state != '취소' AND od.customer_id LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+search+"%");
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		
		return count;
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
	
	//고객 리뷰 작성시 포인트 지급
	public int addCustomerReviewPoint(Connection conn, String customerId,int orderCode)throws Exception
	{
		int result = 0;
		
		String sql = "INSERT INTO point_history(customer_id,point_kind,order_code,POINT,createdate)VALUES(?,'리뷰작성',?,100,CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, orderCode);
		result = stmt.executeUpdate();
		
		return result;
	}
	
	//고객 리뷰 삭제시 포인트 차감
	public int subCustomerReviewPoint(Connection conn, int orderCode, String customerId) throws Exception
	{
		int result = 0;
		
		String sql = "INSERT INTO point_history(customer_id,point_kind,order_code,POINT,createdate)VALUES(?,'리뷰삭제', ? ,-100,CURRENT_TIMESTAMP());";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, customerId);
		stmt.setInt(2, orderCode);
		result = stmt.executeUpdate();
		
		return result;
	}
	
	
}
