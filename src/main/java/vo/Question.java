package vo;

public class Question {
	private int question_code;
	private int orders_code;
	private String category;
	private String question_memo;
	private String createdate;
	
	@Override
	public String toString() {
		return "Question [question_code=" + question_code + ", orders_code=" + orders_code + ", category=" + category
				+ ", question_memo=" + question_memo + ", createdate=" + createdate + "]";
	}

	public Question() {}
	
	public Question(int question_code, int orders_code, String category, String question_memo, String createdate) {
		super();
		this.question_code = question_code;
		this.orders_code = orders_code;
		this.category = category;
		this.question_memo = question_memo;
		this.createdate = createdate;
	}
	public int getQuestion_code() {
		return question_code;
	}
	public void setQuestion_code(int question_code) {
		this.question_code = question_code;
	}
	public int getOrders_code() {
		return orders_code;
	}
	public void setOrders_code(int orders_code) {
		this.orders_code = orders_code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion_memo() {
		return question_memo;
	}
	public void setQuestion_memo(String question_memo) {
		this.question_memo = question_memo;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
