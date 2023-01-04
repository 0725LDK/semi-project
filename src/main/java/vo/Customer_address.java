package vo;

public class Customer_address {
	private int address_code;
	private String customer_id;
	private String address;
	private String createdate;
		
	@Override
	public String toString() {
		return "Customer_address [address_code=" + address_code + ", customer_id=" + customer_id + ", address="
				+ address + ", createdate=" + createdate + "]";
	}

	public Customer_address() {}
	
	public Customer_address(int address_code, String customer_id, String address, String createdate) {
		super();
		this.address_code = address_code;
		this.customer_id = customer_id;
		this.address = address;
		this.createdate = createdate;
	}
	
	public int getAddress_code() {
		return address_code;
	}
	public void setAddress_code(int address_code) {
		this.address_code = address_code;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	
}
