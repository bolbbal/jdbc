package javaBasic;

import java.util.Scanner;

public class Java24_random {

	public static void main(String[] args) {
		//���������� ����
		Scanner sc = new Scanner(System.in);
		
		int user, com;
		System.out.print("����[1] ����[2] ��[3] �� �ϳ��� �����ϼ��� >> ");
		user = sc.nextInt();
		com = (int)(Math.random()*3)+1;
		
		System.out.println("��ǻ�Ͱ� �� �� : " + com);
		System.out.print("��� : ");
		
		if (1 > user || user > 3) {
			System.out.println("�߸��� �� �Է�");
		} else if (user - com == -2 || user - com == 1) {
			System.out.println("�¸�");
		} else if (user - com == 2 || user - com == -1) {
			System.out.println("�й�");
		} else if (user - com == 0) {
			System.out.println("���º�");
		}
		
		switch(user - com) {
		case 0:
			System.out.println("���º�");
			break;
		case -2: case 1:
			System.out.println("�¸�");
			break;
		case 2: case -1:
			System.out.println("�й�");
			break;
		default:
			System.out.println("�߸��� �� �Է�");
		}
		
		switch(user) {
		case 1:
			if(com == 1) {
				System.out.println("���º�");
			} else if (com == 2) {
				System.out.println("�й�");
			} else {
				System.out.println("�¸�");
			}
			break;
			
		case 2:
			if(com == 1) {
				System.out.println("�¸�");
			} else if (com == 2) {
				System.out.println("���º�");
			} else {
				System.out.println("�й�");
			}
			break;
			
		case 3:
			if(com == 1) {
				System.out.println("�й�");
			} else if (com == 2) {
				System.out.println("�¸�");
			} else {
				System.out.println("���º�");
			}
			break;
		}
	}

}
