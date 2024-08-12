package javaObject;

//하나의 파일에 여러개의 클래스르 만들 수 있다.
class People {
	String name;
	int age;
	String tel;
	String address;
	
	public People() {
		//this() 생성자에서 다른 생성자를 호출할 수 있다.
		//반드시 첫줄에 코딩해야한다.
		this("이순신", 500, "010", "전주시");
	}
	public People(String name, int age, String tel, String address) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}
	
	//
}
public class Java02_class {
	
	
	public static void main(String[] args) {
		//클래스를 만들 때 생성자를 만들지 않으면 컴파일러가 생성자를 만들어 자동으로 삽입한다.
		//People people = new People();
		//매개변수가 있는 생성자를 만들면 컴파일러는 기본생성자를 만들지 않는다.
		People people1 = new People();
		System.out.println(people1.name);
		people1.name = "dd";
		people1.age = 0;
		people1.tel = "010";
		people1.address = "?";
		System.out.println(people1.name);
		People people = new People("자바야", 300, "010", "대한민국");
		System.out.println(people.name);
	}

}
