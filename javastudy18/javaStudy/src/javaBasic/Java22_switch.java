package javaBasic;

import java.util.Scanner;

public class Java22_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� x �Է� : ");
		int x = sc.nextInt();
		
		System.out.print("���� y �Է� : ");
		int y = sc.nextInt();
		
		System.out.print("����[+, -, *, /, %] �ϼ��� >> ");
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
			System.out.println("�߸��� �Է��Դϴ�.");
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
			System.out.println("�߸��� �Է��Դϴ�.");
		}

	}

}
