package javaBasic;

import java.util.Scanner;

public class Java20_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է��ϼ��� : ");
		int month = sc.nextInt();
		String season = null;
		
		if (3 <= month && month <= 5) {
			season = "spring";
		} else if (6 <= month && month <= 8) {
			season = "summer";
		} else if (9 <= month && month <= 11) {
			season = "autumn";
		} else if (12 <= month || month <= 2) {
			season = "winter";
		}
		
		switch(season) {
		case "spring":
			System.out.println("�� �Դϴ�.");
			break;
		case "summer":
			System.out.println("���� �Դϴ�.");
			break;
		case "autumn":
			System.out.println("���� �Դϴ�.");
			break;
		case "winter":
			System.out.println("�ܿ� �Դϴ�.");
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("�� �Դϴ�.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("���� �Դϴ�.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("���� �Դϴ�.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("�ܿ� �Դϴ�.");
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
		}

	}

}
