package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.NoticeImg;

public class NoticeImgDao {
	// 공지 추가
	public int insertNotice(Connection conn, NoticeImg noticeImg) throws Exception {
		int row = 0;
		String sql = "INSERT INTO notice_img(notice_code, filename, origin_name, content_type, createdate) VALUES(?, ?, ?, ?, NOW())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, noticeImg.getNoticeCode());
		stmt.setString(2, noticeImg.getFilename());
		stmt.setString(3, noticeImg.getOriginName());
		stmt.setString(4, noticeImg.getContentType());
		row = stmt.executeUpdate();
		System.out.println(row+"<-- NoticeImgDao ");
		return row;
	}
	
	// 공지 수정
	public int updateNotice(Connection conn, NoticeImg noticeImg) throws Exception {
		String sql = "UPDATE notice_img SET filename = ?, origin_name = ?, content_type = ? WHERE notice_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, noticeImg.getFilename());
		stmt.setString(2, noticeImg.getOriginName());
		stmt.setString(3, noticeImg.getContentType());
		stmt.setInt(4, noticeImg.getNoticeCode());
		int row = stmt.executeUpdate();
		System.out.println(row+"<-- NoticeImgDao ");
		
		return row;
	}
	
	// 공지 삭제
	public int deleteNotice(Connection conn, NoticeImg noticeImg) throws Exception {
		String sql = "DELETE FROM notice_img WHERE notice_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, noticeImg.getNoticeCode());
		int row = stmt.executeUpdate();
		System.out.println(row+"<-- NoticeImgDao ");			
		return row;
	}
}