package javaBasic;

import java.util.Scanner;

public class Java06_read {
	public static void main(String[] args) {
		//Ű����� ������ �Է¹ޱ� - ǥ�� �Է�
		
		//Scanner class
		//ȭ������ ���� �����͸� �Է¹޴� ����� �����ϴ� Ŭ����
		//��ü�� �����ϴ� Ű���� = new
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ �Է� : ");
		int i = sc.nextInt();
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� ���� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int mat = sc.nextInt();

		System.out.println("��ȣ = " + i);
		System.out.println("�̸� = " + name);
		System.out.println("���� ���� = " + kor);
		System.out.println("���� ���� = " + eng);
		System.out.println("���� ���� = " + mat);
		System.out.println("���� = " + (kor + eng + mat));
		System.out.println("��� = " + (kor + eng + mat) / 3);
	}
}
		/*String[] grade = {"��ȣ", "�̸�", "����", "����", "����"};
	}
}
public static String score(int num, String name, String kor, String eng, String mat) {
	
}*/