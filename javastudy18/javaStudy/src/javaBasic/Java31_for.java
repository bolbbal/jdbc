package javaBasic;

import java.util.Scanner;

public class Java31_for {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int mat = 0;
		int korSum = 0;
		int engSum = 0;
		int matSum = 0;
		double korAvg = 0;
		double engAvg = 0;
		double matAvg = 0;
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("국어, 영어, 수학 점수 입력 : ");
			
			kor = sc.nextInt();
			eng = sc.nextInt();
			mat = sc.nextInt();
			
			korSum += kor;
			engSum += eng;
			matSum += mat;
		}
		
		korAvg = (double) Math.round((korSum / 5.) * 100) / 100;
		engAvg = (double) Math.round((engSum / 5.) * 100) / 100;
		matAvg = (double) Math.round((matSum / 5.) * 100) / 100;
		
		System.out.println("국어총점\t영어총점\t수학총점");
		System.out.println(korSum + "\t" + engSum + "\t" + matSum);
		System.out.println("국어평균\t영어평균\t수학평균");
		System.out.println(korAvg + "\t" + engAvg + "\t" + matAvg);
		
		
	}

}
