package javaBasic;

import java.util.Scanner;

public class Java40_menu {

	public static void main(String[] args) {
		//프로젝트 메뉴 만들기
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.println("[1]데이터 입력");
			System.out.println("[2]데이터 조회");
			System.out.println("[3]데이터 수정");
			System.out.println("[4]데이터 삭제");
			System.out.println("[0]프로젝트 종료");
			System.out.print("작업을 선택하세요 >> ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("입력하세요");
				break;
			case 2:
				System.out.println("조회하세요");
				break;
			case 3:
				System.out.println("수정하세요");
				break;
			case 4:
				System.out.println("삭제하세요");
				break;
			case 0:
				System.out.println("프로젝트를 종료합니다.");
				flag = false;
				break;
			default:
				continue;
			}
		}
			

	}

}
