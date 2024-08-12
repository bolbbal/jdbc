package javaBasic;

import java.util.Scanner;

public class Java28_for {

	public static void main(String[] args) {
		//10개의 정수를 입력하시오.
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		double avg = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "번째 정수 값 입력 : ");
			num = sc.nextInt();
			sum += num;
			avg = (double) sum / i;
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
