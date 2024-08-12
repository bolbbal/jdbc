package javaBasic;

import java.util.Scanner;

public class Java57_method {
	
	public static void sum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("���� 1 ~ " + n + " ������ �� : " + sum);
	}
	
	public static int odd(int n) {
		int count = 0;
		System.out.print(n + "������ Ȧ�� : ");
		for (int i = 1; i <= n; i++) {
			if(i % 2 != 0) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		return count;
	}
	
	public static int evenOdd(int n) {
		int even = 0;
		int odd = 0;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			if(i % 2 != 0) {
				odd += i;
			} else if (i % 2 == 0) {
				even += i;
			}
		}
		System.out.println("���� 1 ~ " + n + " ���� Ȧ���� �� : " + odd);
		System.out.println("���� 1 ~ " + n + " ���� ¦���� �� : " + even);
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		sum(num);
		int count = odd(num);
		System.out.println("���� 1 ~ " + num + " ���� Ȧ���� ���� : " + count);
		int tot = evenOdd(num);
		System.out.println("���� 1 ~ " + num + " ������ �� : " + tot);

	}

}
