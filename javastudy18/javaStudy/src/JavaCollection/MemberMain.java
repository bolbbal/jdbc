package JavaCollection;

import java.util.Scanner;

public class MemberMain {
	
	public static void main(String[] args) {
		//메뉴
		Scanner sc = new Scanner(System.in);
		MemberDao dao = new MemberDao();
		
		boolean check = true;
		
		do {
			System.out.print("작업선택 [1]입력[2]출력[3]삭제[4]수정[5]검색[0]종료 >> ");
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
				System.out.println("작업을 종료합니다.");
				check = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		} while(check);
		
	}

}
