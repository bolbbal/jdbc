package JavaInterface;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		// [1]�Է� [2]��� [3]����
		// �Է¿���
		// �й� �̸� ���� ���� �������� �Է�
		// ��� ����
		// �й� �̸� ���� ���� ���� ���� ��� ���� ���
		// 
		Scanner sc = new Scanner(System.in);
		ScoreMethod sm = new ScoreMethod();
		boolean check = true;
		while(check) {
			System.out.print("[1]�Է�|[2]���|[3]�˻�|[5]���� >> ");
			int num = sc.nextInt();
			if(num == 1) {
				sm.scoreInsert();
			} else if(num == 2) {
				sm.scorePrint();
			} else if(num == 3) {
				System.out.print("�˻��� �й��� �Է��ϼ���.");
				String search = sc.next();
				sm.scoreSearch(search);
			} else if(num == 5) {
				check = false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
		}
	}

}
