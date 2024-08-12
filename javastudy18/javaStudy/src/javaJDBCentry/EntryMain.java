package javaJDBCentry;

import java.util.Scanner;

public class EntryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		EntryDao dao = new EntryDao();
		while(flag) {
			System.out.print("메뉴선택 : [1]경연점수등록[2]경연결과조회[3]최종등수조회[4]종료");
			String sel = sc.next();
			if (sel.equals("1")) {
				dao.insertEntry();
			} else if (sel.equals("2")) {
				dao.selectEntry();
			} else if (sel.equals("3")) {
				dao.selectRank();
			} else if (sel.equals("4")) {
				System.out.println("프로그램 종료");
				flag = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}

	}

}
