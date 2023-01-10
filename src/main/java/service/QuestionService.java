package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QuestionDao;
import util.DBUtil;
import vo.Question;

public class QuestionService {
	
	QuestionDao questionDao;
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return row;
	}
}
