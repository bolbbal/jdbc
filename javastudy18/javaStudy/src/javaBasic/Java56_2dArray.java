package javaBasic;

public class Java56_2dArray {
	
	static int[][] score = {
			{11, 100, 100, 100},
			{22, 90, 90 , 90},
			{33, 80, 80, 80}
			};
	
	public static void getLength() {
		System.out.println(score.length);
		System.out.println(score[0].length);
		System.out.println(score[1].length);
		System.out.println(score[2].length);
	}

	public static void main(String[] args) {
		//2차원 배열과 초기화
		//메소드 (Method)란
		//특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
		//선언부(머리)와 구현(몸통)으로 이루어져 있다
		//형식
		//접근제한자 반환타입 메소드이름(매개변수) {실행문; return 값;}
		
		getLength();		
		
		System.out.println();
		
		int tkor = 0;
		int teng = 0;
		int tmat = 0;
		int totl = 0;
		double avg = 0.0;
		String grade = null;
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + " ");
				tkor = tkor+score[i][1];
				teng = teng+score[i][2];
				tmat = tmat+score[i][3];
				totl = score[i][1]+score[i][2]+score[i][3];
				avg = totl / 3.;
				if(avg >= 90) {
					grade = "A";
				} else if(avg >= 80) {
					grade = "B";
				} else if(avg >= 70) {
					grade = "C";
				} else {
					grade = "재시험";
				}
				
			}
			System.out.print(totl + " ");
			System.out.print(avg + " ");
			System.out.print(grade + " ");
			System.out.println();
		}
		
	}

}
