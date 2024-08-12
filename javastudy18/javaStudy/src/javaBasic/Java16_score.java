package javaBasic;

import java.util.Scanner;

public class Java16_score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat;
		System.out.print("학번을 입력하세요 : ");
		int bno = sc.nextInt();  
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("국어 영어 수학 점수를 입력하세요 : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		int tot = kor + eng + mat;
		double avg = (double) tot / 3;
		avg = Math.round(avg * 100) / 100.0;
		
		String grade;
		if (avg >= 90) {
			grade = "A학점";
		} else if (avg >= 80) {
			grade = "B학점";
		} else if (avg >= 70) {
			grade = "C학점";
		} else {
			grade = "재시험";
		}
		
		System.out.println("\t\t성적표");
		System.out.println("-----------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-----------------------------------------");
		System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + grade);
	}
}
