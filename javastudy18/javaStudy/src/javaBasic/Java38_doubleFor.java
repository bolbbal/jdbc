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
			System.out.print("1 ~ 100 ������ ���� �Է� : ");
			input = sc.nextInt();
			if (input < answer) {
				System.out.println("Up");
			} else if (input > answer) {
				System.out.println("Down");
			}
			count++;
		} while(input != answer);
		
		System.out.println("���� : " + answer);
		System.out.println("������� �ɸ� Ƚ�� : " + count);
		
		input = 0;
		answer = (int)(Math.random()*100)+1;
		count = 0;
		
		for (;;) {
			System.out.print("1 ~ 100 ������ ���� �Է� : ");
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
		
		System.out.println("���� : " + answer);
		System.out.println("������� �ɸ� Ƚ�� : " + count);
		
		input = 0;
		answer = (int)(Math.random()*100)+1;
		count = 0;
		
		while(answer != input) {
			System.out.print("1 ~ 100 ������ ���� �Է� : ");
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
		
		System.out.println("���� : " + answer);
		System.out.println("������� �ɸ� Ƚ�� : " + count);
		
	}

}
