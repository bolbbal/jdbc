package javaBasic;

import java.util.Scanner;

public class Java38_doubleFor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		int answer = 0;
		int count = 0;
		answer = (int)(Math.random()*100)+1;
		
		System.out.println("Up Down Game");
		do {
			System.out.print("1 ~ 100 사이의 정수 입력 : ");
			input = sc.nextInt();
			if (input < answer) {
				System.out.println("Up");
			} else if (input > answer) {
				System.out.println("Down");
			}
			count++;
		} while(input != answer);
		
		System.out.println("정답 : " + answer);
		System.out.println("정답까지 걸린 횟수 : " + count);
		
		input = 0;
		answer = (int)(Math.random()*100)+1;
		count = 0;
		
		for (;;) {
			System.out.print("1 ~ 100 사이의 정수 입력 : ");
			input = sc.nextInt();
			if (input < answer) {
				System.out.println("Up");
			} else if (input > answer) {
				System.out.println("Down");
			} else {
				break;
			}
			count++;
			
		}
		
		System.out.println("정답 : " + answer);
		System.out.println("정답까지 걸린 횟수 : " + count);
		
		input = 0;
		answer = (int)(Math.random()*100)+1;
		count = 0;
		
		while(answer != input) {
			System.out.print("1 ~ 100 사이의 정수 입력 : ");
			input = sc.nextInt();
			if (input < answer) {
				System.out.println("Up");
			} else if (input > answer) {
				System.out.println("Down");
			}// else {
				//break;
		//	}
			count++;
			
		}
		
		System.out.println("정답 : " + answer);
		System.out.println("정답까지 걸린 횟수 : " + count);
		
	}

}
