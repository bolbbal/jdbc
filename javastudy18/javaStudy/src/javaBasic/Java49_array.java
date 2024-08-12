package javaBasic;

import java.util.Arrays;

public class Java49_array {

	public static void main(String[] args) {	
		//레퍼런스 치환과 배열 공유, 배열 복제
		int[] var = {10, 20, 30, 40, 50};
		int[] pt = var;
		
		System.out.println(var[0]);
		System.out.println(pt[0]);
		
		pt[1] = 100;
		System.out.println(var[1]);
		System.out.println(pt[1]);
		
		int score[] = {100, 200, 300, 400, 500};
		for(int num : score) {
			System.out.print(num + "\t");
		}
		System.out.println();
		
		int[] imsi = score.clone();
		System.out.println(Arrays.toString(imsi));
		
		score[1] = 1000;
		for(int num : imsi) {
			System.out.println(num + "\t");
		}
	}

}
