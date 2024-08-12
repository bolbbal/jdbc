package javaException;

public class ThrowsMain {

	public static void main(String[] args) throws Exception {
		method1();
	}
	
	static void method1() throws Exception {
		method2();
	}
	
	static void method2() throws Exception { //예외를 자신을 호출한 곳으로 전가시킨다.
		//예외가 발생하면 
	}

}
