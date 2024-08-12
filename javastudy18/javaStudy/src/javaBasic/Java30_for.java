package javaBasic;

import java.util.Scanner;

public class Java30_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int min = 999;
		int num = 0;
		int count = 1;
		int sum = 0;
		double avg = 0;
		char grade = ' ';
		for (;;) {
			System.out.print(count + "번째 정수를 입력하세요.");
			num = sc.nextInt();
			
			if (num == -99) {
				break;
			} else {
				if (max < num) {
					max = num;
				}
				if (min > num) {
					min = num;
				}
				count++;
			}
						
			sum += num;
		}
		sum = sum - max - min;
		avg = (double) sum / (count-1);
		
		if (avg >= 80) {
			grade = 'A';
		} else if (avg >= 70) {
			grade = 'B';
		} else if (avg >= 60) {
			grade = 'C';
		} else {
			grade = 'F';
		}
	
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);
		System.out.println("입력받은 개수 : " + (count-1));
		System.out.println("나머지 합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("등급 : " + grade);
	}
}
