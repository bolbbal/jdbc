package bank;

import java.util.Scanner;

public class BankDao {
	
	Scanner sc = new Scanner(System.in);
	
	
	//���� ����
	public void createBank(BankVo[] voArray) {
		BankVo vo = new BankVo();
		System.out.println("���¸� �����մϴ�.");
				
		System.out.print("���¹�ȣ �Է� : ");
		String ano = sc.next();
		vo.setAno(ano);
		
		System.out.print("������ �Է� : ");
		String owner = sc.next();
		vo.setOwner(owner);
		
		System.out.print("�ʱ� �Աݾ� : ");
		int balance = sc.nextInt();
		vo.setBalance(balance);
		
		for (int i = 0; i < voArray.length; i++) {
			if(voArray[i] == null) {
				voArray[i] = vo;
				System.out.println("�� �Ʒ��� ���� ���°� �����Ǿ����ϴ�.");
				System.out.print(voArray[i].getAno() + " " + 
								voArray[i].getOwner() + " " + 
								voArray[i].getBalance());
				System.out.println();
				return;
			}
			
		}
		
	}
	
	public void bankList(BankVo[] voArray) { //���� ���
		System.out.println("������� ������ ���¸� ��ȸ�մϴ�.");
		System.out.println("���¹�ȣ\t������\t�ܾ�");
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
	
	public void deposit(BankVo[] voArray) { //����
		System.out.print("���¹�ȣ �Է� : ");
		String ano = sc.next();
		System.out.print("���ݾ� �Է� : ");
		int money = sc.nextInt();
		BankVo vo = findAno(ano, voArray);
		if(vo == null) {
			System.out.println("�ش� ��ȣ�� ��ġ�ϴ� ���°� �������� �ʽ��ϴ�. ���¹�ȣ�� �ٽ� Ȯ�����ּ���.");
			return;
		}
		vo.setBalance(vo.getBalance()+money);
		
	}
	
	public void withdraw(BankVo[] voArray) { //���
		System.out.print("���¹�ȣ �Է� : ");
		String ano = sc.next();
		System.out.print("��ݾ� �Է� : ");
		int money = sc.nextInt();
		BankVo vo = findAno(ano, voArray);
		if(vo == null) {
			System.out.println("�ش� ��ȣ�� ��ġ�ϴ� ���°� �������� �ʽ��ϴ�. ���¹�ȣ�� �ٽ� Ȯ�����ּ���.");
			return;
		}
		vo.setBalance(vo.getBalance()-money);
	}
}
