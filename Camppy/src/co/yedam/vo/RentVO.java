package co.yedam.vo;

public class RentVO {

	private int i_num;
	private String id;
	private String r_date;
	private String u_date;
	
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getU_date() {
		return u_date;
	}
	public void setU_date(String u_date) {
		this.u_date = u_date;
	}
	
	@Override
	public String toString() {
		return "RentVO [i_num=" + i_num + ", id=" + id + ", r_date=" + r_date + ", u_date=" + u_date + "]";
	}
	
	
	
	
}
