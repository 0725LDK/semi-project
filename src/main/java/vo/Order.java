package vo;

public class Order {
	private int order_code;
	private int goods_code;
	private String customer_id;
	private int address_code;
	private int order_quantity;
	private int order_price;
	private String order_state;
	private String createdate;
	
	@Override
	public String toString() {
		return "Order [order_code=" + order_code + ", goods_code=" + goods_code + ", customer_id=" + customer_id
				+ ", address_code=" + address_code + ", order_quantity=" + order_quantity + ", order_price="
				+ order_price + ", order_state=" + order_state + ", createdate=" + createdate + "]";
	}

	public Order() {}
	
	public Order(int order_code, int goods_code, String customer_id, int address_code, int order_quantity,
			int order_price, String order_state, String createdate) {
		super();
		this.order_code = order_code;
		this.goods_code = goods_code;
		this.customer_id = customer_id;
		this.address_code = address_code;
		this.order_quantity = order_quantity;
		this.order_price = order_price;
		this.order_state = order_state;
		this.createdate = createdate;
	}
	
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
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
	public int getAddress_code() {
		return address_code;
	}
	public void setAddress_code(int address_code) {
		this.address_code = address_code;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
