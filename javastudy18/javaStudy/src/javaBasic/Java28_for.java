package javaBasic;

import java.util.Scanner;

public class Java28_for {

	public static void main(String[] args) {
		//10���� ������ �Է��Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		double avg = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "��° ���� �� �Է� : ");
			num = sc.nextInt();
			sum += num;
			avg = (double) sum / i;
		}
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + avg);
	}

}
