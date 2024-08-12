package javaBasic;

import java.util.Scanner;

public class Java34_for {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num = 0;
		int count = 1;
		double avg = 0;
		
		boolean A = true;
		System.out.println();
		
		for (;;) {
			System.out.print("for문 " + count + "번째 정수 입력 (종료 -1) : ");
			num = sc.nextInt();
			if (num == -1) {
				break;
			} else {
				sum += num;
				count++;
			}
		}
		avg = (double) sum / (count - 1);
		System.out.println("for문 입력된 정수의 수 : " + (count - 1));
		System.out.println("for문 합계 : " + avg);
		
		sum = 0;
		num = 0;
		count = 1;
		avg = 0;
		while (true) {
			System.out.print("while문 " + count + "번째 정수 입력 (종료 -1) : ");
			num = sc.nextInt();
			if (num == -1) {
				break;
			} else {
				sum += num;
				count++;
			}
		}
		avg = (double) sum / (count - 1);
		System.out.println("while문 입력된 정수의 수 : " + (count - 1));
		System.out.println("while문 합계 : " + avg);
		
		sum = 0;
		num = 0;
		count = 1;
		avg = 0;
		do {
			System.out.print("do문 " + count + "번째 정수 입력 (종료 -1) : ");
			num = sc.nextInt();
			if (num == -1) {
				break;
			} else {
				sum += num;
				count++;
			}
		} while (true);
		avg = (double) sum / (count - 1);
		System.out.println("do문 입력된 정수의 수 : " + (count - 1));
		System.out.println("do문 합계 : " + avg);
	}

}
