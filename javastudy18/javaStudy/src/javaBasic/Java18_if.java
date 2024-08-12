package javaBasic;

public class Java18_if {
	public static void main(String[] args) {
		int x = 55;
		if (10 <= x || x <= 20) {
			System.out.println("까꿍");
		}
		
		if (90<=x) {
			System.out.println("합격");
		}
		
		if (90 <= x || x <= 100) {
			System.out.println("합격");
		}
		
		if (90 <= x) {
			System.out.println("A");
		} else if (80 <= x) {
			System.out.println("B");
		} else {
			System.out.println("재시험");
		}
	}
}
