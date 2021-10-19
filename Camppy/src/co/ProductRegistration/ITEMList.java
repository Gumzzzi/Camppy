package co.ProductRegistration;

public class ITEMList {
	
	private int num; // 상품번호
	private String name;  //상품명
	private String image; //상품 이미지
	private String information;  //품목정보
	private String categori;  //카테고리 선택 
	private String company;   //생산 회사
	private String contry;    //생산 국가
	private int price;        //상품 가격
	private int offprice;     //할인된 가격
	private int avstock;      //재고량(입고량?)
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getCategori() {
		return categori;
	}
	public void setCategori(String categori) {
		this.categori = categori;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOffprice() {
		return offprice;
	}
	public void setOffprice(int offprice) {
		this.offprice = offprice;
	}
	public int getAvstock() {
		return avstock;
	}
	public void setAvstock(int avstock) {
		this.avstock = avstock;
	}
	@Override
	public String toString() {
		return "ITEMList [num=" + num + ", name=" + name + ", image=" + image + ", information=" + information
				+ ", categori=" + categori + ", company=" + company + ", contry=" + contry + ", price=" + price
				+ ", offprice=" + offprice + ", avstock=" + avstock + "]";
	}
	
	

}
