package javaException;

public class ThrowsMain {

	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1() throws Exception {
		method2();
	}
	
	static void method2() throws Exception { //���ܸ� �ڽ��� ȣ���� ������ ������Ų��.
		//���ܰ� �߻��ϸ� 
	}

}
