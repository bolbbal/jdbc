package javaBasic;

import java.util.Arrays;
import java.util.Scanner;

public class Java55_2dArray {

	public static void main(String[] args) {
		// 배열 : 1차원, 2차원, 3차원..
		int[][] score = new int[4][5];
		
		score[0][0] = 11;
		score[0][1] = 100;
		score[0][2] = 100;
		score[0][3] = 100;
		
		score[1][0] = 22;
		score[1][1] = 90;
		score[1][2] = 90;
		score[1][3] = 90;
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.print("학번 국어 영어 수학 입력 : ");
			for(int j = 0; j < 4; j++) {
				
				score[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < score.length; i++) {
			score[i][4] = score[i][1] + score[i][2] + score[i][3];
		}
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}	
		System.out.println(Arrays.deepToString(score));
	}

}
