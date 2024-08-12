package javaBasic;

import java.util.Scanner;

public class Java22_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 x 입력 : ");
		int x = sc.nextInt();
		
		System.out.print("정수 y 입력 : ");
		int y = sc.nextInt();
		
		System.out.print("선택[+, -, *, /, %] 하세요 >> ");
		String cal = sc.next();
		
		if (cal.equals("+")) {
			System.out.println(x + cal + y + " = " + (x+y));
		} else if (cal.equals("-")) {
			System.out.println(x + cal + y + " = " + (x-y));
		} else if (cal.equals("*")) {
			System.out.println(x + cal + y + " = " + (x*y));
		} else if (cal.equals("/")) {
			System.out.println(x + cal + y + " = " + (x/y));
		} else if (cal.equals("%")) {
			System.out.println(x + cal + y + " = " + (x%y));
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		
		switch(cal) {
		case "+":
			System.out.println(x + cal + y + " = " + (x+y));
			break;
		case "-":
			System.out.println(x + cal + y + " = " + (x-y));
			break;
		case "*":
			System.out.println(x + cal + y + " = " + (x*y));
			break;
		case "/":
			System.out.println(x + cal + y + " = " + (x/y));
			break;
		case "%":
			System.out.println(x + cal + y + " = " + (x%y));
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}

	}

}
