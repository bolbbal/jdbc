package javaBasic;

import java.util.Scanner;

public class Java13_example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요.");
		int bno = sc.nextInt();
		System.out.print("\n이름을 입력하세요.");
		String name = sc.next();
		System.out.print("\n국어 점수를 입력하세요.");
		int kor = sc.nextInt();
		System.out.print("\n영어 점수를 입력하세요.");
		int eng = sc.nextInt();
		System.out.print("\n수학 점수를 입력하세요.");
		int mat = sc.nextInt();
		
		int tot = kor + eng + mat;
		double avg = (double) tot / 3;
		avg = Math.round((avg-0.002) * 100) / 100.0;
		System.out.println("\t\t\t성적표");
		System.out.println("---------------------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t합격여부");
		System.out.println("---------------------------------------------------------------");
		System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + (avg>=70?"합격":"재시험"));
	}
}
