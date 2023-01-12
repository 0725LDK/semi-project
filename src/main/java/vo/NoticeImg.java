package vo;

public class NoticeImg {
	private int noticeCode;
	private String filename;
	private String originName;
	private String contentType;
	private String createdate;
	
	@Override
	public String toString() {
		return "NoticeImg [noticeCode=" + noticeCode + ", filename=" + filename + ", originName=" + originName
				+ ", contentType=" + contentType + ", createdate=" + createdate + "]";
	}
	
	public NoticeImg() {}
	
	public NoticeImg(int noticeCode, String filename, String originName, String contentType, String createdate) {
		super();
		this.noticeCode = noticeCode;
		this.filename = filename;
		this.originName = originName;
		this.contentType = contentType;
		this.createdate = createdate;
	}
	
	public int getNoticeCode() {
		return noticeCode;
	}
	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
