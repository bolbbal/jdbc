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
			System.out.print(count + "��° ������ �Է��ϼ���.");
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
	
		System.out.println("�ּҰ� : " + min);
		System.out.println("�ִ밪 : " + max);
		System.out.println("�Է¹��� ���� : " + (count-1));
		System.out.println("������ �հ� : " + sum);
		System.out.println("��� : " + avg);
		System.out.println("��� : " + grade);
	}
}
