package javaBasic;

public class Java08 {
	public static void main(String[] args) {
		byte a; 
		a = 120;
		
		//byte b = 190; 127�����ۿ� ������ ���ϱ� ������ ����
		short c = 270; //2byte
		int d = 23456; //4byte
		long e = 2000000000; //8byte
		float f = 1234.5678f; //float�� �����ʹ� �ڿ� f �ٿ�����
		double g = 1234.5678d; //double�� �����ʹ� �ڿ� d �ٿ��������� ���� ����
		char h = 'A';
		System.out.println(h);
		String i = "abcd";
		//float j = 1234.5678; 8byte ũ���� ���ڸ� 4byte ũ���� ������ ���� ������ �� ��� ����
		boolean k = true;
		
		//���� ������ Ÿ�� String�� ������ �������� �⺻���� ���Ѵ�
		//������ : �� 8���� �⺻�� Ÿ���� ������ ������
		
		//���������
		int sum = 10 + 20 + 30;
		double tot = sum / 3; //����.���� = ����, ����.�Ǽ� = �Ǽ�, �Ǽ�.���� = �Ǽ�, �Ǽ�.�Ǽ� = �Ǽ�
		double mul = tot * 0.1;
		double result = tot - mul;
		int hap = sum % 3;
		
		System.out.println(sum);
		System.out.println(tot);
		System.out.println(mul);
		System.out.println(result);
		System.out.println(hap);
		System.out.println(20/3);
		System.out.println(20.0/3);
		
		//���������� ++ , -- 
		int count = 0;
		count = 1;
		count = count + 1;
		count += 1;
		System.out.println(count);
		
		count = ++count; //���������� ���� �� ����
		count = ++count;
		count = --count;
		System.out.println(count);
		
		count = count++; //���������� ���� �� ����
		count = count++;
		count = count--;
		System.out.println(count);
		
	}
}
