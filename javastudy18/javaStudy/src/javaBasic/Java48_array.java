package javaBasic;

import java.util.Arrays;

public class Java48_array {

	public static void main(String[] args) {
		//���� for��
		int score[] = {79, 66, 77, 32, 59, 80};
		int sum = 0;
		System.out.println(Arrays.toString(score));
		for(int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println();
		
		//���� for == Ȯ�� for
		for(int num : score) {
			System.out.print(num + "\t");
			sum += num;
		}
		System.out.println();
		System.out.println(sum);
		System.out.println(sum / score.length);
	}

}
