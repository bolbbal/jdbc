package javaBasic;

import java.util.Scanner;

public class Java14_controller {

	public static void main(String[] args) {
		// ���
		// ���α׷��� �������� ��������� �����Ű�� ��
		// ��� ���ǿ� ���� �����Ͽ��� �� ��ɹ��� ���� ������ �����Ű�� ���� ����(Control)�̶� �Ѵ�
		// ����� �̷� ���α׷��� �帧�� �����ϴ� ���̴�
		// ������� ���ǹ��� �ݺ����� �ִ�
		// ���ǹ��� ���ǿ� ���� �ٸ� ������ ����ǵ��� �ϰ�,
		// �ݺ�����  Ư�� ������� �ݺ��ؼ� �����Ѵ�.
		
		// �ܼ� if��
		int num = 10;
		if (num%2 == 0) {
			System.out.println("�Էµ� " + num + "�� ¦���Դϴ�.");
		}
		System.out.println("���α׷� ����");
		
		if (10 <= num && num <= 20) {
			System.out.println("���ǽ��� �� �Դϴ�.");
		}
		System.out.println("���α׷� ����");

		//������ �Է¹޾� ������ 80 �̻��̸� �հ��� ����Ͻÿ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int score = sc.nextInt();
		
		if (score >= 80) {
			System.out.println("�հ�");
		}
		System.out.println("���α׷� ����");
		
		System.out.print("���� �Է� : ");
		int value = sc.nextInt();
		String str = "";
		if (value >= 80) {
			str = "Pass";
		} else {
			str = "No";
		}
		System.out.println(value + " = " + str );
		
		if (value >= 80) {
			if (value <= 90) 
			System.out.println(value + " = Pass");
			else 
			System.out.println(value + " = No");
			}  	
		else {
			System.out.println("No");
		}

	}

}
