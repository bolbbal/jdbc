package JavaPackage;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class JavaObject {

	public static void print(Object obj) { //������
		System.out.println(obj.getClass().getName());
		System.out.println(obj.hashCode());
		//hashCode : ��ü�� �ĺ��ϴ� �ϳ��� ���� ������. ��ü�� �ּҸ� int Ÿ������ ��ȯ
		System.out.println(obj.toString());
		System.out.println(obj);
		
	}
	public static void main(String[] args) {
		//��Ű��(Package)
		//���� ���õ� Ŭ������ �������̽��� ������ �� Ŭ���� ���ϵ��� �ϳ��� ���丮�� ��� ���� ��
		//��Ű��� .jar ���Ϸ� ������ �� ����
		//JDK���� �����ϴ� ǥ�� ��Ű���� rt.jar�� ����Ǿ� �ִ�.
		//�ֿ� ��Ű��
		//java.lang : �����Լ�, ����� �� �ڹ� ���α׷��ֿ� �ʿ��� �⺻���� Ŭ������ �������̽�
		//java.util : ��¥, �ð�, ����, ��ø� ��� ���� �پ��� ��ƿ��Ƽ Ŭ������ �������̽�
		//java.io : Ű����, �����, ������, ��ũ � ������� �� �ִ� Ŭ������ �������̽�
		//java.swing : �ڹ� GUI ���α׷����� ���� ���� ��Ű��
		
		//�ڹ� API ���� :
		//Object Ŭ����
		//��� Ŭ������ Super Class
		//��� Ŭ������ ���� ����� �޴´�. 
		
		Point p = new Point(2,3);
		print(p);
		
	}

}
