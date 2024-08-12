package JavaCollection;

import java.util.Scanner;

public class ScoreMapMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ScoreMapDao dao = new ScoreMapDao();
		boolean check = true;
		do {
			System.out.println("[1]입력[2]출력[3]수정[4]삭제[5]검색[0]종료");
			System.out.print("작업 선택 >> ");
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
				System.out.println("프로그램 종료");
				check = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		} while(check);
	}

}
