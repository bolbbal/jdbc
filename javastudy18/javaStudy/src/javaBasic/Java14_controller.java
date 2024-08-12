package javaBasic;

import java.util.Scanner;

public class Java14_controller {

	public static void main(String[] args) {
		// 제어문
		// 프로그램의 순차적인 실행순서를 변경시키는 것
		// 어느 조건에 따라 실행하여야 할 명령문의 실행 순서를 변경시키는 것을 제어(Control)이라 한다
		// 제어란 이런 프로그램의 흐름을 통제하는 것이다
		// 제어문에는 조건문과 반복문이 있다
		// 조건문은 조건에 따라 다른 문장이 수행되도록 하고,
		// 반복문은  특정 문장들을 반복해서 수행한다.
		
		// 단순 if문
		int num = 10;
		if (num%2 == 0) {
			System.out.println("입력된 " + num + "은 짝수입니다.");
		}
		System.out.println("프로그램 종료");
		
		if (10 <= num && num <= 20) {
			System.out.println("조건식은 참 입니다.");
		}
		System.out.println("프로그램 종료");

		//점수를 입력받아 점수가 80 이상이면 합격을 출력하시오
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		
		if (score >= 80) {
			System.out.println("합격");
		}
		System.out.println("프로그램 종료");
		
		System.out.print("점수 입력 : ");
		int value = sc.nextInt();
		String str = "";
		if (value >= 80) {
			str = "Pass";
		} else {
			str = "No";
		}
		System.out.println(value + " = " + str );
		
		if (value >= 80) {
			if (value <= 90) 
			System.out.println(value + " = Pass");
			else 
			System.out.println(value + " = No");
			}  	
		else {
			System.out.println("No");
		}

	}

}
