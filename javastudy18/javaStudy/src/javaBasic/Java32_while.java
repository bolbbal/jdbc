package javaBasic;

public class Java32_while {

	public static void main(String[] args) {
		// while(���ǽ�) {}
		// ���ǽ��� ���̸� ���� ����
		int sum = 0;
		int c = 1;
		for (int x = 1; x <= 5; x++) {
			sum += c;
			c = c + 1;
		}
		System.out.println("1~5���� �� : " + sum);
		
		c = 1;
		sum = 0;
		while (c <= 5) {
			sum += c;
			c++;
		}
		System.out.println("1~5���� �� : " + sum);
	}

}
