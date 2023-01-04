package vo;

public class Goods_img {
	private int goods_code;
	private String filename;
	private String origin_name;
	private String content_type;
	private String createdate;
		
	@Override
	public String toString() {
		return "Goods_img [goods_code=" + goods_code + ", filename=" + filename + ", origin_name=" + origin_name
				+ ", content_type=" + content_type + ", createdate=" + createdate + "]";
	}

	public Goods_img() {}
	
	public Goods_img(int goods_code, String filename, String origin_name, String content_type, String createdate) {
		super();
		this.goods_code = goods_code;
		this.filename = filename;
		this.origin_name = origin_name;
		this.content_type = content_type;
		this.createdate = createdate;
	}
	
	public int getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(int goods_code) {
		this.goods_code = goods_code;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
