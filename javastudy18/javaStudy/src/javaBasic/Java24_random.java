package javaBasic;

import java.util.Scanner;

public class Java24_random {

	public static void main(String[] args) {
		//가위바위보 게임
		Scanner sc = new Scanner(System.in);
		
		int user, com;
		System.out.print("가위[1] 바위[2] 보[3] 중 하나를 선택하세요 >> ");
		user = sc.nextInt();
		com = (int)(Math.random()*3)+1;
		
		System.out.println("컴퓨터가 고른 것 : " + com);
		System.out.print("결과 : ");
		
		if (1 > user || user > 3) {
			System.out.println("잘못된 값 입력");
		} else if (user - com == -2 || user - com == 1) {
			System.out.println("승리");
		} else if (user - com == 2 || user - com == -1) {
			System.out.println("패배");
		} else if (user - com == 0) {
			System.out.println("무승부");
		}
		
		switch(user - com) {
		case 0:
			System.out.println("무승부");
			break;
		case -2: case 1:
			System.out.println("승리");
			break;
		case 2: case -1:
			System.out.println("패배");
			break;
		default:
			System.out.println("잘못된 값 입력");
		}
		
		switch(user) {
		case 1:
			if(com == 1) {
				System.out.println("무승부");
			} else if (com == 2) {
				System.out.println("패배");
			} else {
				System.out.println("승리");
			}
			break;
			
		case 2:
			if(com == 1) {
				System.out.println("승리");
			} else if (com == 2) {
				System.out.println("무승부");
			} else {
				System.out.println("패배");
			}
			break;
			
		case 3:
			if(com == 1) {
				System.out.println("패배");
			} else if (com == 2) {
				System.out.println("승리");
			} else {
				System.out.println("무승부");
			}
			break;
		}
	}

}
