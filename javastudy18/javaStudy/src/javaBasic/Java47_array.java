package javaBasic;

public class Java47_array {

	public static void main(String[] args) {
		//lotto
		int[] ball = new int[45];
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i+1;
		}
		int a;
		int[] b = new int[6];
		for(int i = 0; i < 6; i++) {
			a = (int) (Math.random()*45);
			b[i] = a;
			for(int j = 0; j <= i; j++) {
				if (b[i] == b[j]) {
					a = (int) (Math.random()*45);
				} 
			}
			
			System.out.println(ball[a]);
		}
		
		System.out.println();
		int[] lotto = new int[6];
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random()*45 + 1);
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		for(int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

	}

}
