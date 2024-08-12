package javaObject;

class Student {
	//하나의 소스 파일에 여러개의 클래스를 만들 수 있지만, 접근 제한자는 한번만 사용할 수 있다.
	
	//객체변수 = 인스턴스변수(static이 붙지 않음) : 무조건 new 키워드로 인스턴스 생성해야 사용할 수 있는 변수
	String name;
	int age;
	
	//상수 : 변하지 않는 값
	final static double PI = 3.14; //final 상수는 대문자로 코딩하는 것이 관례
	
	//정적(static)변수 = 클래스변수 : 인스턴스 생성하지 않아도 사용 가능한 변수
	static int hakbun;
	
	public Student() {}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void method() {
		int temp = 0; //지역 변수 : 메서드 블럭 안에서만 사용 가능. method()가 호출이 될 때 생성되고 종료되면 소멸됨
		System.out.println(temp);
	}
	public static void method(int temp) {
		temp = 50; //지역 변수 : 메서드 블럭 안에서만 사용 가능. method()가 호출이 될 때 생성되고 종료되면 소멸됨
		System.out.println(temp);
	}
	public void mmethod(int temp) {
		temp = 50; //지역 변수 : 메서드 블럭 안에서만 사용 가능. method()가 호출이 될 때 생성되고 종료되면 소멸됨
		System.out.println(temp);
	}
}

public class Java05_scope {

	public static void main(String[] args) {
		// 변수의 범위(scope)
		// 변수의 선언 위치에 따라 변수의 종류(멤버 변수, 지역 변수)와 범위(scope)가 결정된다.
		
		//static변수 사용방법
		Student.hakbun=2222;
		Student.method(3000);
		System.out.println(Student.hakbun);
		
		Student stu = new Student("홍길동", 500);
		stu.name = "홍길동";
		stu.age = 500;
		stu.method();
		stu.mmethod(10000);
		
		stu.hakbun = 1111;
		System.out.println(stu.hakbun);
		
		//Student.PI = 3.0; 불가능
	}

}
