package javaBasic;

import java.util.Scanner;

public class Java11_logicOperator {
	public static void main(String[] args) {
		// 논리 연산자
		// ||(or), &&(and)
		// 실행 순서는 not < and < or
		// x는 10보다 크고, 20보다 작다.
		int x = 20, y = 30;
		System.out.println(x > 10 && x < 20);
		System.out.println(10 < x && x < 20);
		System.out.println(x%2 == 0 || x%3 == 0);
		
		System.out.println(x%2 == 0 || x%3 == 0 && x%6 != 0);
		char a = 'A';
		System.out.println("A = " + a);
		System.out.println("A = " + (int) a);
		System.out.println("A = " + (char) 65);
		
		System.out.println(x>=20? "까꿍" : "메롱");
		
		//문자를 하나 입력받아 숫자인지 문자인지 체크하는 프로그램
		Scanner sc = new Scanner(System.in);
		char ch = ' ';
		System.out.print("문자를 입력하세요.");
		String input = sc.next();
		ch = input.charAt(0); //0번째 값을 가져와 ch에 저장
		if('0' <= ch && ch <= '9') {
			System.out.println("숫자 입니다.");
		}
		if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
			System.out.println("영문자 입니다.");
		}
		
		System.out.println(!('a' <= ch && ch <= 'z')); //true의 반대(!) false 출력
		
		//조건연산자 = 삼항 연산자
		//조건식 ? 식1 : 식2
		//조건이 참이면 식1 실행, 거짓이면 식2 실행
		
		
	}
}
