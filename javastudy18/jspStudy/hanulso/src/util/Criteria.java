package util;

public class Criteria {
	private int pageNum; //페이지 번호
	private int amount = 10; //1페이지에 출력할 레코드 개수
	private String type; //검색조건 title, content
	private String keyword; //검색 키워드
	
	public Criteria() {
		this(1);
	}
	public Criteria(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
