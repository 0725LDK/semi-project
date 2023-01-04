package vo;

public class Emp {
	private int emp_code;
	private String emp_id;
	private String emp_pw;
	private String emp_name;
	private String active;
	private int auth_code;
	private String createdate;
	
	@Override
	public String toString() {
		return "Emp [emp_code=" + emp_code + ", emp_id=" + emp_id + ", emp_pw=" + emp_pw + ", emp_name=" + emp_name
				+ ", active=" + active + ", auth_code=" + auth_code + ", createdate=" + createdate + "]";
	}

	public Emp() {}
	
	public Emp(int emp_code, String emp_id, String emp_pw, String emp_name, String active, int auth_code,
			String createdate) {
		super();
		this.emp_code = emp_code;
		this.emp_id = emp_id;
		this.emp_pw = emp_pw;
		this.emp_name = emp_name;
		this.active = active;
		this.auth_code = auth_code;
		this.createdate = createdate;
	}
	
	public int getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
