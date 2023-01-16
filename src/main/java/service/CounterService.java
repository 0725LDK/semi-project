package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CounterDao;
import util.DBUtil;

public class CounterService {

	private CounterDao counterDao;
	
	//오늘 접속자수
	public int selectTodayCount()
	{
		int todayCount = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			counterDao = new CounterDao();
			todayCount = counterDao.selectTodayCount(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return todayCount;
	}
	
	//전체 접속자 수
	public int selectTotalCount()
	{
		int totalCount = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			counterDao = new CounterDao();
			totalCount = counterDao.selectTotalCount(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	
	//오늘 첫번째 접속자 일때
	public int insertCounter()
	{
		int insertCounter = 0; 
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			counterDao = new CounterDao();
			insertCounter = counterDao.insertCounter(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCounter;
	}
	
	//오늘 첫번째 접속자가 아닐때
		public int updateCounter()
		{
			int updateCounter = 0;
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				counterDao = new CounterDao();
				updateCounter = counterDao.updateCounter(conn);
				conn.commit();
			} catch (Exception e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return updateCounter;
		}
	
}
