package javaObject;

public class Score {//성적표 설계도
	//멤버변수
	int bno;
	String name;
	int kor, eng, mat;
	int tot;
	double avg;
	String grade;
	int rank;
	
	//생성자의 이름은 클래스의 이름과 같다.
	//생성자는 리턴 타입이 없다. 리턴 타입이 없다고 해도 void는 적지 않는다. 
	//클래스에 생성자가 하나도 선언되지 않은 경우 컴파일러에 의해 자동으로 삽입된다.
	
	//오버로딩(Overloading)
	//이름이 같은 메서드 또는 생성자를 여러개 만들 수 있다. 단, 매개변수의 개수나 타입이 서로 같지 않아야 한다.
	public Score() {
		
	}
	
	public Score(int bno, String name, int kor, int eng, int mat) {
		this.bno = bno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public Score(int bno, String name, short kor, int eng, int mat) {
		this.bno = bno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//메소드
	public void calculator() {
		tot = kor + eng + mat;
		avg = tot / 3.;
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else {
			grade = "재시험";
		}
	}
	
	public void title() {
		System.out.println("\t\t\t\t성적표");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t등수");
	}
	
	public void getRecord() {
		System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng  + "\t" 
				+ mat + "\t" + tot + "\t" + avg + "\t" + grade + "\t" + rank);
	}
	
	public double getSum(int a, int b) {
		int sum = 0;
		sum = sum + a;
		sum = sum + b;
		return sum;
	}
	
	public int getSum() {
		int a = 10; int b = 20;
		int sum = 0;
		sum = sum + a;
		sum = sum + b;
		return sum;
	}

}
