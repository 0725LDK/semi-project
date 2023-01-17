package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Customer;
import vo.Emp;

public class EmpDao {
	// emp 관리자 화면에서 고객 리스트업 (검색어 없을때)
	public ArrayList<Customer> empSelectCustomerList(Connection conn, int beginRow, int rowPerPage)throws Exception
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		String sql = "SELECT customer_code customerCode, cu.customer_id customerId, customer_name customerName,"
				+ "		 customer_phone customerPhone, ca.address address, POINT, cu.createdate"
				+ " FROM customer cu"
				+ " INNER JOIN customer_address ca ON cu.customer_id = ca.customer_id"
				+ " LIMIT ?, ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			Customer c = new Customer();
			c.setCustomerCode(rs.getInt("customerCode"));
			c.setCustomerId(rs.getString("customerId"));
			c.setCustomerName(rs.getString("customerName"));
			c.setCustomerPhone(rs.getString("customerPhone"));
			c.setAddress(rs.getString("address"));
			c.setPoint(rs.getInt("point"));
			c.setCreatedate(rs.getString("createdate"));
			list.add(c);
		}
		return list;
	}
	
	// emp 관리자 화면에서 고객 리스트업 (검색어 있을때)
		public ArrayList<Customer> empSelectCustomerListSearch(Connection conn, int beginRow, int rowPerPage, String search)throws Exception
		{
			ArrayList<Customer> list = new ArrayList<Customer>();
			
			String sql = "SELECT customer_code customerCode, cu.customer_id customerId, customer_name customerName, "
					+ "		 customer_phone customerPhone, ca.address address, POINT, cu.createdate "
					+ " FROM customer cu "
					+ " INNER JOIN customer_address ca ON cu.customer_id = ca.customer_id "
					+ " WHERE cu.customer_id LIKE ? "
					+ " LIMIT ?, ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
			stmt.setInt(2, beginRow);
			stmt.setInt(3, rowPerPage);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerCode(rs.getInt("customerCode"));
				c.setCustomerId(rs.getString("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerPhone(rs.getString("customerPhone"));
				c.setAddress(rs.getString("address"));
				c.setPoint(rs.getInt("point"));
				c.setCreatedate(rs.getString("createdate"));
				list.add(c);
			}
			return list;
		}
	//emp 고객 리스트 총 수(검색어 없을때)
	public int empCustomerCount(Connection conn) throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count FROM customer";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
		{
			count = rs.getInt("count"); 
			System.out.println(count +"<---empDao count 수");
		}
		
		return count;
	}
	
	//emp 고객 리스트 총 수(검색어 있을때)
	public int empCustomerCountSearch(Connection conn, String search) throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count FROM customer WHERE customer_id LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+search+"%");
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
		{
			count = rs.getInt("count"); 
			System.out.println(count +"<---empDao count 수");
		}
		
		return count;
	}
	
	
	//emp 고객 취소 리스트(검색어 없을때)
	public ArrayList<HashMap<String,Object>> empOrderCancleList(Connection conn, int beginRow, int rowPerPage)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " WHERE od.order_state = '취소' "
				+ " LIMIT ?,? ";
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
			o.put("createdate",rs.getString("createdate"));
			list.add(o);
		}
		return list;
	}
	
	//emp 고객 취소 리스트 총 건수(검색어 없을때)
	public int empOrderCancleListCount(Connection conn)throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count "
				+ "				FROM orders od "
				+ "				INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ "				INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ "				LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ "				WHERE od.order_state = '취소' ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		return count;
	}
	
	//emp 고객 취소 리스트(검색어 있을때)
	public ArrayList<HashMap<String,Object>> empOrderCancleListSearch(Connection conn, int beginRow, int rowPerPage, String search)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String sql = "SELECT od.order_code orderCode, gd.goods_name goodsname,od.customer_id customerId, cuad.address address, order_quantity orderQuantity, "
				+ "		order_price orderPrice, order_state orderState,re.review_memo reviewMemo ,od.createdate "
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ " LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ " WHERE od.order_state = '취소' AND od.customer_id LIKE ?"
				+ " LIMIT ?,? ";
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
			o.put("createdate",rs.getString("createdate"));
			list.add(o);
		}
		return list;
	}
	
	//emp 고객 취소 리스트 총 건수(검색어 있을때)
	public int empOrderCancleListCountSearch(Connection conn, String search)throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count "
				+ "				FROM orders od "
				+ "				INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ "				INNER JOIN customer_address cuad ON od.address_code = cuad.address_code "
				+ "				LEFT OUTER JOIN review re ON od.order_code = re.order_code "
				+ "				WHERE od.order_state = '취소'  AND od.customer_id LIKE ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+search+"%");
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		return count;
	}
	
	//emp 회원 리뷰 추가&삭제 내역 (검색어 없을때)
	public ArrayList<HashMap<String,Object>> empReviewList(Connection conn, int beginRow, int rowPerPage)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT re.order_code orderCode, od.customer_id customerId, gd.goods_name goodsName "
				+ "			, review_memo reviewMemo, re.createdate reviewDate, ph.point_kind pointKind, ph.createdate pointDate "
				+ " FROM review_history re "
				+ " INNER JOIN orders od ON re.order_code = od.order_code "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " LEFT OUTER JOIN point_history ph ON re.order_code = ph.order_code"
				+ " LIMIT ?,?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> r = new HashMap<String,Object>();
			r.put("orderCode",rs.getInt("orderCode"));
			r.put("customerId",rs.getString("customerId"));
			r.put("goodsname",rs.getString("goodsname"));
			r.put("reviewMemo",rs.getString("reviewMemo"));
			r.put("reviewDate",rs.getString("reviewDate"));
			r.put("pointKind",rs.getString("pointKind"));
			r.put("pointDate",rs.getString("pointDate"));
			list.add(r);
		}
		return list;
	}
	
	////emp 회원 리뷰 추가&삭제 총 건 수 (검색어 없을때)
	public int empReviewListCount(Connection conn)throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count "
				+ "				 FROM review_history re "
				+ "				 INNER JOIN orders od ON re.order_code = od.order_code "
				+ "				 INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ "				 LEFT OUTER JOIN point_history ph ON re.order_code = ph.order_code ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		return count;
	}
	
	//emp 회원 리뷰 추가&삭제 내역 (검색어 있을때)
		public ArrayList<HashMap<String,Object>> empReviewListSearch(Connection conn, int beginRow, int rowPerPage, String search)throws Exception
		{
			ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
			String sql = "SELECT re.order_code orderCode, od.customer_id customerId, gd.goods_name goodsName "
					+ "			, review_memo reviewMemo, re.createdate reviewDate, ph.point_kind pointKind, ph.createdate pointDate "
					+ " FROM review_history re "
					+ " INNER JOIN orders od ON re.order_code = od.order_code "
					+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
					+ " LEFT OUTER JOIN point_history ph ON re.order_code = ph.order_code"
					+ " WHERE od.customer_id LIKE ?"
					+ " LIMIT ?,?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,"%"+search+"%");
			stmt.setInt(2, beginRow);
			stmt.setInt(3, rowPerPage);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				HashMap<String,Object> r = new HashMap<String,Object>();
				r.put("orderCode",rs.getInt("orderCode"));
				r.put("customerId",rs.getString("customerId"));
				r.put("goodsname",rs.getString("goodsname"));
				r.put("reviewMemo",rs.getString("reviewMemo"));
				r.put("reviewDate",rs.getString("reviewDate"));
				r.put("pointKind",rs.getString("pointKind"));
				r.put("pointDate",rs.getString("pointDate"));
				list.add(r);
			}
			return list;
		}
		
		////emp 회원 리뷰 추가&삭제 총 건 수 (검색어 있을때)
		public int empReviewListCountSearch(Connection conn, String search)throws Exception
		{
			int count = 0;
			
			String sql = "SELECT COUNT(*) count"
					+ "			 FROM review_history re "
					+ "			 INNER JOIN orders od ON re.order_code = od.order_code "
					+ "			 INNER JOIN goods gd ON od.goods_code = gd.goods_code "
					+ "			 LEFT OUTER JOIN point_history ph ON re.order_code = ph.order_code "
					+ " 	WHERE od.customer_id LIKE ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,"%"+search+"%");
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				count = rs.getInt("count");
			}
			return count;
		}
		
	
	//emp 주종별 판매금액 합계 + 판매횟수
	public ArrayList<HashMap<String,Object>> empSumAlcoholByCategory(Connection conn)throws Exception
	{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT goods_category goodsCategory, SUM(od.order_price) sumByCategory, COUNT(goods_category) categoryCount"
				+ " FROM orders od "
				+ " INNER JOIN goods gd ON od.goods_code = gd.goods_code "
				+ " WHERE od.order_state = '구매확정' "
				+ " GROUP BY goods_category";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			HashMap<String,Object> s = new HashMap<String,Object>();
			s.put("goodsCategory",rs.getInt("goodsCategory"));
			s.put("sumByCategory",rs.getString("sumByCategory"));
			s.put("categoryCount",rs.getString("categoryCount"));
			list.add(s);
		}
		return list;
	}
	
	//emp 직원 정보 변경
	public int updateEmpInfo(Connection conn, Emp emp) throws Exception
	{
		int row = 0;
		
		String sql = "UPDATE emp SET emp_name = ?, active= ?, auth_code= ? WHERE emp_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpName());
		stmt.setString(2, emp.getActive());
		stmt.setInt(3, emp.getAuthCode());
		stmt.setInt(4,emp.getEmpCode());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	//emp 직원 삭제시 outId에 추가
	public int updateOutIdDeletedEmpId(Connection conn, String empId) throws Exception
	{
		int addOutId = 0;
		
		String sql = "INSERT INTO outid(id)VALUE(?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, empId);
		
		addOutId = stmt.executeUpdate();
		
		return addOutId;
	}
	
	//emp 직원 삭제
	public int deleteEmp(Connection conn, int empCode) throws Exception
	{
		int row = 0;
		
		String sql ="DELETE FROM emp WHERE emp_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, empCode);
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// emp 리스트(검색어 없을때)
	public ArrayList<Emp> selectEmpList(Connection conn, int beginRow, int rowPerPage) throws Exception {
		ArrayList<Emp> list = new ArrayList<Emp>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_code empCode, emp_id empId, emp_name empName, active, auth_code authCode, createdate"
				+ " FROM emp"
				+ " ORDER BY createdate DESC"
				+ " LIMIT ?,?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpCode(rs.getInt("empCode"));
			emp.setEmpId(rs.getString("empId"));
			emp.setEmpName(rs.getString("empName"));
			emp.setActive(rs.getString("active"));
			emp.setAuthCode(rs.getInt("authCode"));
			emp.setCreatedate(rs.getString("createdate"));
			list.add(emp);
		}
		return list;
	}
	//emp 직원리스트 총 갯수(검색어 없을때)
	public int selectEmpListCount(Connection conn)throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count from emp";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		return count;
	}
	// emp 리스트(검색어 있을때)
	public ArrayList<Emp> selectEmpListSearch(Connection conn, int beginRow, int rowPerPage, String search) throws Exception {
		ArrayList<Emp> list = new ArrayList<Emp>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_code empCode, emp_id empId, emp_name empName, active, auth_code authCode, createdate"
				+ " FROM emp"
				+ " WHERE emp_id LIKE ?"
				+ " ORDER BY createdate DESC"
				+ " LIMIT ?,?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+search+"%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpCode(rs.getInt("empCode"));
			emp.setEmpId(rs.getString("empId"));
			emp.setEmpName(rs.getString("empName"));
			emp.setActive(rs.getString("active"));
			emp.setAuthCode(rs.getInt("authCode"));
			emp.setCreatedate(rs.getString("createdate"));
			list.add(emp);
		}
		return list;
	}
	//emp 직원리스트 총 갯수(검색어 있을때)
	public int selectEmpListCountSearch(Connection conn, String search)throws Exception
	{
		int count = 0;
		
		String sql = "SELECT COUNT(*) count from emp WHERE emp_id LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+search+"%");
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			count = rs.getInt("count");
		}
		return count;
	}

	
	// emp 로그인
	public Emp selectEmpByIdAndPw(Connection conn, Emp paramEmp) throws Exception {
		Emp resultEmp = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT emp_id empId, emp_name empName, active, auth_code authCode"
				+ " FROM emp"
				+ " WHERE emp_id = ? AND emp_pw = PASSWORD(?)";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, paramEmp.getEmpId());
		stmt.setString(2, paramEmp.getEmpPw());
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultEmp = new Emp();
			resultEmp.setEmpId(rs.getString("empId"));
			resultEmp.setEmpName(rs.getString("empName"));
			resultEmp.setActive(rs.getString("active"));
			resultEmp.setAuthCode(rs.getInt("authCode"));
		}
		return resultEmp;
	}
	
	// emp 회원가입
	public int addEmp(Connection conn, Emp emp) throws Exception {
		int row = 0;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO emp (emp_id, emp_pw, emp_name)"
				+ " VALUES (?, PASSWORD(?), ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, emp.getEmpId());
		stmt.setString(2, emp.getEmpPw());
		stmt.setString(3, emp.getEmpName());
		
		row = stmt.executeUpdate();
		
		return row;
	}
}