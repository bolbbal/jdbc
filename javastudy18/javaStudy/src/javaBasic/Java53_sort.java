package javaBasic;

import java.util.Arrays;

public class Java53_sort {

	public static void main(String[] args) {
		// 선택정렬(Selection sort)
		// 오름차순 = ascending
		// 내림차순 = descending
		int[] a = {60, 40, 30, 80, 90, 45, 66, 39};
		System.out.println("정렬 전 = " + Arrays.toString(a));
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++) {
				if(a[i] > a[j]) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}
		System.out.println("정렬 후 = " + Arrays.toString(a));

	}

}
