package javaBasic;

import java.util.Scanner;

public class Java37_for {

	public static void main(String[] args) {
		// �Ǻ���ġ ����
		// ���� �� ���� ���ؼ� ���� ���� ����� ������ ����
		// ���� �� ���� 1�� 1�̶�� ���� ���� 2, �� ������ 3, �� ������ 5
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
				
		System.out.print(num1 + ", " + num2);
		
		for (int i = 0; i < 5; i++) {
			num3 = num1 + num2;
			System.out.print(", " + num3);
			num1 = num2;
			num2 = num3;
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭 ���� �Է� : ");
		int a = sc.nextInt();
		int[] num = new int[a];
		
		System.out.print("���� 1 �Է� : ");
		num[0] = sc.nextInt();
		System.out.print("���� 2 �Է� : ");
		num[1] = sc.nextInt();
		
		for (int i = 2; i < num.length; i++) {
			num[i] = num[i-2] + num[i-1];
		}
		
		for (int i = 0; i < num.length; i++) {
			if (i != num.length -1) {
				System.out.print(num[i] + ", ");
			} else {
				System.out.print((num[num.length - 1]));
			}
			
		}
		System.out.println();
		int index = 0;
	       for (int n : num) {
	           if (index < num.length - 1) {
	               System.out.print(n + ", ");
	           } else {
	                System.out.print(n);
	           }
	          index++;
	        }
		
	}

}
