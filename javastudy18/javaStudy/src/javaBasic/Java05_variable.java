package javaBasic;

public class Java05_variable {
	public static void main(String[] args) {
		//변수란?
		//값을 저장할 수 있는 메모리의 특정 번지에 붙이는 이름
		//리터럴이란?
		//변수에 저장하는 값
		//데이터 종류
		//정수, 실수, 문자열, 객체
		//데이터 타입
		//정수 = int(4byte), long(8byte), byte(8bit), short(2byte) | 실수 = float(4byte), double(8byte) | 문자열 = String | 문자 = char(1byte)
		//논리형 = boolean
		//byte, short, int, long, float, double, boolean, char => 기본타입
		//기본타입 8가지를 재외한 나머지 : 참조형
		
		//대입문
		//변수 = 리터럴, 변수  = 변수, 변수 = 수식
		
		//300을 변수 x에 저장하시오.
		int x = 300;
		System.out.println(x);
		
		int y;
		y = 300;
		System.out.println(y);
		
		double i = 123.45;
		System.out.println(i);
		
		double j = i;
		System.out.println(j);
		
		//상수 = final
		//값이 변하지 않는 값
		// ㅠ = 3.141592
		final double PI = 3.141592;
		//PI = 3.14;
		System.out.println(PI);
		
		char ch = 'A';
		String str = "abc";
		//ch = "abcd"; 에러. 문자열은 한글자만 저장이 가능한 ch에 저장할 수 없다.
		System.out.println(ch);
		System.out.println(str);
		
		boolean power = true;
		byte b = 127;
	}
}
