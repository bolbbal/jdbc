package JavaCollection;

import java.util.Scanner;

public class ScoreMapMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ScoreMapDao dao = new ScoreMapDao();
		boolean check = true;
		do {
			System.out.println("[1]�Է�[2]���[3]����[4]����[5]�˻�[0]����");
			System.out.print("�۾� ���� >> ");
			int num = sc.nextInt();
			if (num == 1) {
				dao.scoreInsert();
			} else if (num == 2) {
				dao.scorePrint();
			} else if (num == 3) {
				dao.scoreUpdate();
			} else if (num == 4) {
				dao.scoreDelete();
			} else if (num == 5) {
				dao.scoreSelect();
			} else if (num == 0) {
				System.out.println("���α׷� ����");
				check = false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
		} while(check);
	}

}
