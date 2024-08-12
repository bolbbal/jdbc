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
		//2���� �迭�� �ʱ�ȭ
		//�޼ҵ� (Method)��
		//Ư�� �۾��� �����ϴ� �Ϸ��� ������� �ϳ��� ���� ��
		//�����(�Ӹ�)�� ����(����)���� �̷���� �ִ�
		//����
		//���������� ��ȯŸ�� �޼ҵ��̸�(�Ű�����) {���๮; return ��;}
		
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
					grade = "�����";
				}
				
			}
			System.out.print(totl + " ");
			System.out.print(avg + " ");
			System.out.print(grade + " ");
			System.out.println();
		}
		
	}

}
