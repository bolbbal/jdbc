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
			System.out.print(i + "번째 정수를 입력하세요. : ");
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
		System.out.println("홀수의 합 : " + odd);
		System.out.println("홀수의 개수 : " + countOdd);
		System.out.println("짝수의 합 : " + even);
		System.out.println("짝수의 개수 : " + countEven);
		System.out.println("3의 배수의 합 : " + mul3);
		System.out.println("3의 배수의 개수 : " + countMul3);
	}

}
