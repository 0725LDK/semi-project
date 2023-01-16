package vo;

public class SiteCounter {
	private String counterDate;
	private int counterNum;
	@Override
	public String toString() {
		return "SiteCounter [counterDate=" + counterDate + ", counterNum=" + counterNum + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public String getCounterDate() {
		return counterDate;
	}
	public void setCounterDate(String counterDate) {
		this.counterDate = counterDate;
	}
	public int getCounterNum() {
		return counterNum;
	}
	public void setCounterNum(int counterNum) {
		this.counterNum = counterNum;
	}
	
	
}
