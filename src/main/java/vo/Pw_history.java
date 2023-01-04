package vo;

public class Pw_history {
	private String customer_id;
	private String pw;
	private String createdate;
	
	@Override
	public String toString() {
		return "Pw_history [customer_id=" + customer_id + ", pw=" + pw + ", createdate=" + createdate + "]";
	}

	public Pw_history() {}
	
	public Pw_history(String customer_id, String pw, String createdate) {
		super();
		this.customer_id = customer_id;
		this.pw = pw;
		this.createdate = createdate;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
