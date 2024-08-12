package javaBasic;

public class Java09_typeConversion { //형변환
	public static void main(String[] args) {
		//형변환이란 : 변수 또는 상수의 타입ㅇ르 다른 타입으로 변환하는 것
		double d = 85.7;
		//int score = d; 8byte 크기의 값을 4byte 크기 변수에 저장할 수 없다.
		int score = (int) d; //데이터 손실 발생
		System.out.println(score);
		
		double s = score; //자동 형변환
		System.out.println(s);
		
		//Math.round() 로 반올림하기
		//소숫점 1자리에서 반올림한다.
		long result = Math.round(4.52);
		System.out.println(result);
		double pi = 3.141592;
		double shortpi = Math.round(pi * 1000) / 1000.0;
		System.out.println(shortpi);
		
	}
}
