package javaBasic;

import java.util.Scanner;

public class Java15_controller {
	public static void main(String[] args) {
		// Ű����� ���ڿ��� �Է¹޾Ƽ� ���� ���ǿ� �°� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// �Է�����
		// ��ȣ�� 1 : blue
		// ��ȣ�� 2 : yes
		// �ǳʰ��ϴ�
		// ��ȣ�� 1 : blue
		// ��ȣ�� 2 : no
		// ������ �ǳʰ��ϴ�
		// ��ȣ�� 1 : red
		// ��ٸ�����
		// ��ȣ�� 1 : sky
		// �Է� ���� �Դϴ�
		
		//ó�� ����
		//�Է¹��� ���� blue�̸� 
		//�ٽ� Ű����� yes/no�� �Է¹޾Ƽ� yes�̸� �ǳʰ��ϴ� ����ϰ� no�̸� ������ �ǳʰ��ϴ�.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȣ��1 : ");
		String tlight1  = sc.next();
		System.out.println("��ȣ�� 2 : ");
		String tlight2  = sc.next();
		if(tlight1.equals("blue") && tlight2.equals("no")) {
			System.out.println("������ �ǳʰ��ϴ�");
		}
		if (tlight1.equals("blue") && tlight2.equals("yes")) {
			System.out.println("�ǳʰ��ϴ�");
		}
		if (tlight1.equals("red") ) {
			System.out.println("��ٸ�����");
		}
		if (!tlight1.equals("blue") && !tlight1.equals("red"))  {
			System.out.println("�Է¿ä��Դϴ�");
		}	
	}
}
