package domain;

public class SingerVo {
	private int singer_idx;
	private String singer;
	private String singer_img;
	private int suggest_count;
	
	public int getSuggest_count() {
		return suggest_count;
	}
	public void setSuggest_count(int suggest_count) {
		this.suggest_count = suggest_count;
	}
	public int getSinger_idx() {
		return singer_idx;
	}
	public void setSinger_idx(int singer_idx) {
		this.singer_idx = singer_idx;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getSinger_img() {
		return singer_img;
	}
	public void setSinger_img(String singer_img) {
		this.singer_img = singer_img;
	}
	
	
}
