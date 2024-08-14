package usedCar;

import java.util.*;

public class UsedCarMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UsedCarDao dao = new UsedCarDao();
		
		boolean flag = true;
		
		while (flag) {
			
			System.out.println("[1]��� ȸ�� �˻�[2]][0]����");
			System.out.print("�۾� ���� >> ");
			String work = sc.next();
			
			if (work.equals("0")) {
				flag = false;
				
				break;
				
			} else if (work.equals("1")) {
				System.out.println("��� ȸ�� �˻� ����" + "\n");
				
				List<UsedCarVo> list = dao.selectMemberAll();
				
				System.out.println("\t\t\t\tȸ�� ���");
				System.out.println("ȸ����ȣ\tȸ���̸�\t����\t����\t��ȭ��ȣ\t�ּ�\t�̸���\tŸ��");
				
				for(UsedCarVo vo : list) {
					System.out.print(vo.getMember_no() + "\t");
					System.out.print(vo.getMember_name() + "\t");
					System.out.print(vo.getMember_gender() + "\t");
					System.out.print(vo.getMember_age() + "\t");
					System.out.print(vo.getMember_call() + "\t");
					System.out.print(vo.getMember_address() + "\t");
					System.out.print(vo.getMember_email() + "\t");
					System.out.print(vo.getMember_type() + "\t");
					System.out.println();
				}
			}
		}
	}

}