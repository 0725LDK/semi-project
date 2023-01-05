package vo;

public class Pw_history {
	private String customerId;
	private String pw;
	private String createdate;
	
	@Override
	public String toString() {
		return "Pw_history [customerId=" + customerId + ", pw=" + pw + ", createdate=" + createdate + "]";
	}
	public Pw_history() {}
	
	public Pw_history(String customerId, String pw, String createdate) {
		super();
		this.customerId = customerId;
		this.pw = pw;
		this.createdate = createdate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
