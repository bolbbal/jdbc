package javaBasic;

import java.util.Scanner;

public class Java42_for {

	public static void main(String[] args) {
		//�޿� �Է¹޾� ȭ�� ������ �ż��� ���Ͽ� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�޿� �Է� : ");
		int pay = sc.nextInt();
		int money = 50000;
		boolean bool = true;
		
		while(pay > 0) {
			int mok = pay / money;
			System.out.println(money + "�� : " + mok);
			pay = pay % money;
			if (bool) {
				money = money / 5;
				bool = false;
			} else {
				money = money / 2;
				bool = true;
			}
		}
	}

}
