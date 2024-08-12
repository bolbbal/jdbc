package javaBasic;

public class Java44_array {

	public static void main(String[] args) {
		// 배열 (array)
		// 같은 형의 데이터를 저장하는 여러개의 기억 장소
		
		//배열 선언
		int[] a = new int[5];
		//값 저장
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		a[4] = 50;
		
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		System.out.println(a[3]);
//		System.out.println(a[4]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(a[i]);
		}
		
		double[] b = new double[5];
		b[0] = 1.0;
		b[1] = 1.1;
		b[2] = 1.2;
		b[3] = 1.3;
		b[4] = 1.4;
		//b[5] = 100.5; //ArrayIndexOutOfBoundsException 예외
		
//		System.out.println(b[0]);
//		System.out.println(b[1]);
//		System.out.println(b[2]);
//		System.out.println(b[3]);
//		System.out.println(b[4]);
		//System.out.println(b[5]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(b[i]);
		}
		//int[5] c; 불가능
		
		//인덱스 번호는 음수를 사용할 수 없다.
		int[] array = new int[10];
		//array[-2] = 20; // /NegativeArraySizeException
		
		//배열 생성과 초기화
		int[] array1 = {10, 20, 30, 40, 50};
//		System.out.println(array1[0]);
//		System.out.println(array1[1]);
//		System.out.println(array1[2]);
//		System.out.println(array1[3]);
//		System.out.println(array1[4]);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(array1[i]);
		}
		
	}

}
