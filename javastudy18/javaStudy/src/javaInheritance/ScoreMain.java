package javaInheritance;

public class ScoreMain {

	public static void main(String[] args) {
		//상속(inheritance)
		//기존의 클래스를 재사용하여 새로운 클래스를 만드는 것
		//부모 클래스에서 만들어진 멤버변수, 메서드를 자식클래스가 물려받는다.
		//단, 생성자와 초기화 블럭은 상속되지 않는다.
		//자손 클래가의 멤버 개수는 조상 클래스보다 항상 같거나 많다.
		//상속을 통해 코드의 재사용을 높이고, 코드의 중복 제거, 프로그램의 생산성과 유지보수에 쓰인다.
		//상속 구현 키워드 : extends
		
		//자손클래스의 생성자가 없으면 디폴트 생성자가 호출되어 실행한다.
		//다중상속은 지원하지 않는다.
		//상속의 최상위 조상 클래스는 java.lang.Object 클래스 이다.
		//모든 클래스는 자동으로 Object 클래스를 상속받는다.
		
		//super : 자손 클래스에 조상 클래스의 멤버를 참조하는 데 사용한다.
		//super() : 자손 클래스에서 조상 클래스의 생성자를 호출할 때 사용한다. 제일 첫 줄에 코딩해야한다.
		
		//this : 자신 클래스의 멤버 변수 참조, this() : 자신 클래스의 다른 생성자를 호출
//		Student stu1 = new Student();
		//매개변수가 있는 생성자를 만들면 기본 생성자를 생성 안한다.
		Student[] students = new Student[3];
		
		Student stu1 = new GradeStudent("202401", "홍길동", 100, 100, 100);
		Student stu2 = new GradeStudent("202402", "김길동", 90, 90, 90);
		Student stu3 = new GradeStudent("202403", "박길동", 80, 80, 80);
		
		students[0] = stu1;
		students[1] = stu2;
		students[2] = stu3;
		
		//오버라이딩(Overriding)
		//부모 클래스로부터 상속받은 메소드를 재정의해서 사용할 수 있다.
		
		System.out.println(students[0].toString());
		System.out.println(students[1].toString());
		System.out.println(students[2].toString());
		
	}

}
