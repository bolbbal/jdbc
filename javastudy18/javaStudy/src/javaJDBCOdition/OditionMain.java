package javaJDBCOdition;

import java.util.*;
import java.sql.*;

public class OditionMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		OditionDao dao = new OditionDao();
		while(flag) {
			System.out.print("�۾����� : [1]����ǵ��[2]������ ��� ��ȸ[3]���� ���� ��� ��ȸ[4]������ ��� ��ȸ[5]���� ");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("����� ��� ����");
				dao.insertOdition();
			} else if (sel == 2) {
				System.out.println("������ ��� ��ȸ ����");
				dao.selectArtist();
			} else if (sel == 3) {
				System.out.println("���� ���� ��� ��ȸ ����");
				dao.selectMentoPoint();
			} else if (sel == 4) {
				System.out.println("������ ��� ��ȸ ����");
				dao.selectArtistRank();
			} else if (sel == 5) {
				System.out.println("�۾� ����");
				flag = false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
		}
	}

}
