package javaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args) {
		// 에러 : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류(메모리 부족, 스택 오버 플로우)
		// 종류
			// 컴파일 에러 : 컴파일 시 발생하는 에러
			// 런타임 에러 : 실행 시에 발생하는 에러
			// 논리적 에러 : 실행은 되지만 의도와 다르게 동작하는 것

		// 예외 : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
		// 자바의 예외처리
		// 예외처리 : 프로그램 실행시 발생할 수 있는 예외의 발생에 대비해 코드를 작성하는 것
		// 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행 상태를 유지하는 것
		// 예외의 부모 : Exception
		// 자주 발생하는 예외
			// ArithmeticException : 정수를 0으로 나눌 때 발생
			// NullPointerException : null 레퍼런스를 참조할 때 발생
			// ClassCastException : 변환할 수 없는 타입으로 객체를 변환할 때 발생
			// OutOfMemoryError : 메모리가 부족한 경우 발생
			// ArrayIndexOutOfBoundsException : 배열의 범위를 벗어난 접근 시 발생
			// IllegalArgumentException : 잘못된 인자 전달 시 발생
			// IOException : 입출력 동작 실패 또는 인터럽트 시 발생
			// NumberFormatException : 문자열이 나타나는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
			// InputMismatchException : 정수로 입력 받고자 하는데 문자 등이 입력 된 경우 발생
		//예외 처리 방법 : try-catch-finally, throws

		Scanner sc = new Scanner(System.in);

		int d1 = 0;
		int d2 = 0;
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		while (d1 != 10) {
			System.out.print("숫자 1 입력 : ");
			try {
				d1 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("문자 입력 불가. 정수만 입력하세요.");
				sc.next(); //잘못 입력된 문자를 버림
				continue;
			}
			System.out.print("숫자 2 입력  : ");
			d2 = sc.nextInt();

			// 예외 처리 : try-catch-finally문
			try { // 예외가 발생할 수 있는 실행문
				System.out.println(d1 / d2);
				int sum = 0;
				for (int i = 0; i <= array.length; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();
			} catch (ArithmeticException e) { // 예외 처리문
				System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 인덱스 범위를 벗어났습니다.");
			} finally { // 예외가 발생이 되든, 안되든 무조건 실행. finally는 생략 가능
			}
		}

	}

}
