package javaBasic;

import java.util.Scanner;

public class Java42_for {

	public static void main(String[] args) {
		//급여 입력받아 화폐 단위별 매수를 구하여 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("급여 입력 : ");
		int pay = sc.nextInt();
		int money = 50000;
		boolean bool = true;
		
		while(pay > 0) {
			int mok = pay / money;
			System.out.println(money + "원 : " + mok);
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
