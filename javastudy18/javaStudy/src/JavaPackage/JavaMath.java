package JavaPackage;

public class JavaMath {

	public static void main(String[] args) {
		// 산술 연산 메서드 제공 : java.lang.Math
		// 모든 메서드는 static 타입
		double a = 3.141592;
		System.out.println(Math.PI); //원주율 상수 출력
		System.out.println(Math.ceil(a)); // 올림 ★
		System.out.println(Math.floor(a)); // 내림
		System.out.println(Math.sqrt(a)); //제곱근
		System.out.println(Math.exp(2)); //e의 2승
		System.out.println(Math.round(a)); //반올림 ★
	}

}
