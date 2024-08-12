package javaBasic;

import java.util.Arrays;
import java.util.Scanner;

public class Java46_array {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] array = new int[5];
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(i+1 + "번째 정수 입력 >> ");
			array[i] = sc.nextInt();
			
		}
		System.out.println(Arrays.toString(array));
		
		int max = 0;
		int min = 0;
		for (int i = 0; i < array.length; i++) {
			min = array[0];
			if(max < array[i]) {
				max = array[i];
			}
			if(min > array[i]) {
				min = array[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}

}
