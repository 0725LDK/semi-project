package vo;

public class Question_comment {
	private int commentCode;
	private int questionCode;
	private int commentMemo;
	private String createdate;
	
	@Override
	public String toString() {
		return "Question_comment [commentCode=" + commentCode + ", questionCode=" + questionCode + ", commentMemo="
				+ commentMemo + ", createdate=" + createdate + "]";
	}
	public Question_comment() {}
	
	public Question_comment(int commentCode, int questionCode, int commentMemo, String createdate) {
		super();
		this.commentCode = commentCode;
		this.questionCode = questionCode;
		this.commentMemo = commentMemo;
		this.createdate = createdate;
	}
	public int getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}
	public int getQuestionCode() {
		return questionCode;
	}
	public void setQuestionCode(int questionCode) {
		this.questionCode = questionCode;
	}
	public int getCommentMemo() {
		return commentMemo;
	}
	public void setCommentMemo(int commentMemo) {
		this.commentMemo = commentMemo;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

} 
