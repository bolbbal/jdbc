package javaBasic;

import java.util.Scanner;

public class Java21_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է�(0~100) : ");
		int score = sc.nextInt();
		String grade = "F";
		
		if (90 <= score && score <= 100) {
			grade = "A";
		} else if (80 <= score && score < 90) {
			grade = "B";
		} else if (70 <= score && score < 80) {
			grade = "C";
		} else if (60 <= score && score < 70) {
			grade = "D";
		}
		
		switch(grade) {
		case "A":
		case "B":
		case "C":
		case "D":
			System.out.println(score + "���� " + grade + "�����Դϴ�.");
			break;
		default:
			System.out.println(score + "���� ����� �Դϴ�.");
		}
		System.out.print("\n");
		switch(score/10) {
		case 10: case 9: case 8: case 7: case 6:
			System.out.println(score + "���� " + grade + "�����Դϴ�.");
			break;
		default:
			System.out.println(score + "���� ����� �Դϴ�.");
		}
	}

}
