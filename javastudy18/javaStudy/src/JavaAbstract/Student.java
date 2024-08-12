package JavaAbstract;

public abstract class Student {
	
	//멤버변수
	protected String id;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	//생성자
	Student() {}
	Student(String id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//메서드
	public void tot() {
		tot = kor + eng + mat;
	}
	//추상메서드
	public abstract void ave();
}
