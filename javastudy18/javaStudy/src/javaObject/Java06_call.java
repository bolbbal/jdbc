package javaObject;

public class Java06_call {
	
	public static long factorial(int n) {
		long result = 0;
		System.out.println("result : " + result + ", n : " + n);
		if(n==1) {
			result = 1;
		} else {
			result = n * factorial(n-1);
		}
		return result;
	}

	public static void main(String[] args) {
		//��� ȣ��
		//�޼��� ������ �ڱ� �ڽ��� �ݺ������� ȣ���Ѵ�
		//���丮��, ����, Ʈ��, ������� � ����Ѵ�
		//4! = 4*3*2*1
		
		long result = factorial(4);
		System.out.println(result);

	}

}
