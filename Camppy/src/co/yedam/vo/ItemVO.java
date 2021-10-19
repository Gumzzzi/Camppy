package co.yedam.vo;

public class ItemVO {

	private int i_num;
	private String i_name;
	private String i_info;
	private String i_img;
	private String ctgr;
	private String p_comp;
	private String p_cont;
	private int ori_p;
	private int off_p;
	private int stock;
	
	public int getI_num() {
		return i_num;
	}
	public void setI_num(int i_num) {
		this.i_num = i_num;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public String getI_info() {
		return i_info;
	}
	public void setI_info(String i_info) {
		this.i_info = i_info;
	}
	public String getI_img() {
		return i_img;
	}
	public void setI_img(String i_img) {
		this.i_img = i_img;
	}
	public String getCtgr() {
		return ctgr;
	}
	public void setCtgr(String ctgr) {
		this.ctgr = ctgr;
	}
	public String getP_comp() {
		return p_comp;
	}
	public void setP_comp(String p_comp) {
		this.p_comp = p_comp;
	}
	public String getP_cont() {
		return p_cont;
	}
	public void setP_cont(String p_cont) {
		this.p_cont = p_cont;
	}
	public int getOri_p() {
		return ori_p;
	}
	public void setOri_p(int ori_p) {
		this.ori_p = ori_p;
	}
	public int getOff_p() {
		return off_p;
	}
	public void setOff_p(int off_p) {
		this.off_p = off_p;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "ItemVO [i_num=" + i_num + ", i_name=" + i_name + ", i_info=" + i_info + ", i_img=" + i_img + ", ctgr="
				+ ctgr + ", p_comp=" + p_comp + ", p_cont=" + p_cont + ", ori_p=" + ori_p + ", off_p=" + off_p
				+ ", stock=" + stock + "]";
	}
	
	
	
}
