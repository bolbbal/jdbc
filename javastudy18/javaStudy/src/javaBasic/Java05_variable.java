package javaBasic;

public class Java05_variable {
	public static void main(String[] args) {
		//������?
		//���� ������ �� �ִ� �޸��� Ư�� ������ ���̴� �̸�
		//���ͷ��̶�?
		//������ �����ϴ� ��
		//������ ����
		//����, �Ǽ�, ���ڿ�, ��ü
		//������ Ÿ��
		//���� = int(4byte), long(8byte), byte(8bit), short(2byte) | �Ǽ� = float(4byte), double(8byte) | ���ڿ� = String | ���� = char(1byte)
		//���� = boolean
		//byte, short, int, long, float, double, boolean, char => �⺻Ÿ��
		//�⺻Ÿ�� 8������ ����� ������ : ������
		
		//���Թ�
		//���� = ���ͷ�, ����  = ����, ���� = ����
		
		//300�� ���� x�� �����Ͻÿ�.
		int x = 300;
		System.out.println(x);
		
		int y;
		y = 300;
		System.out.println(y);
		
		double i = 123.45;
		System.out.println(i);
		
		double j = i;
		System.out.println(j);
		
		//��� = final
		//���� ������ �ʴ� ��
		// �� = 3.141592
		final double PI = 3.141592;
		//PI = 3.14;
		System.out.println(PI);
		
		char ch = 'A';
		String str = "abc";
		//ch = "abcd"; ����. ���ڿ��� �ѱ��ڸ� ������ ������ ch�� ������ �� ����.
		System.out.println(ch);
		System.out.println(str);
		
		boolean power = true;
		byte b = 127;
	}
}
