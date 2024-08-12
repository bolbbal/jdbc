package javaObject;

public class Java03_class {

	public static void main(String[] args) {
		//객체 배열
		//객체를 저장할 수 있는 배열
		int[] array = {1, 2, 3, 4, 5};
		
		Score[] score = new Score[3];
		Score score1 = new Score(1, "홍길동", 100, 100, 100);
		score[0] = score1;
		Score score2 = new Score(2, "이순신", 100, 100, 100);
		score[1] = score2;
		Score score3 = new Score(3, "자바야", 100, 100, 100);
		score[2] = score3;
		
		score[0].title();
		for (int i = 0; i < score.length; i++) {
			score[i].calculator();
			score[i].getRecord();
		}
		
	}

}
