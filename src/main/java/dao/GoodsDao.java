package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Goods;

public class GoodsDao {
	
	// 신상품 리스트 출력
	public ArrayList<HashMap<String, Object>> selectGoodsNewList(Connection conn, int beginRow, int rowPerPage) throws Exception {
		ArrayList<HashMap<String, Object>> newList = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, g.goods_category goodsCategory, g.category_name categoryName, g.goods_content goodsContent, g.createdate createdate, img.filename filename"
				+ " FROM goods g INNER JOIN goods_img img"
				+ " ON g.goods_code = img.goods_code"
				+ " ORDER BY g.createdate desc"
				+ " LIMIT ?, ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> n = new HashMap<String, Object>();
			n.put("goodsCode", rs.getInt("goodsCode"));
			n.put("goodsName", rs.getString("goodsName"));
			n.put("goodsPrice", rs.getInt("goodsPrice"));
			n.put("goodsCategory", rs.getString("goodsCategory"));
			n.put("categoryName", rs.getString("categoryName"));
			n.put("goodsContent", rs.getString("goodsContent"));
			n.put("createdate", rs.getString("createdate"));
			n.put("filename", rs.getString("filename"));

			newList.add(n);
		}		
		return newList;
	}		

	// 인기상품 리스트 출력
	public ArrayList<HashMap<String, Object>> selectGoodsHitList(Connection conn, int hit) throws Exception {
		ArrayList<HashMap<String, Object>> hitList = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, g.goods_category goodsCategory, g.category_name categoryName, g.goods_content goodsContent, g.hit hit, img.filename filename"
				+ " FROM goods g INNER JOIN goods_img img"
				+ " ON g.goods_code = img.goods_code"
				+ " WHERE g.hit = 1";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, hit);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> h = new HashMap<String, Object>();
			h.put("goodsCode", rs.getInt("goodsCode"));
			h.put("goodsName", rs.getString("goodsName"));
			h.put("goodsPrice", rs.getInt("goodsPrice"));
			h.put("goodsCategory", rs.getString("goodsCategory"));
			h.put("categoryName", rs.getString("categoryName"));
			h.put("goodsContent", rs.getString("goodsContent"));
			h.put("hit", rs.getInt("hit"));
			h.put("filename", rs.getString("filename"));

			hitList.add(h);
		}		
		return hitList;
	}	
	
	// customer
	// 카테고리별 상품 리스트 출력

	public ArrayList<HashMap<String, Object>> selectGoodsCategoryList(Connection conn, String goodsCategory) throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, g.goods_category goodsCategory, g.category_name categoryName, g.goods_content goodsContent, g.soldout soldout, img.filename filename"
				+ " FROM goods g INNER JOIN goods_img img"
				+ " ON g.goods_code = img.goods_code"
				+ " WHERE g.goods_category = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, goodsCategory);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("goodsCode", rs.getInt("goodsCode"));
			m.put("goodsName", rs.getString("goodsName"));
			m.put("goodsPrice", rs.getInt("goodsPrice"));
			m.put("goodsCategory", rs.getString("goodsCategory"));
			m.put("categoryName", rs.getString("categoryName"));
			m.put("goodsContent", rs.getString("goodsContent"));
			m.put("filename", rs.getString("filename"));

			list.add(m);
		}		
		return list;
	}
	



	// emp
	// 전체 상품 리스트
	public ArrayList<HashMap<String, Object>> selectGoodsList(Connection conn, String goodsSearch) throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		PreparedStatement stmt = null;
		if(goodsSearch == null || goodsSearch.equals("")) {		
			String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, g.goods_category goodsCategory, g.category_name categoryName, g.goods_content goodsContent, g.soldout soldout, img.filename filename"
					+ " FROM goods g INNER JOIN goods_img img"
					+ " ON g.goods_code = img.goods_code";					
			stmt = conn.prepareStatement(sql);
			System.out.println(stmt+"<-- GoodsDao");
		
		} else {
			String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, g.goods_category goodsCategory, g.category_name categoryName, g.goods_content goodsContent, g.soldout soldout, img.filename filename"
					+ " FROM goods g INNER JOIN goods_img img"
					+ " ON g.goods_code = img.goods_code"
					+ " WHERE g.goods_name LIKE ? ORDER BY g.goods_code";		
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+goodsSearch+"%");
			System.out.println(stmt+"<-- GoodsDao");
	
		}
			ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("goodsCode", rs.getInt("goodsCode"));
			m.put("goodsName", rs.getString("goodsName"));
			m.put("goodsPrice", rs.getInt("goodsPrice"));
			m.put("goodsCategory", rs.getString("goodsCategory"));
			m.put("categoryName", rs.getString("categoryName"));
			m.put("goodsContent", rs.getString("goodsContent"));
			m.put("soldout", rs.getString("soldout"));
			m.put("filename", rs.getString("filename"));
			System.out.println(m+"<-- GoodsDao");
			list.add(m);
		}

	
		return list;
	}

	// 상품 상세페이지 goodsOne
	public HashMap<String, Object> selectGoodsOne(Connection conn, int goodsCode) throws Exception {
		HashMap<String, Object> map = null;
		String sql = "SELECT g.goods_code goodsCode, g.goods_name goodsName, g.goods_price goodsPrice, g.goods_category goodsCategory, g.category_name categoryName, g.goods_content goodsContent, g.goods_alcohol goodsAlcohol, g.goods_liter goodsLiter, g.soldout soldout, g.emp_id empId, g.hit hit, g.createdate createdate, img.filename filename, img.origin_name originName"
				+ " FROM goods g INNER JOIN goods_img img"
				+ " ON g.goods_code = img.goods_code"
				+ " WHERE g.goods_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			map = new HashMap<String, Object>();
			map.put("goodsCode", rs.getInt("goodsCode"));
			map.put("goodsName", rs.getString("goodsName"));
			map.put("goodsPrice", rs.getInt("goodsPrice"));
			map.put("goodsCategory", rs.getString("goodsCategory"));
			map.put("categoryName", rs.getString("categoryName"));
			map.put("goodsContent", rs.getString("goodsContent"));
			map.put("goodsAlcohol", rs.getDouble("goodsAlcohol"));
			map.put("goodsLiter", rs.getInt("goodsLiter"));
			map.put("soldout", rs.getString("soldout"));
			map.put("empId", rs.getString("empId"));
			map.put("hit", rs.getInt("hit"));
			map.put("createdate", rs.getString("createdate"));
			map.put("filename", rs.getString("filename"));
			map.put("originName", rs.getString("originName"));
			System.out.println(map+"<-- GoodsDao");
		}

		return map;
	}
	
	// 상품 추가
	public HashMap<String, Integer> insertGoods(Connection conn, Goods goods) throws Exception {
		String sql = "INSERT INTO goods(goods_name, goods_price, goods_category, category_name, goods_content, goods_alcohol, goods_liter, soldout, emp_id, hit, createdate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		// PreparedStatement.RETURN_GENERATED_KEYS 쿼리실행 후 생성된 auto_increment값을 ResultSet에 반환
		PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, goods.getGoodsName());
		stmt.setInt(2, goods.getGoodsPrice());
		stmt.setString(3, goods.getGoodsCategory());
		stmt.setString(4, goods.getCategoryName());
		stmt.setString(5, goods.getGoodsContent());
		stmt.setDouble(6, goods.getGoodsAlcohol());
		stmt.setInt(7, goods.getGoodsLiter());
		stmt.setString(8, goods.getSoldout());
		stmt.setString(9, goods.getEmpId());
		stmt.setInt(10, goods.getHit());
		System.out.println(goods+"<-- GoodsDao");
		
		int row = stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		int autoKey = 0;
		if(rs.next()) {
			autoKey = rs.getInt(1); // stmt.executeUpdate(); 생성된 auto_increment값이 대입
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("row", row);
		map.put("autoKey", autoKey);
	
		return map;
	}
	
	// 상품 수정
	public int updateGoods(Connection conn, Goods goods) throws Exception {
		String sql = "UPDATE goods SET goods_name = ?, goods_price = ?, goods_category = ?, category_name = ?, goods_content = ?, goods_alcohol = ?, goods_liter = ?, soldout = ?, emp_id = ?, hit = ? WHERE goods_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, goods.getGoodsName());
		stmt.setInt(2, goods.getGoodsPrice());
		stmt.setString(3, goods.getGoodsCategory());
		stmt.setString(4, goods.getCategoryName());
		stmt.setString(5, goods.getGoodsContent());
		stmt.setDouble(6, goods.getGoodsAlcohol());
		stmt.setInt(7, goods.getGoodsLiter());
		stmt.setString(8, goods.getSoldout());
		stmt.setString(9, goods.getEmpId());
		stmt.setInt(10, goods.getHit());
		stmt.setInt(11, goods.getGoodsCode());
		System.out.println(goods+"<-- GoodsDao");	
		
		int row = stmt.executeUpdate();
		
		
		return row;
	}
	
	/*
	// 상품 삭제
	public int deleteGoods(Connection conn, int goodsCode) throws Exception {
		String sql = "DELETE FROM goods WHERE goods_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		System.out.println(goodsCode+"<-- GoodsDao goodsCode");
		int row = stmt.executeUpdate();

		return row;
	}
	*/
}