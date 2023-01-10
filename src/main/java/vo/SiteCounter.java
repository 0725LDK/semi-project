package vo;

public class SiteCounter {
	private String counter_date;
	private int couter_num;
	
	@Override
	public String toString() {
		return "Site_counter [counter_date=" + counter_date + ", couter_num=" + couter_num + "]";
	}
	
	public SiteCounter() {}
	
	public SiteCounter(String counter_date, int couter_num) {
		super();
		this.counter_date = counter_date;
		this.couter_num = couter_num;
	}

	public String getCounter_date() {
		return counter_date;
	}
	public void setCounter_date(String counter_date) {
		this.counter_date = counter_date;
	}
	public int getCouter_num() {
		return couter_num;
	}
	public void setCouter_num(int couter_num) {
		this.couter_num = couter_num;
	}
	
}
