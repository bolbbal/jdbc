package javaBasic;

import java.util.Scanner;

public class Java20_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("현재 월을 입력하세요 : ");
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
			System.out.println("봄 입니다.");
			break;
		case "summer":
			System.out.println("여름 입니다.");
			break;
		case "autumn":
			System.out.println("가을 입니다.");
			break;
		case "winter":
			System.out.println("겨울 입니다.");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
		
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("봄 입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름 입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을 입니다.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("겨울 입니다.");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}

	}

}
