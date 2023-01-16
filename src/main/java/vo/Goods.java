package vo;

public class Goods {
	private int goodsCode;
	private String goodsName;
	private int goodsPrice;
	private String goodsCategory;
	private String categoryName;
	private String goodsContent;
	private double goodsAlcohol;
	private int goodsLiter;
	private String soldout;
	private String empId;
	private int hit;
	private String createdate;
	
	@Override
	public String toString() {
		return "Goods [goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsCategory=" + goodsCategory + ", categoryName=" + categoryName + ", goodsContent="
				+ goodsContent + ", goodsAlcohol=" + goodsAlcohol + ", goodsLiter=" + goodsLiter + ", soldout="
				+ soldout + ", empId=" + empId + ", hit=" + hit + ", createdate=" + createdate + "]";
	}
	public Goods() {
		super();
	}
	
	public Goods(int goodsCode, String goodsName, int goodsPrice, String goodsCategory, String categoryName,
			String goodsContent, double goodsAlcohol, int goodsLiter, String soldout, String empId, int hit,
			String createdate) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsCategory = goodsCategory;
		this.categoryName = categoryName;
		this.goodsContent = goodsContent;
		this.goodsAlcohol = goodsAlcohol;
		this.goodsLiter = goodsLiter;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public double getGoodsAlcohol() {
		return goodsAlcohol;
	}
	public void setGoodsAlcohol(double goodsAlcohol) {
		this.goodsAlcohol = goodsAlcohol;
	}
	public int getGoodsLiter() {
		return goodsLiter;
	}
	public void setGoodsLiter(int goodsLiter) {
		this.goodsLiter = goodsLiter;
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
