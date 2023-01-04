package vo;

public class Cart {
	private int goods_code;
	private String customer_id;
	private int cart_quantity;
	private String createdate;
	
	@Override
	public String toString() {
		return "Cart [goods_code=" + goods_code + ", customer_id=" + customer_id + ", cart_quantity=" + cart_quantity
		
				+ ", createdate=" + createdate + "]";
	}
	
	public Cart() {}

	public Cart(int goods_code, String customer_id, int cart_quantity, String createdate) {
		super();
		this.goods_code = goods_code;
		this.customer_id = customer_id;
		this.cart_quantity = cart_quantity;
		this.createdate = createdate;
	}

	public int getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(int goods_code) {
		this.goods_code = goods_code;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
