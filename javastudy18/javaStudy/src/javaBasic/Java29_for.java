package javaBasic;

import java.util.Scanner;

public class Java29_for {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int odd = 0;
		int even = 0;
		int mul3 = 0;
		int countOdd = 0;
		int countEven = 0;
		int countMul3 = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "��° ������ �Է��ϼ���. : ");
			num = sc.nextInt();
			if (num % 2 == 1) {
				odd += num;
				countOdd++;
			} else {
				even += num;
				countEven++;
			} 
			if (num % 3 == 0) {
				mul3 += num;
				countMul3++;
			}
		}
		System.out.println("Ȧ���� �� : " + odd);
		System.out.println("Ȧ���� ���� : " + countOdd);
		System.out.println("¦���� �� : " + even);
		System.out.println("¦���� ���� : " + countEven);
		System.out.println("3�� ����� �� : " + mul3);
		System.out.println("3�� ����� ���� : " + countMul3);
	}

}
