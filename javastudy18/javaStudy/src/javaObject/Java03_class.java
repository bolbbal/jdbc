package javaObject;

public class Java03_class {

	public static void main(String[] args) {
		//��ü �迭
		//��ü�� ������ �� �ִ� �迭
		int[] array = {1, 2, 3, 4, 5};
		
		Score[] score = new Score[3];
		Score score1 = new Score(1, "ȫ�浿", 100, 100, 100);
		score[0] = score1;
		Score score2 = new Score(2, "�̼���", 100, 100, 100);
		score[1] = score2;
		Score score3 = new Score(3, "�ڹپ�", 100, 100, 100);
		score[2] = score3;
		
		score[0].title();
		for (int i = 0; i < score.length; i++) {
			score[i].calculator();
			score[i].getRecord();
		}
		
	}

}
