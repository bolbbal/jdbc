package javaBasic;

import java.util.Arrays;

public class Java45_array {

	public static void main(String[] args) {
		int[] bno = new int[10];
		String[] name = new String[10];
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] mat = new int[10];
		int[] tot = new int [] {300, 100, 200, 260, 180, 200};

		double[] ave = {100, 90, 89};
		char[] grade = {'A', 'B', 'C', 'D', 'F'};
		
		for (int i = 0; i < 5; i++) {
			System.out.println(tot[i]);
		}
		
		System.out.println(tot.length);
		
		for(int i = 0; i < tot.length; i++) {
			System.out.println(tot[i]);
		}
		
		System.out.println(Arrays.toString(tot));
		
		int[] score = {100, 200, 300};
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
			avg = (double) sum / score.length;
		}
		System.out.println(sum);
		System.out.println(avg);
	}

}
