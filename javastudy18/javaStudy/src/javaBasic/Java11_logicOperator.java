package javaBasic;

import java.util.Scanner;

public class Java11_logicOperator {
	public static void main(String[] args) {
		// �� ������
		// ||(or), &&(and)
		// ���� ������ not < and < or
		// x�� 10���� ũ��, 20���� �۴�.
		int x = 20, y = 30;
		System.out.println(x > 10 && x < 20);
		System.out.println(10 < x && x < 20);
		System.out.println(x%2 == 0 || x%3 == 0);
		
		System.out.println(x%2 == 0 || x%3 == 0 && x%6 != 0);
		char a = 'A';
		System.out.println("A = " + a);
		System.out.println("A = " + (int) a);
		System.out.println("A = " + (char) 65);
		
		System.out.println(x>=20? "���" : "�޷�");
		
		//���ڸ� �ϳ� �Է¹޾� �������� �������� üũ�ϴ� ���α׷�
		Scanner sc = new Scanner(System.in);
		char ch = ' ';
		System.out.print("���ڸ� �Է��ϼ���.");
		String input = sc.next();
		ch = input.charAt(0); //0��° ���� ������ ch�� ����
		if('0' <= ch && ch <= '9') {
			System.out.println("���� �Դϴ�.");
		}
		if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
			System.out.println("������ �Դϴ�.");
		}
		
		System.out.println(!('a' <= ch && ch <= 'z')); //true�� �ݴ�(!) false ���
		
		//���ǿ����� = ���� ������
		//���ǽ� ? ��1 : ��2
		//������ ���̸� ��1 ����, �����̸� ��2 ����
		
		
	}
}
