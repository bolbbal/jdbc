package controller;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "agile";
		int x[] = {1,2,3,4,5};
		char y[] = new char[5];
		
		int i = 0;
		
		while (i < str.length()) {
			y[i] = str.charAt(i);
			i++;
		}
		
		for (int p : x) {
			i--;
			System.out.print(y[i]);
			System.out.print(p + " ");
		}
		
		for(int z = 0; z <5; z++) {
			System.out.print(x[z]);
		}
	}

}
