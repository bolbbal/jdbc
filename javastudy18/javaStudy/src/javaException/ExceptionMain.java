package javaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {

	public static void main(String[] args) {
		// ���� : ���α׷� �ڵ忡 ���ؼ� ������ �� ���� �ɰ��� ����(�޸� ����, ���� ���� �÷ο�)
		// ����
			// ������ ���� : ������ �� �߻��ϴ� ����
			// ��Ÿ�� ���� : ���� �ÿ� �߻��ϴ� ����
			// ���� ���� : ������ ������ �ǵ��� �ٸ��� �����ϴ� ��

		// ���� : ���α׷� �ڵ忡 ���ؼ� ������ �� �ִ� �ټ� �̾��� ����
		// �ڹ��� ����ó��
		// ����ó�� : ���α׷� ����� �߻��� �� �ִ� ������ �߻��� ����� �ڵ带 �ۼ��ϴ� ��
		// ���� : ���α׷��� ������ ���Ḧ ����, �������� ���� ���¸� �����ϴ� ��
		// ������ �θ� : Exception
		// ���� �߻��ϴ� ����
			// ArithmeticException : ������ 0���� ���� �� �߻�
			// NullPointerException : null ���۷����� ������ �� �߻�
			// ClassCastException : ��ȯ�� �� ���� Ÿ������ ��ü�� ��ȯ�� �� �߻�
			// OutOfMemoryError : �޸𸮰� ������ ��� �߻�
			// ArrayIndexOutOfBoundsException : �迭�� ������ ��� ���� �� �߻�
			// IllegalArgumentException : �߸��� ���� ���� �� �߻�
			// IOException : ����� ���� ���� �Ǵ� ���ͷ�Ʈ �� �߻�
			// NumberFormatException : ���ڿ��� ��Ÿ���� ���ڿ� ��ġ���� �ʴ� Ÿ���� ���ڷ� ��ȯ �� �߻�
			// InputMismatchException : ������ �Է� �ް��� �ϴµ� ���� ���� �Է� �� ��� �߻�
		//���� ó�� ��� : try-catch-finally, throws

		Scanner sc = new Scanner(System.in);

		int d1 = 0;
		int d2 = 0;
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		while (d1 != 10) {
			System.out.print("���� 1 �Է� : ");
			try {
				d1 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("���� �Է� �Ұ�. ������ �Է��ϼ���.");
				sc.next(); //�߸� �Էµ� ���ڸ� ����
				continue;
			}
			System.out.print("���� 2 �Է�  : ");
			d2 = sc.nextInt();

			// ���� ó�� : try-catch-finally��
			try { // ���ܰ� �߻��� �� �ִ� ���๮
				System.out.println(d1 / d2);
				int sum = 0;
				for (int i = 0; i <= array.length; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();
			} catch (ArithmeticException e) { // ���� ó����
				System.out.println("0���� ���� �� �����ϴ�. �ٽ� �Է��ϼ���.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭�� �ε��� ������ ������ϴ�.");
			} finally { // ���ܰ� �߻��� �ǵ�, �ȵǵ� ������ ����. finally�� ���� ����
			}
		}

	}

}
