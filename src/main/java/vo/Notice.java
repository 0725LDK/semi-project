package vo;

public class Notice {
	private int notice_code;
	private String notice_title;
	private String notice_content;
	private String emp_id;
	private String createdate;
	
	@Override
	public String toString() {
		return "Notice [notice_code=" + notice_code + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", emp_id=" + emp_id + ", createdate=" + createdate + "]";
	}

	public Notice() {}

	public Notice(int notice_code, String notice_title, String notice_content, String emp_id, String createdate) {
		super();
		this.notice_code = notice_code;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.emp_id = emp_id;
		this.createdate = createdate;
	}
	
	public int getNotice_code() {
		return notice_code;
	}
	public void setNotice_code(int notice_code) {
		this.notice_code = notice_code;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
