package javaBasic;

import java.util.Scanner;

public class Java_doubleFor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ݾ� �Է� : ");
		int currency = sc.nextInt(); //���ݾ�
		System.out.print("�ݸ� �Է� : ");
		double rate = sc.nextDouble();
		System.out.print("�Ⱓ �Է� : ");
		int year = sc.nextInt();
		
		double total = 0;
		
		for (int i = 1; i <= year; i++) {
			
			total = currency * ((double)Math.pow(1.0 + rate, i));
		
			System.out.printf("%4d ��%20.3f ��\n", i, total);
		}
		
	}
}
