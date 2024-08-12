package javaBasic;

public class Java35_test {

	public static void main(String[] args) {
		int num;
		int sum = 0;
		
		for (num = 1; num <= 100; num++) {
			if (num % 3 == 0) {
				sum += num;
			}
		}
		System.out.println("for문 1 ~ 100 중 3의 배수 합 : " + sum);
		
		num = 1;
		sum = 0;
		
		while (num <= 100) {
			if (num % 3 == 0) {
				sum += num;
			}
			num++;
		}
		System.out.println("while문 1 ~ 100 중 3의 배수 합 : " + sum);
		
		num = 1;
		sum = 0;
		
		do {
			if (num % 3 == 0) {
				sum += num;
			}
			num++;
		} while (num <= 100);
		System.out.println("do문 1 ~ 100 중 3의 배수 합 : " + sum);
		
		int var = 0;
		int ans = 0;
		for (int i = 1; i <= 10; i++) {
			
			var += i;
			
			ans += var;
		}
		System.out.println(ans);
		
		var = 0;
		ans = 0;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				var += j;
			}
		}
		System.out.println(var);
	}

}
