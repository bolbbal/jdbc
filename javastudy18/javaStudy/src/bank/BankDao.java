package bank;

import java.util.Scanner;

public class BankDao {
	
	Scanner sc = new Scanner(System.in);
	
	
	//계좌 생성
	public void createBank(BankVo[] voArray) {
		BankVo vo = new BankVo();
		System.out.println("계좌를 생성합니다.");
				
		System.out.print("계좌번호 입력 : ");
		String ano = sc.next();
		vo.setAno(ano);
		
		System.out.print("계좌주 입력 : ");
		String owner = sc.next();
		vo.setOwner(owner);
		
		System.out.print("초기 입금액 : ");
		int balance = sc.nextInt();
		vo.setBalance(balance);
		
		for (int i = 0; i < voArray.length; i++) {
			if(voArray[i] == null) {
				voArray[i] = vo;
				System.out.println("ㄴ 아래와 같이 계좌가 생성되었습니다.");
				System.out.print(voArray[i].getAno() + " " + 
								voArray[i].getOwner() + " " + 
								voArray[i].getBalance());
				System.out.println();
				return;
			}
			
		}
		
	}
	
	public void bankList(BankVo[] voArray) { //계좌 목록
		System.out.println("현재까지 생성된 계좌를 조회합니다.");
		System.out.println("계좌번호\t계좌주\t잔액");
		for (int i = 0; i < voArray.length; i++) {
			if(voArray[i] != null) {
				System.out.println(voArray[i].getAno() + "\t" + 
								voArray[i].getOwner() + "\t" + 
								voArray[i].getBalance());
			}
		}
	}
	
	public BankVo findAno(String ano, BankVo[] voArray) {
		BankVo vo = null;
		for(int i = 0; i < voArray.length; i++) {
			if(voArray[i] != null) {
				if (voArray[i].getAno().equals(ano)) {
					vo = voArray[i];
					break;
				}
			}
		}
		return vo;
	}
	
	public void deposit(BankVo[] voArray) { //예금
		System.out.print("계좌번호 입력 : ");
		String ano = sc.next();
		System.out.print("예금액 입력 : ");
		int money = sc.nextInt();
		BankVo vo = findAno(ano, voArray);
		if(vo == null) {
			System.out.println("해당 번호와 일치하는 계좌가 존재하지 않습니다. 계좌번호를 다시 확인해주세요.");
			return;
		}
		vo.setBalance(vo.getBalance()+money);
		
	}
	
	public void withdraw(BankVo[] voArray) { //출금
		System.out.print("계좌번호 입력 : ");
		String ano = sc.next();
		System.out.print("출금액 입력 : ");
		int money = sc.nextInt();
		BankVo vo = findAno(ano, voArray);
		if(vo == null) {
			System.out.println("해당 번호와 일치하는 계좌가 존재하지 않습니다. 계좌번호를 다시 확인해주세요.");
			return;
		}
		vo.setBalance(vo.getBalance()-money);
	}
}
