package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Notice;

public class NoticeDao {

	// emp
	// 전체 공지 리스트
	public ArrayList<HashMap<String, Object>> selectNoticeList(Connection conn) throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT n.notice_code noticeCode, n.notice_title noticeTitle, n.notice_category noticeCategory, n.notice_content noticeContent, img.filename filename"
				+ " FROM notice n INNER JOIN notice_img img"
				+ " ON n.notice_code = img.notice_code";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("noticeCode", rs.getInt("noticeCode"));
			m.put("noticeTitle", rs.getString("noticeTitle"));
			m.put("noticeCategory", rs.getString("noticeCategory"));
			m.put("noticeContent", rs.getString("noticeContent"));
			m.put("filename", rs.getString("filename"));
			System.out.println(m+"<-- NoticeDao");
			list.add(m);
		}
		return list;
	}
	
	// 공지 상세페이지
	public HashMap<String, Object> selectNoticeOne(Connection conn, int noticeCode) throws Exception {
		HashMap<String, Object> map = null;
		String sql = "SELECT n.notice_code noticeCode, n.notice_title noticeTitle, n.notice_category noticeCategory, n.notice_content noticeContent, n.emp_id empId, n.createdate createdate, img.filename filename, img.origin_name originName"
				+ " FROM notice n INNER JOIN notice_img img"
				+ " ON n.notice_code = img.notice_code"
				+ " WHERE n.notice_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, noticeCode);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			map = new HashMap<String, Object>();
			map.put("noticeCode", rs.getInt("noticeCode"));
			map.put("noticeTitle", rs.getString("noticeTitle"));
			map.put("noticeCategory", rs.getString("noticeCategory"));
			map.put("noticeContent", rs.getString("noticeContent"));
			map.put("empId", rs.getString("empId"));
			map.put("createdate", rs.getString("createdate"));
			map.put("filename", rs.getString("filename"));
			map.put("originName", rs.getString("originName"));
			System.out.println(map+"<-- NoticeDao");
		}

		return map;
	}

	// 공지 추가
	public HashMap<String, Integer> insertNotice(Connection conn, Notice notice) throws Exception {
		String sql = "INSERT INTO notice(notice_title, notice_category, notice_content, emp_id, createdate) VALUES(?, ?, ?, NOW());";
		// PreparedStatement.RETURN_GENERATED_KEYS 쿼리실행 후 생성된 auto_increment값을 ResultSet에 반환
		PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, notice.getNoticeTitle());
		stmt.setString(2, notice.getNoticeCategory());
		stmt.setString(3, notice.getNoticeContent());
		stmt.setString(4, notice.getEmpId());
		System.out.println(notice+"<-- NoticeDao");
		
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
	
	// 공지 수정
	public int updateNotice(Connection conn, Notice notice) throws Exception {
		String sql = "UPDATE notice SET notice_title = ?, notice_category = ?, notice_content = ?,  emp_id = ? WHERE notice_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, notice.getNoticeTitle());
		stmt.setString(2, notice.getNoticeCategory());
		stmt.setString(3, notice.getNoticeContent());
		stmt.setString(4, notice.getEmpId());
		stmt.setInt(5, notice.getNoticeCode());
		System.out.println(notice+"<-- NoticeDao");	
		
		int row = stmt.executeUpdate();
		
		return row;
	}
	
	// 공지 삭제
	public int deleteNotice(Connection conn, Notice notice) throws Exception {
		String sql = "DELETE FROM notice WHERE notice_code = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, notice.getNoticeCode());
		System.out.println(notice+"<-- NoticeDao");
		
		int row = stmt.executeUpdate();
		
		
		return row;
	}

}
