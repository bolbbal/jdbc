package javaBasic;

import java.util.Scanner;

public class Java37_for {

	public static void main(String[] args) {
		// 피보나치 수열
		// 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열
		// 앞의 두 수가 1과 1이라면 다음 수는 2, 그 다음은 3, 그 다음은 5
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
		System.out.print("배열 길이 입력 : ");
		int a = sc.nextInt();
		int[] num = new int[a];
		
		System.out.print("수열 1 입력 : ");
		num[0] = sc.nextInt();
		System.out.print("수열 2 입력 : ");
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
