package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.Question;

public class QuestionDao {
	
	//고객센터 문의 등록
	public int addQuestion(Connection conn, int ordersCode, Question question) throws Exception
	{
		int row = 0;
		
		String sql = "INSERT INTO question(orders_code,category,question_memo,createdate) VALUES(?, ?, ?, CURRENT_TIMESTAMP())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, ordersCode);
		stmt.setString(2, question.getCategory());
		stmt.setString(3, question.getQuestionMemo());
		row = stmt.executeUpdate();
		
		return row;
	}
	
}
