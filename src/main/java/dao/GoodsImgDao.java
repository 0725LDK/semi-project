package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.GoodsImg;

public class GoodsImgDao {
	//상품 추가
	public int insertGoods(Connection conn, GoodsImg goodsImg) throws Exception {
		int row = 0;
		String sql = "INSERT INTO goods_img(goods_code, filename, origin_name, content_type, createdate) VALUES(?, ?, ?, ?, NOW())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsImg.getGoodsCode());
		stmt.setString(2, goodsImg.getFilename());
		stmt.setString(3, goodsImg.getOriginName());
		stmt.setString(4, goodsImg.getContentType());
		row = stmt.executeUpdate();
		System.out.println(row+"<-- GoodsImgDao");
		return row;
	}
	
	// 상품 수정
	public int updateGoods(Connection conn, GoodsImg goodsImg) throws Exception {
		String sql = "UPDATE goods_img SET filename = ?, origin_name = ?, content_type = ? WHERE goods_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, goodsImg.getFilename());
		stmt.setString(2, goodsImg.getOriginName());
		stmt.setString(3, goodsImg.getContentType());
		stmt.setInt(4, goodsImg.getGoodsCode());
		int row = stmt.executeUpdate();
		System.out.println(row+"<-- GoodsImgDao");
		
		return row;
	}
	
	// 상품 삭제
	public int deleteGoods(Connection conn, int goodsCode) throws Exception {
		String sql = "DELETE FROM goods_img WHERE goods_code =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, goodsCode);
		int row = stmt.executeUpdate();
			
		return row;
	}
}