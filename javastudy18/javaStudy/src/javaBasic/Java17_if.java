package javaBasic;

import java.util.Scanner;

public class Java17_if {

	public static void main(String[] args) {
//		System.out.println(Math.round(3.141592));
//		System.out.println(Math.round(3.141592*10));
//		System.out.println(Math.round(3.141592*10)/10.);
//		
//		System.out.println(Math.round(3.141592));
//		System.out.println(Math.round(3.141592*100));
//		System.out.println(Math.round(3.141592*100)/100.);
//		
//		System.out.println(Math.round(3.141592));
//		System.out.println(Math.round(3.141592*1000));
//		System.out.println(Math.round(3.141592*1000)/1000.);
//		
//
//		System.out.println(Math.round(3.141592));
//		System.out.println(Math.round(3.141592*10000));
//		System.out.println(Math.round(3.141592*10000)/10000.);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�г� : ");
		int year = sc.nextInt();
		System.out.print("���� : ");
		int score = sc.nextInt();
		String grade;
		
		if ((year <= 3 && score >= 60) || (year == 4 && score >= 70)) {
			grade = "�հ�";
		} else {
			grade = "���հ�";
		}
		
//		if (year == 4) {
//			if (score >= 70) {
//				grade = "�հ�";
//			} else {
//				grade = "���հ�";
//			}
//		} else {
//			if (score >= 60) {
//				grade = "�հ�";
//			} else {
//				grade = "���հ�";
//			}
//		}
		System.out.println("�г� : " + year);
		System.out.println("���� : " + score);
		System.out.println("�հݿ��� : " + grade);
		
		
		
	}

}
