package javaBasic;

import java.util.Scanner;

public class Java07_arithmatic {
	public static void main(String[] args) {
		//������
		//������� : + - * / %
		//���� ���� * / => + -
		//Ű����κ��� �ΰ��� �������� �Է¹޾� ��������� �Ͻÿ�
		Scanner sc = new Scanner(System.in);
		System.out.print("a ���� �Է��ϼ��� : ");
		int a = sc.nextInt(); //�޼ҵ� : ..�� �����ϴ� ����� ������ �ִ�
		System.out.print("b ���� �Է��ϼ��� : ");
		int b = sc.nextInt();
		
		System.out.println("�� ������ �� : " + (a+b));
		System.out.println("�� ������ �� : " + (a-b));
		System.out.println("�� ������ �� : " + (a*b));
		System.out.println("a�� b�� ���� �� : " + (a/b));
		System.out.println("a�� b�� ���� ������ : " + (a%b));
		
	}
}
