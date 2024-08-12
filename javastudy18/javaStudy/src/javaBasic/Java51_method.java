package javaBasic;

import java.util.Arrays;

public class Java51_method {
	public static void main(String[] args) {
		//값 교환
		int a = 100;
		int b = 200;
		int tmp = 0;
		System.out.println("교환 전 : " + a + "\t" + b);
		tmp = a;
		a = b;
		b = tmp;
		System.out.println("교환 후 : " + a + "\t" + b);
		
		//메소드 호출
		swap(100, 200);
		
		//참조 호출
		int[] arr = new int[] {100, 200};
		int[] result = arrSwap(arr);
		System.out.println(Arrays.toString(result));
	}
	
	public static void swap(int a, int b) {
		System.out.println("교환 전 : " + a + "\t" + b);
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println("교환 후 : " + a + "\t" + b);
	}
	public static int[] arrSwap(int[] a) {
		//System.out.println("교환 전 : " + Arrays.toString(a));
		int tmp = a[0];
		a[0] = a[1];
		a[1] = tmp;
		//System.out.println("교환 후 : " + Arrays.toString(a));
		return a;
	}
}
