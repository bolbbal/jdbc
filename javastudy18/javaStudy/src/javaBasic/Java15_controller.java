package javaBasic;

import java.util.Scanner;

public class Java15_controller {
	public static void main(String[] args) {
		// 키보드로 문자열을 입력받아서 다음 조건에 맞게 출력하는 프로그램을 작성하시오.
		// 입력형식
		// 신호등 1 : blue
		// 신호등 2 : yes
		// 건너갑니다
		// 신호등 1 : blue
		// 신호등 2 : no
		// 다음에 건너갑니다
		// 신호등 1 : red
		// 기다리세요
		// 신호등 1 : sky
		// 입력 오류 입니다
		
		//처리 조건
		//입력받은 값이 blue이면 
		//다시 키보드로 yes/no를 입력받아서 yes이면 건너갑니다 출력하고 no이면 다음에 건너갑니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("신호등1 : ");
		String tlight1  = sc.next();
		System.out.println("신호등 2 : ");
		String tlight2  = sc.next();
		if(tlight1.equals("blue") && tlight2.equals("no")) {
			System.out.println("다음에 건너갑니다");
		}
		if (tlight1.equals("blue") && tlight2.equals("yes")) {
			System.out.println("건너갑니다");
		}
		if (tlight1.equals("red") ) {
			System.out.println("기다리세요");
		}
		if (!tlight1.equals("blue") && !tlight1.equals("red"))  {
			System.out.println("입력올ㄹ입니다");
		}	
	}
}
