package javaBasic;

public class Java08 {
	public static void main(String[] args) {
		byte a; 
		a = 120;
		
		//byte b = 190; 127까지밖에 저장을 못하기 때문에 에러
		short c = 270; //2byte
		int d = 23456; //4byte
		long e = 2000000000; //8byte
		float f = 1234.5678f; //float형 데이터는 뒤에 f 붙여야함
		double g = 1234.5678d; //double형 데이터는 뒤에 d 붙여야하지만 생략 가능
		char h = 'A';
		System.out.println(h);
		String i = "abcd";
		//float j = 1234.5678; 8byte 크기의 숫자를 4byte 크기의 변수에 값을 저장할 수 없어서 에러
		boolean k = true;
		
		//위의 데이터 타입 String을 제외한 나머지는 기본형에 속한다
		//참조형 : 위 8가지 기본형 타입을 제외한 나머지
		
		//산술연산자
		int sum = 10 + 20 + 30;
		double tot = sum / 3; //정수.정수 = 정수, 정수.실수 = 실수, 실수.정수 = 실수, 실수.실수 = 실수
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
		
		//증감연산자 ++ , -- 
		int count = 0;
		count = 1;
		count = count + 1;
		count += 1;
		System.out.println(count);
		
		count = ++count; //전위연산자 연산 후 저장
		count = ++count;
		count = --count;
		System.out.println(count);
		
		count = count++; //후위연산자 저장 후 연산
		count = count++;
		count = count--;
		System.out.println(count);
		
	}
}
