package JavaCollection;

import java.util.Scanner;

public class MemberMain {
	
	public static void main(String[] args) {
		//�޴�
		Scanner sc = new Scanner(System.in);
		MemberDao dao = new MemberDao();
		
		boolean check = true;
		
		do {
			System.out.print("�۾����� [1]�Է�[2]���[3]����[4]����[5]�˻�[0]���� >> ");
			int menu = sc.nextInt();
			if (menu == 1) {
				dao.insert();
			} else if (menu == 2) {
				dao.printMember();
			} else if (menu == 3) {
				dao.memberDelete();	
			} else if (menu == 4) {
				dao.memberModify();
			} else if (menu == 5) {
				dao.memberSelect();
			} else if (menu == 0) {
				System.out.println("�۾��� �����մϴ�.");
				check = false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		} while(check);
		
	}

}
