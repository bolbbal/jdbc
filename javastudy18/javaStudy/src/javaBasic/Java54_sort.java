package javaBasic;

import java.util.Arrays;

public class Java54_sort {

	public static void main(String[] args) {
		// 버블 정렬(Bouble sort)
		int[] a = {60, 40, 30, 80, 90, 45, 66, 39};
		System.out.println("정렬 전 = " + Arrays.toString(a));
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		System.out.println("정렬 후 = " + Arrays.toString(a));

	}

}
