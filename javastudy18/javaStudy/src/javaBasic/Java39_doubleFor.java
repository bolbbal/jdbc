package javaBasic;

import java.util.Scanner;

public class Java39_doubleFor {

	public static void main(String[] args) {
		//���߹���, ��ø�ݺ���
		//�ݺ����� �ٸ� �ݺ����� �����ϴ� ����
		//
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 10000; j++) {
				int num = (int) (Math.random() * 100) + 1;
				sum += num;
			}
		}
		System.out.println(sum);
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + (i * j) + " ");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 2; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("[" + i + "," + j + "]");
			}
			System.out.println();
		}
//		Scanner sc = new Scanner(System.in);
//		sum = 0;
//		for (int i = 1; i <= 5; i++) {
//			System.out.print(i + "��° ���� �Է� : ");
//			int num = sc.nextInt();
//			if (num <= 0) {
//				continue; //for������ �ǵ��ư���.
//			} else {
//				sum += num;
//			}
//		}
//		System.out.println(sum);
//		int a = 5;
		for (int i = 1; i < 5; i++) {
			for (int k = (5 - i); k >= 0; k--) {
				System.out.print(" ");
				
			}
			for(int j = 1; j <= (i * 2) -1; j++) {
				System.out.print("*");
			}	
			System.out.println();
		}
	}

}
