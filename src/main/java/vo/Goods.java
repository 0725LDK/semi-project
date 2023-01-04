package vo;

public class Goods {
	 private int goods_code;
	 private String goods_name;
	 private int goods_price;
	 private String soldout;
	 private String emp_id;
	 private int hit;
	 private String createdate;
	 
	@Override
	public String toString() {
		return "Goods [goods_code=" + goods_code + ", goods_name=" + goods_name + ", goods_price=" + goods_price
				+ ", soldout=" + soldout + ", emp_id=" + emp_id + ", hit=" + hit + ", createdate=" + createdate + "]";
	}

	public Goods() {}
	
	public Goods(int goods_code, String goods_name, int goods_price, String soldout, String emp_id, int hit,
			String createdate) {
		super();
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.soldout = soldout;
		this.emp_id = emp_id;
		this.hit = hit;
		this.createdate = createdate;
	}
	public int getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(int goods_code) {
		this.goods_code = goods_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public String getSoldout() {
		return soldout;
	}
	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	 
	 
}
