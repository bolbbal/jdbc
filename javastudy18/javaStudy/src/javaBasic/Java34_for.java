package javaBasic;

import java.util.Scanner;

public class Java34_for {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num = 0;
		int count = 1;
		double avg = 0;
		
		boolean A = true;
		System.out.println();
		
		for (;;) {
			System.out.print("for�� " + count + "��° ���� �Է� (���� -1) : ");
			num = sc.nextInt();
			if (num == -1) {
				break;
			} else {
				sum += num;
				count++;
			}
		}
		avg = (double) sum / (count - 1);
		System.out.println("for�� �Էµ� ������ �� : " + (count - 1));
		System.out.println("for�� �հ� : " + avg);
		
		sum = 0;
		num = 0;
		count = 1;
		avg = 0;
		while (true) {
			System.out.print("while�� " + count + "��° ���� �Է� (���� -1) : ");
			num = sc.nextInt();
			if (num == -1) {
				break;
			} else {
				sum += num;
				count++;
			}
		}
		avg = (double) sum / (count - 1);
		System.out.println("while�� �Էµ� ������ �� : " + (count - 1));
		System.out.println("while�� �հ� : " + avg);
		
		sum = 0;
		num = 0;
		count = 1;
		avg = 0;
		do {
			System.out.print("do�� " + count + "��° ���� �Է� (���� -1) : ");
			num = sc.nextInt();
			if (num == -1) {
				break;
			} else {
				sum += num;
				count++;
			}
		} while (true);
		avg = (double) sum / (count - 1);
		System.out.println("do�� �Էµ� ������ �� : " + (count - 1));
		System.out.println("do�� �հ� : " + avg);
	}

}
