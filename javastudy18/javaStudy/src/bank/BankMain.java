package bank;

import java.util.Scanner;

public class BankMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BankVo[] voArray = new BankVo[100];
		BankDao dao = new BankDao();
		
//		BankVo acc = new BankVo();
//		acc.ano = "1111";
//		acc.owner = "park";
//		acc.balance = 100000;
		
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금하기|4.출금하기|5.종료");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.print("select >> ");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				dao.createBank(voArray);
			} else if(choice == 2) {
				dao.bankList(voArray);
			} else if(choice == 3) {
				dao.deposit(voArray);
			} else if(choice == 4) {
				dao.withdraw(voArray);
			} else if(choice == 5) {
				System.out.println("계좌 관리 종료");
				run = false;
			} else {
				System.out.println("메뉴 선택을 다시 하세요.");
			}
		}
	}

}
