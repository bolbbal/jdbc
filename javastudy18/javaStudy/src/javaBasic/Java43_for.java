package javaBasic;

public class Java43_for {

	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			for(int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			for(int k = 1; k < i; k++) {
				System.out.print(" ");
			}
			for(int j = 6-i; j > 0; j--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			for(int j = 5-i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			for(int j = 5-i; j > 0; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= (i*2)-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 9; k >= (i*2)-1; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
