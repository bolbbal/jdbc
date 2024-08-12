package javaBasic;

public class Java50_method {
	
	public static void hello() {
		System.out.println("hello");
	}
	
	public static String score() {
		System.out.println("score");
		return "java";
	}
	
	public static int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}
	
	

	public static void main(String[] args) {
		// method 란
		// 어떤 특정 작업을 수행하기 위한 명령문의 집합
		// 다른 언어에서는 함수라 부른다
		
		// main() 메서드는 자바 응용 프로그램의 시작 메서드
		System.out.println("main");
		
		hello();
		
		String name = score();
		System.out.println(name);
		
		int a = sum(10, 5);
		System.out.println(a);
		
		int[] array = {10, 20, 30};
		int b = cal(array);
		System.out.println(b);
	}
	
	public static int cal(int array[]) {
		int tot = 0;
		for(int num : array) {
			tot += num;
		}
		return tot;
	}

}
