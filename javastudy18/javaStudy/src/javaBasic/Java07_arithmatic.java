package javaBasic;

import java.util.Scanner;

public class Java07_arithmatic {
	public static void main(String[] args) {
		//연산자
		//산술연산 : + - * / %
		//연산 순서 * / => + -
		//키보드로부터 두개의 정수값을 입력받아 산술연산을 하시오
		Scanner sc = new Scanner(System.in);
		System.out.print("a 값을 입력하세요 : ");
		int a = sc.nextInt(); //메소드 : ..을 실행하는 기능을 가지고 있다
		System.out.print("b 값을 입력하세요 : ");
		int b = sc.nextInt();
		
		System.out.println("두 정수의 합 : " + (a+b));
		System.out.println("두 정수의 차 : " + (a-b));
		System.out.println("두 정수의 곱 : " + (a*b));
		System.out.println("a를 b로 나눈 몫 : " + (a/b));
		System.out.println("a를 b로 나눈 나머지 : " + (a%b));
		
	}
}
