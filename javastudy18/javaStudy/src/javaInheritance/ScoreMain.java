package javaInheritance;

public class ScoreMain {

	public static void main(String[] args) {
		//���(inheritance)
		//������ Ŭ������ �����Ͽ� ���ο� Ŭ������ ����� ��
		//�θ� Ŭ�������� ������� �������, �޼��带 �ڽ�Ŭ������ �����޴´�.
		//��, �����ڿ� �ʱ�ȭ ���� ��ӵ��� �ʴ´�.
		//�ڼ� Ŭ������ ��� ������ ���� Ŭ�������� �׻� ���ų� ����.
		//����� ���� �ڵ��� ������ ���̰�, �ڵ��� �ߺ� ����, ���α׷��� ���꼺�� ���������� ���δ�.
		//��� ���� Ű���� : extends
		
		//�ڼ�Ŭ������ �����ڰ� ������ ����Ʈ �����ڰ� ȣ��Ǿ� �����Ѵ�.
		//���߻���� �������� �ʴ´�.
		//����� �ֻ��� ���� Ŭ������ java.lang.Object Ŭ���� �̴�.
		//��� Ŭ������ �ڵ����� Object Ŭ������ ��ӹ޴´�.
		
		//super : �ڼ� Ŭ������ ���� Ŭ������ ����� �����ϴ� �� ����Ѵ�.
		//super() : �ڼ� Ŭ�������� ���� Ŭ������ �����ڸ� ȣ���� �� ����Ѵ�. ���� ù �ٿ� �ڵ��ؾ��Ѵ�.
		
		//this : �ڽ� Ŭ������ ��� ���� ����, this() : �ڽ� Ŭ������ �ٸ� �����ڸ� ȣ��
//		Student stu1 = new Student();
		//�Ű������� �ִ� �����ڸ� ����� �⺻ �����ڸ� ���� ���Ѵ�.
		Student[] students = new Student[3];
		
		Student stu1 = new GradeStudent("202401", "ȫ�浿", 100, 100, 100);
		Student stu2 = new GradeStudent("202402", "��浿", 90, 90, 90);
		Student stu3 = new GradeStudent("202403", "�ڱ浿", 80, 80, 80);
		
		students[0] = stu1;
		students[1] = stu2;
		students[2] = stu3;
		
		//�������̵�(Overriding)
		//�θ� Ŭ�����κ��� ��ӹ��� �޼ҵ带 �������ؼ� ����� �� �ִ�.
		
		System.out.println(students[0].toString());
		System.out.println(students[1].toString());
		System.out.println(students[2].toString());
		
	}

}
