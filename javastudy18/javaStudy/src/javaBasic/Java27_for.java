package javaBasic;

public class Java27_for {

	public static void main(String[] args) {
		//반복문
		//반복문은 어떤 작업이 반복적으로 수행되도록 할 때 사용한다
		//종류는 for , while , do - while
		//반복 획수를 알고 있을 때는 for, 그렇지 않을때는 while
		
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		for (int x = 1; x <= 5; x++) {
			System.out.println("say i love you. thank you");
		}
		
		int a = 10;
		System.out.println(a);
		a += 5;
		System.out.println(a);
		a += 5;
		System.out.println(a);
		a += 5;
		System.out.println(a);
		a += 5;
		System.out.println(a);
		a += 5;
		
		
		a = 10;
		for (int i = 1; i <= 5; i++) {
			System.out.println(a);
			a += 5;
		}
		
		int sum = 0;
		for (int x = 1; x <= 10; x++) {
			sum += x;
			if (x != 10) {
				System.out.print(x + "+");
			} else {
				System.out.println(x + "=" + sum);
			}
		}
	}

}
