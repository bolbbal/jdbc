package javaJDBCentry;

import java.util.Scanner;

public class EntryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		EntryDao dao = new EntryDao();
		while(flag) {
			System.out.print("�޴����� : [1]�濬�������[2]�濬�����ȸ[3]���������ȸ[4]����");
			String sel = sc.next();
			if (sel.equals("1")) {
				dao.insertEntry();
			} else if (sel.equals("2")) {
				dao.selectEntry();
			} else if (sel.equals("3")) {
				dao.selectRank();
			} else if (sel.equals("4")) {
				System.out.println("���α׷� ����");
				flag = false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
		}

	}

}
