package javaBasic;

public class Java44_array {

	public static void main(String[] args) {
		// �迭 (array)
		// ���� ���� �����͸� �����ϴ� �������� ��� ���
		
		//�迭 ����
		int[] a = new int[5];
		//�� ����
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		a[4] = 50;
		
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		System.out.println(a[3]);
//		System.out.println(a[4]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(a[i]);
		}
		
		double[] b = new double[5];
		b[0] = 1.0;
		b[1] = 1.1;
		b[2] = 1.2;
		b[3] = 1.3;
		b[4] = 1.4;
		//b[5] = 100.5; //ArrayIndexOutOfBoundsException ����
		
//		System.out.println(b[0]);
//		System.out.println(b[1]);
//		System.out.println(b[2]);
//		System.out.println(b[3]);
//		System.out.println(b[4]);
		//System.out.println(b[5]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(b[i]);
		}
		//int[5] c; �Ұ���
		
		//�ε��� ��ȣ�� ������ ����� �� ����.
		int[] array = new int[10];
		//array[-2] = 20; // /NegativeArraySizeException
		
		//�迭 ������ �ʱ�ȭ
		int[] array1 = {10, 20, 30, 40, 50};
//		System.out.println(array1[0]);
//		System.out.println(array1[1]);
//		System.out.println(array1[2]);
//		System.out.println(array1[3]);
//		System.out.println(array1[4]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(array1[i]);
		}
		
	}

}
