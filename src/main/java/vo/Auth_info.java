package vo;

public class Auth_info {
	private int auth_code;
	private String auth_memo;
	private String createdate;
	
	@Override
	public String toString() {
		return "Auth_info [auth_code=" + auth_code + ", auth_memo=" + auth_memo + ", createdate=" + createdate + "]";
	}
	
	public Auth_info() {}

	public Auth_info(int auth_code, String auth_memo, String createdate) {
		super();
		this.auth_code = auth_code;
		this.auth_memo = auth_memo;
		this.createdate = createdate;
	}
	
	public int getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(int auth_code) {
		this.auth_code = auth_code;
	}
	public String getAuth_memo() {
		return auth_memo;
	}
	public void setAuth_memo(String auth_memo) {
		this.auth_memo = auth_memo;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
