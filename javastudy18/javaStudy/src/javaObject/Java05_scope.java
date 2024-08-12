package javaObject;

class Student {
	//�ϳ��� �ҽ� ���Ͽ� �������� Ŭ������ ���� �� ������, ���� �����ڴ� �ѹ��� ����� �� �ִ�.
	
	//��ü���� = �ν��Ͻ�����(static�� ���� ����) : ������ new Ű����� �ν��Ͻ� �����ؾ� ����� �� �ִ� ����
	String name;
	int age;
	
	//��� : ������ �ʴ� ��
	final static double PI = 3.14; //final ����� �빮�ڷ� �ڵ��ϴ� ���� ����
	
	//����(static)���� = Ŭ�������� : �ν��Ͻ� �������� �ʾƵ� ��� ������ ����
	static int hakbun;
	
	public Student() {}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void method() {
		int temp = 0; //���� ���� : �޼��� �� �ȿ����� ��� ����. method()�� ȣ���� �� �� �����ǰ� ����Ǹ� �Ҹ��
		System.out.println(temp);
	}
	public static void method(int temp) {
		temp = 50; //���� ���� : �޼��� �� �ȿ����� ��� ����. method()�� ȣ���� �� �� �����ǰ� ����Ǹ� �Ҹ��
		System.out.println(temp);
	}
	public void mmethod(int temp) {
		temp = 50; //���� ���� : �޼��� �� �ȿ����� ��� ����. method()�� ȣ���� �� �� �����ǰ� ����Ǹ� �Ҹ��
		System.out.println(temp);
	}
}

public class Java05_scope {

	public static void main(String[] args) {
		// ������ ����(scope)
		// ������ ���� ��ġ�� ���� ������ ����(��� ����, ���� ����)�� ����(scope)�� �����ȴ�.
		
		//static���� �����
		Student.hakbun=2222;
		Student.method(3000);
		System.out.println(Student.hakbun);
		
		Student stu = new Student("ȫ�浿", 500);
		stu.name = "ȫ�浿";
		stu.age = 500;
		stu.method();
		stu.mmethod(10000);
		
		stu.hakbun = 1111;
		System.out.println(stu.hakbun);
		
		//Student.PI = 3.0; �Ұ���
	}

}
