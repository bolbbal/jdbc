package javaBasic;

public class Java12_subOperator {
	//소스 파일의 이름과 클래스의 이름은 같아야한다.

	public static void main(String[] args) {
		int x = 100;
		x += 100;
		System.out.printf("x += %d\n", x); //printf 의 f = 출력 형식, %d = 10진수 형식
		x = 100;
		x -= 10;
		System.out.printf("x -= %d\n", x);
		x = 100;
		x *= 10;
		System.out.printf("x *= %d\n", x);
		x = 100;
		x /= 10;
		System.out.printf("x /= %d\n", x);
		x = 100;
		x %= 10;
		System.out.printf("x %%= %d\n", x);
		
		int i, j, k = 0;
		i = j = k = 100;
		
		k += i + j;
		// k = 300
		i += j -= k *= 5;
		// k = 1500, j = -1400, i = -1300
		i += j = k;
		// k = 1500, j = 1500, i = 200
		System.out.println(i + ", " + j + ", " + k);
		
		//큰 값에서 작은 값을 빼는 두 수의 차를 구하시오
		int a = 3, b = 5;
		System.out.println(a>=b?a-b:b-a);
	}

}
