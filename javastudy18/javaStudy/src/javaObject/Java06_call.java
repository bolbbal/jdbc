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
		//재귀 호출
		//메서드 내에서 자기 자신을 반복적으로 호출한다
		//팩토리얼, 제곱, 트리, 폴더목록 등에 사용한다
		//4! = 4*3*2*1
		
		long result = factorial(4);
		System.out.println(result);

	}

}
