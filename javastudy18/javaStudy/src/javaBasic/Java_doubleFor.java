package javaBasic;

import java.util.Scanner;

public class Java_doubleFor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("예금액 입력 : ");
		int currency = sc.nextInt(); //예금액
		System.out.print("금리 입력 : ");
		double rate = sc.nextDouble();
		System.out.print("기간 입력 : ");
		int year = sc.nextInt();
		
		double total = 0;
		
		for (int i = 1; i <= year; i++) {
			
			total = currency * ((double)Math.pow(1.0 + rate, i));
		
			System.out.printf("%4d 년%20.3f 원\n", i, total);
		}
		
	}
}
