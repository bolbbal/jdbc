package javaObject;

public class Java01_class {

	public static void main(String[] args) {
		//class
		//객체를 생성하기위한 설계도 또는 틀
		//구성요소는 멤버변수, 생성자, 메소드가 있다.
		//속성은 멤버변수, 기능은 메소드라고 부른다.
		
		//인스턴스 : 클래스를 객체로 생성하는 과정
		
		//객체(Object)
		//클래스에 정의된 대로 메모리에 생성된 것

		//생성자
		//객체 생성 후 멤버변수를 초기화 시킨다
		
		//Score 클래스를 사용하고 싶다면
		Score score = new Score();
		score.bno = 1111;
		score.name = "홍길동";
		score.kor = 100;
		score.eng = 100;
		score.mat = 100;
		score.calculator();
		score.title();
		score.getRecord();
		
		Score score1 = new Score(2222, "이순신", 90, 90, 90);
		score1.calculator();
		score1.title();
		score1.getRecord();
		
		Score score2 = new Score(3333, "김일성", 100, 90, 80);	
		score2.calculator();
		score2.title();
		score2.getRecord();
		}

}
