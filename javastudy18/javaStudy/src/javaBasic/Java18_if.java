package javaBasic;

public class Java18_if {
	public static void main(String[] args) {
		int x = 55;
		if (10 <= x || x <= 20) {
			System.out.println("���");
		}
		
		if (90<=x) {
			System.out.println("�հ�");
		}
		
		if (90 <= x || x <= 100) {
			System.out.println("�հ�");
		}
		
		if (90 <= x) {
			System.out.println("A");
		} else if (80 <= x) {
			System.out.println("B");
		} else {
			System.out.println("�����");
		}
	}
}
