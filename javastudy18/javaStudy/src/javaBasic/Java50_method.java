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
		// method ��
		// � Ư�� �۾��� �����ϱ� ���� ��ɹ��� ����
		// �ٸ� ������ �Լ��� �θ���
		
		// main() �޼���� �ڹ� ���� ���α׷��� ���� �޼���
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
