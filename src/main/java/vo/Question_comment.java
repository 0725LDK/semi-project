package vo;

public class Question_comment {
	private int comment_code;
	private int question_code;
	private int comment_memo;
	private String createdate;
	
	@Override
	public String toString() {
		return "Question_comment [comment_code=" + comment_code + ", question_code=" + question_code + ", comment_memo="
				+ comment_memo + ", createdate=" + createdate + "]";
	}

	public Question_comment() {}
	
	public Question_comment(int comment_code, int question_code, int comment_memo, String createdate) {
		super();
		this.comment_code = comment_code;
		this.question_code = question_code;
		this.comment_memo = comment_memo;
		this.createdate = createdate;
	}
	public int getComment_code() {
		return comment_code;
	}
	public void setComment_code(int comment_code) {
		this.comment_code = comment_code;
	}
	public int getQuestion_code() {
		return question_code;
	}
	public void setQuestion_code(int question_code) {
		this.question_code = question_code;
	}
	public int getComment_memo() {
		return comment_memo;
	}
	public void setComment_memo(int comment_memo) {
		this.comment_memo = comment_memo;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
} 
