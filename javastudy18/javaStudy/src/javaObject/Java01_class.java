package javaObject;

public class Java01_class {

	public static void main(String[] args) {
		//class
		//��ü�� �����ϱ����� ���赵 �Ǵ� Ʋ
		//������Ҵ� �������, ������, �޼ҵ尡 �ִ�.
		//�Ӽ��� �������, ����� �޼ҵ��� �θ���.
		
		//�ν��Ͻ� : Ŭ������ ��ü�� �����ϴ� ����
		
		//��ü(Object)
		//Ŭ������ ���ǵ� ��� �޸𸮿� ������ ��

		//������
		//��ü ���� �� ��������� �ʱ�ȭ ��Ų��
		
		//Score Ŭ������ ����ϰ� �ʹٸ�
		Score score = new Score();
		score.bno = 1111;
		score.name = "ȫ�浿";
		score.kor = 100;
		score.eng = 100;
		score.mat = 100;
		score.calculator();
		score.title();
		score.getRecord();
		
		Score score1 = new Score(2222, "�̼���", 90, 90, 90);
		score1.calculator();
		score1.title();
		score1.getRecord();
		
		Score score2 = new Score(3333, "���ϼ�", 100, 90, 80);	
		score2.calculator();
		score2.title();
		score2.getRecord();
		}

}
