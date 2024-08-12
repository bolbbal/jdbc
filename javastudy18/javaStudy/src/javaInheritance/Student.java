package javaInheritance;

public class Student { //부모 클래스
	//멤버변수
	protected String id;
	protected String name;
	protected int kor;
	protected int eng;
	protected int mat;
	
	public Student() {}
	public Student(String id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	@Override
		public String toString() {
			return "Student Id : " + id + "\t name : " + name + 
					"\t kor : " + kor + "\t eng : " + eng +
					"\t mat : " + mat;
		}
}
