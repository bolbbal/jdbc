package javaBasic;

public class Java33_doWhile {

	public static void main(String[] args) {
		// do {} 
		// while(���ǽ�)
		// do - while���� ������ 1���� ������ �ȴ�
		int sum = 0;
		int c = 1;
		for (int x = 1; x <= 5; x++) {
			sum += c;
			c = c + 1;
		}
		System.out.println("for - 1~5���� �� : " + sum);
		
		c = 1;
		sum = 0;
		while (c <= 5) {
			sum += c;
			c++;
		}
		System.out.println("while - 1~5���� �� : " + sum);
		
		c = 1;
		sum = 0;
		do {
			sum += c;
			c++;
		} while(c <= 5);
		System.out.println("do - 1~5���� �� : " + sum);
		
	}

}
