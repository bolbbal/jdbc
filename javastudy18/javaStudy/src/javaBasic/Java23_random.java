package javaBasic;

public class Java23_random {

	public static void main(String[] args) {
		//������ ���� �����
		//Math.random() : 0.0�� 1.0 ������ ������ double���� ��ȯ�Ѵ�
		System.out.println(Math.random()); // 0.0 <= Math.random < 1.0
		System.out.println(Math.random()*3); // 0.0 <= Math.random < 3.0
		System.out.println((int)(Math.random()*3)+1); // (int)1.0 <= (int)Math.randon() < (int)4.0
	}

}
