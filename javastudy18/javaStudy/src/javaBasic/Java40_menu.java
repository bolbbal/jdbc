package javaBasic;

import java.util.Scanner;

public class Java40_menu {

	public static void main(String[] args) {
		//������Ʈ �޴� �����
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.println("[1]������ �Է�");
			System.out.println("[2]������ ��ȸ");
			System.out.println("[3]������ ����");
			System.out.println("[4]������ ����");
			System.out.println("[0]������Ʈ ����");
			System.out.print("�۾��� �����ϼ��� >> ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("�Է��ϼ���");
				break;
			case 2:
				System.out.println("��ȸ�ϼ���");
				break;
			case 3:
				System.out.println("�����ϼ���");
				break;
			case 4:
				System.out.println("�����ϼ���");
				break;
			case 0:
				System.out.println("������Ʈ�� �����մϴ�.");
				flag = false;
				break;
			default:
				continue;
			}
		}
			

	}

}
