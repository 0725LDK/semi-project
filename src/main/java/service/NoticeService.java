package service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.NoticeDao;
import dao.NoticeImgDao;
import util.DBUtil;
import vo.Notice;
import vo.NoticeImg;


public class NoticeService {
	private NoticeDao noticeDao;
	private NoticeImgDao noticeImgDao;
	
	public ArrayList<HashMap<String, Object>> getNoticeCategoryList(String noticeCategory) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			noticeDao = new NoticeDao();
			list = noticeDao.selectNoticeCategoryList(conn, noticeCategory);
			conn.commit();
		} catch(Exception e) {
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
		return list;
	}		
	
	
	
	
	
	
	
	
	
	// emp 공지 리스트
	public ArrayList<HashMap<String, Object>> getNoticeList() {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			noticeDao = new NoticeDao();
			list = noticeDao.selectNoticeList(conn);
			conn.commit();
		} catch(Exception e) {
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
		return list;
	}
	
	// 공지 상세페이지
	public HashMap<String, Object> getNoticeOne(int noticeCode) {
		HashMap<String, Object> map = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();			
			noticeDao = new NoticeDao();
			map = noticeDao.selectNoticeOne(conn, noticeCode);
			conn.commit();
		} catch(Exception e) {
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
		return map;
	}

	// 공지 추가
	public void addNotice(Notice notice, NoticeImg noticeImg, String dir) {
		noticeDao = new NoticeDao();
		noticeImgDao = new NoticeImgDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();			
			HashMap<String, Integer> map = noticeDao.insertNotice(conn, notice);	
			int row = map.get("row");
			if(row == 1) {
				noticeImg.setNoticeCode(map.get("autoKey"));
				noticeImgDao.insertNotice(conn, noticeImg); 
				System.out.println("성공");							
			} else {
				System.out.println("실패");					
			}
				conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
                // db작업에 실패시 이미 업로드되어 버린 파일을 불러와 삭제
				File f = new File(dir+"\\"+noticeImg.getFilename());
				if(f.exists()) {
					f.delete();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 공지 수정
	public int modifyNotice(Notice notice, NoticeImg noticeImg, String dir) {
		noticeDao = new NoticeDao();
		noticeImgDao = new NoticeImgDao();
		Connection conn = null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			row = noticeDao.updateNotice(conn, notice);
			if(row == 1) {
				row = noticeImgDao.updateNotice(conn, noticeImg);
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
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
		return row;
	}
	
	// 공지 삭제
	public int removeNotice(Notice notice, NoticeImg noticeImg) {
		noticeDao = new NoticeDao();
		noticeImgDao = new NoticeImgDao();
		Connection conn = null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			row = noticeImgDao.deleteNotice(conn, noticeImg);
			if(row == 1) {
				row = noticeDao.deleteNotice(conn, notice);
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
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
		return row;
	}

}
