package javaBasic;

public class Java09_typeConversion { //����ȯ
	public static void main(String[] args) {
		//����ȯ�̶� : ���� �Ǵ� ����� Ÿ�Ԥ��� �ٸ� Ÿ������ ��ȯ�ϴ� ��
		double d = 85.7;
		//int score = d; 8byte ũ���� ���� 4byte ũ�� ������ ������ �� ����.
		int score = (int) d; //������ �ս� �߻�
		System.out.println(score);
		
		double s = score; //�ڵ� ����ȯ
		System.out.println(s);
		
		//Math.round() �� �ݿø��ϱ�
		//�Ҽ��� 1�ڸ����� �ݿø��Ѵ�.
		long result = Math.round(4.52);
		System.out.println(result);
		double pi = 3.141592;
		double shortpi = Math.round(pi * 1000) / 1000.0;
		System.out.println(shortpi);
		
	}
}
