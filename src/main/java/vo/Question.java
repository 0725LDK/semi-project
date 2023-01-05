package vo;

public class Question {
	private int questionCode;
	private int ordersCode;
	private String category;
	private String questionMemo;
	private String createdate;
	
	@Override
	public String toString() {
		return "Question [questionCode=" + questionCode + ", ordersCode=" + ordersCode + ", category=" + category
				+ ", questionMemo=" + questionMemo + ", createdate=" + createdate + "]";
	}
	public Question() {}
	
	public Question(int questionCode, int ordersCode, String category, String questionMemo, String createdate) {
		super();
		this.questionCode = questionCode;
		this.ordersCode = ordersCode;
		this.category = category;
		this.questionMemo = questionMemo;
		this.createdate = createdate;
	}
	public int getQuestionCode() {
		return questionCode;
	}
	public void setQuestionCode(int questionCode) {
		this.questionCode = questionCode;
	}
	public int getOrdersCode() {
		return ordersCode;
	}
	public void setOrdersCode(int ordersCode) {
		this.ordersCode = ordersCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestionMemo() {
		return questionMemo;
	}
	public void setQuestionMemo(String questionMemo) {
		this.questionMemo = questionMemo;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}
