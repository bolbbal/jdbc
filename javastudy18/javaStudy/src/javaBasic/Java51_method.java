package javaBasic;

import java.util.Arrays;

public class Java51_method {
	public static void main(String[] args) {
		//�� ��ȯ
		int a = 100;
		int b = 200;
		int tmp = 0;
		System.out.println("��ȯ �� : " + a + "\t" + b);
		tmp = a;
		a = b;
		b = tmp;
		System.out.println("��ȯ �� : " + a + "\t" + b);
		
		//�޼ҵ� ȣ��
		swap(100, 200);
		
		//���� ȣ��
		int[] arr = new int[] {100, 200};
		int[] result = arrSwap(arr);
		System.out.println(Arrays.toString(result));
	}
	
	public static void swap(int a, int b) {
		System.out.println("��ȯ �� : " + a + "\t" + b);
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println("��ȯ �� : " + a + "\t" + b);
	}
	public static int[] arrSwap(int[] a) {
		//System.out.println("��ȯ �� : " + Arrays.toString(a));
		int tmp = a[0];
		a[0] = a[1];
		a[1] = tmp;
		//System.out.println("��ȯ �� : " + Arrays.toString(a));
		return a;
	}
}
