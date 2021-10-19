package co.yedam.vo;

public class CtgrVO {

	private String ctrg;
	private String ctrg_title;
	
	public String getCtrg() {
		return ctrg;
	}
	public void setCtrg(String ctrg) {
		this.ctrg = ctrg;
	}
	public String getCtrg_title() {
		return ctrg_title;
	}
	public void setCtrg_title(String ctrg_title) {
		this.ctrg_title = ctrg_title;
	}
	
	@Override
	public String toString() {
		return "CtgrVO [ctrg=" + ctrg + ", ctrg_title=" + ctrg_title + "]";
	}
	
	
	
	
}
