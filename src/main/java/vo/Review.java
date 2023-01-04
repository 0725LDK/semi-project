package vo;

public class Review {
	private int order_code;
	private String review_memo;
	private String createdate;
	
	@Override
	public String toString() {
		return "Review [order_code=" + order_code + ", review_memo=" + review_memo + ", createdate=" + createdate + "]";
	}

	public Review() {}
	
	public Review(int order_code, String review_memo, String createdate) {
		super();
		this.order_code = order_code;
		this.review_memo = review_memo;
		this.createdate = createdate;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public String getReview_memo() {
		return review_memo;
	}
	public void setReview_memo(String review_memo) {
		this.review_memo = review_memo;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
