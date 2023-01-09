package vo;

public class Goods {
	private int goodsCode;
	private String goodsName;
	private int goodsPrice;
	private String goodsCategory;
	private String goodsContent;
	private String soldout;
	private String empId;
	private int hit;
	private String createdate;
	
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsCategory=" + goodsCategory + ", goodsContent=" + goodsContent + ", soldout=" + soldout
				+ ", empId=" + empId + ", hit=" + hit + ", createdate=" + createdate + "]";
	}
	public Goods() {}
	
	public Goods(int goodsCode, String goodsName, int goodsPrice, String goodsCategory, String goodsContent,
			String soldout, String empId, int hit, String createdate) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsCategory = goodsCategory;
		this.goodsContent = goodsContent;
		this.soldout = soldout;
		this.empId = empId;
		this.hit = hit;
		this.createdate = createdate;
	}
	public int getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsCategory() {
		return goodsCategory;
	}
	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getSoldout() {
		return soldout;
	}
	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
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
