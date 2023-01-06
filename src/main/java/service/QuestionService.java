package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.QuestionDao;
import util.DBUtil;
import vo.Question;

public class QuestionService {
	
	QuestionDao questionDao;
	
	//고객센터 문의 리스트
	public ArrayList<HashMap<String,Object>> getQuestionListByPage( int questionCode)
	{
		ArrayList<HashMap<String,Object>> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			questionDao = new QuestionDao();
			list = questionDao.selectQuestionListByPage(conn, questionCode);
			conn.commit();
			System.out.println("QuestionService 커밋");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("QuestionService 롤백");
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
		return list;
	}
	
	//고객센터 문의 등록 서비스
	public int getAddQuestion(int ordersCode, Question question)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = questionDao.addQuestion(conn, ordersCode, question);
			conn.commit();
			System.out.println("QuestionAddService commit 성공");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("QuestionAddService rollback됨");
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
		
		return row;
	}
	
	public int getDeleteQuestion(int questionCode)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = questionDao.deleteQuestion(conn, questionCode);
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
		return row;
		
	}
	
	//고객센터 수정
	public int getupdateQuestion(Question question)
	{
		questionDao = new QuestionDao();
		int row = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			row = questionDao.updateQuestion(conn, question);
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
		
		return row;
	}
}
