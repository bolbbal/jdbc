package javaObject;

//�ϳ��� ���Ͽ� �������� Ŭ������ ���� �� �ִ�.
class People {
	String name;
	int age;
	String tel;
	String address;
	
	public People() {
		//this() �����ڿ��� �ٸ� �����ڸ� ȣ���� �� �ִ�.
		//�ݵ�� ù�ٿ� �ڵ��ؾ��Ѵ�.
		this("�̼���", 500, "010", "���ֽ�");
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
		//Ŭ������ ���� �� �����ڸ� ������ ������ �����Ϸ��� �����ڸ� ����� �ڵ����� �����Ѵ�.
		//People people = new People();
		//�Ű������� �ִ� �����ڸ� ����� �����Ϸ��� �⺻�����ڸ� ������ �ʴ´�.
		People people1 = new People();
		System.out.println(people1.name);
		people1.name = "dd";
		people1.age = 0;
		people1.tel = "010";
		people1.address = "?";
		System.out.println(people1.name);
		People people = new People("�ڹپ�", 300, "010", "���ѹα�");
		System.out.println(people.name);
	}

}
