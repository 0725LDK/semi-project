package vo;

public class Customer {
	private int customer_code;
	private String customer_id;
	private String customer_pw;
	private String customer_name;
	private String customer_phone;
	private int point;
	private String createdate;
	
	@Override
	public String toString() {
		return "Customer [customer_code=" + customer_code + ", customer_id=" + customer_id + ", customer_pw="
				+ customer_pw + ", customer_name=" + customer_name + ", customer_phone=" + customer_phone + ", point="
				+ point + ", createdate=" + createdate + "]";
	}

	public Customer() {}
	
	public Customer(int customer_code, String customer_id, String customer_pw, String customer_name,
			String customer_phone, int point, String createdate) {
		super();
		this.customer_code = customer_code;
		this.customer_id = customer_id;
		this.customer_pw = customer_pw;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.point = point;
		this.createdate = createdate;
	}
	
	public int getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(int customer_code) {
		this.customer_code = customer_code;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_pw() {
		return customer_pw;
	}
	public void setCustomer_pw(String customer_pw) {
		this.customer_pw = customer_pw;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	

	
}
