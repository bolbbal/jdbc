package javaBasic;

public class Java23_random {

	public static void main(String[] args) {
		//임의의 정수 만들기
		//Math.random() : 0.0과 1.0 사이의 임의의 double값을 반환한다
		System.out.println(Math.random()); // 0.0 <= Math.random < 1.0
		System.out.println(Math.random()*3); // 0.0 <= Math.random < 3.0
		System.out.println((int)(Math.random()*3)+1); // (int)1.0 <= (int)Math.randon() < (int)4.0
	}

}
