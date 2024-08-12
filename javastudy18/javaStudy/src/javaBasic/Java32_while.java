package javaBasic;

public class Java32_while {

	public static void main(String[] args) {
		// while(조건식) {}
		// 조건식이 참이면 블럭을 실행
		int sum = 0;
		int c = 1;
		for (int x = 1; x <= 5; x++) {
			sum += c;
			c = c + 1;
		}
		System.out.println("1~5까지 합 : " + sum);
		
		c = 1;
		sum = 0;
		while (c <= 5) {
			sum += c;
			c++;
		}
		System.out.println("1~5까지 합 : " + sum);
	}

}
