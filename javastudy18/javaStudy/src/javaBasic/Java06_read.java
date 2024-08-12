package javaBasic;

import java.util.Scanner;

public class Java06_read {
	public static void main(String[] args) {
		//키보드로 데이터 입력받기 - 표준 입력
		
		//Scanner class
		//화면으로 부터 데이터를 입력받는 기능을 제공하는 클래스
		//객체를 생성하는 키워드 = new
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 입력 : ");
		int i = sc.nextInt();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int mat = sc.nextInt();

		System.out.println("번호 = " + i);
		System.out.println("이름 = " + name);
		System.out.println("국어 점수 = " + kor);
		System.out.println("영어 점수 = " + eng);
		System.out.println("수학 점수 = " + mat);
		System.out.println("총점 = " + (kor + eng + mat));
		System.out.println("평균 = " + (kor + eng + mat) / 3);
	}
}
		/*String[] grade = {"번호", "이름", "국어", "영어", "수학"};
	}
}
public static String score(int num, String name, String kor, String eng, String mat) {
	
}*/