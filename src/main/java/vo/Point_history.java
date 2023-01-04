package vo;

public class Point_history {
	private int order_code;
	private String point_kind;
	private int point;
	private int createdate;
	
	@Override
	public String toString() {
		return "Point_history [order_code=" + order_code + ", point_kind=" + point_kind + ", point=" + point
				+ ", createdate=" + createdate + "]";
	}

	public Point_history() {}
	
	public Point_history(int order_code, String point_kind, int point, int createdate) {
		super();
		this.order_code = order_code;
		this.point_kind = point_kind;
		this.point = point;
		this.createdate = createdate;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public String getPoint_kind() {
		return point_kind;
	}
	public void setPoint_kind(String point_kind) {
		this.point_kind = point_kind;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getCreatedate() {
		return createdate;
	}
	public void setCreatedate(int createdate) {
		this.createdate = createdate;
	}
	
}
