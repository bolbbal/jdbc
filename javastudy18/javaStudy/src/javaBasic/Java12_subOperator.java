package javaBasic;

public class Java12_subOperator {
	//�ҽ� ������ �̸��� Ŭ������ �̸��� ���ƾ��Ѵ�.

	public static void main(String[] args) {
		int x = 100;
		x += 100;
		System.out.printf("x += %d\n", x); //printf �� f = ��� ����, %d = 10���� ����
		x = 100;
		x -= 10;
		System.out.printf("x -= %d\n", x);
		x = 100;
		x *= 10;
		System.out.printf("x *= %d\n", x);
		x = 100;
		x /= 10;
		System.out.printf("x /= %d\n", x);
		x = 100;
		x %= 10;
		System.out.printf("x %%= %d\n", x);
		
		int i, j, k = 0;
		i = j = k = 100;
		
		k += i + j;
		// k = 300
		i += j -= k *= 5;
		// k = 1500, j = -1400, i = -1300
		i += j = k;
		// k = 1500, j = 1500, i = 200
		System.out.println(i + ", " + j + ", " + k);
		
		//ū ������ ���� ���� ���� �� ���� ���� ���Ͻÿ�
		int a = 3, b = 5;
		System.out.println(a>=b?a-b:b-a);
	}

}
