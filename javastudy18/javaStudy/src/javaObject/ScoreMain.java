package javaObject;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		//성적 처리 메뉴 만들기
		Score18[] array = new Score18[3];
		Scanner sc = new Scanner(System.in);
		ScoreMethod sm = new ScoreMethod();
		
		boolean flag = true;
		while(flag) {
			System.out.println("작업 선택");
			System.out.print("[1]입력[2]출력[3]검색[4]삭제[5]종료 >> ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1: //입력
				sm.insertMethod(array);
				break;
			case 2: //출력
				sm.printAll(array);
				break;
			case 3: //검색
				sm.searchMethod(array);
				break;
			case 4: //삭제
				sm.deleteMethod(array);
				break;
			case 5: //종료
				flag = false;				
				break;
			default :
				System.out.println("존재하지 않는 작업입니다. 다시 선택해주세요.");
			}
		}
		System.out.println("이용해 주셔서 감사합니다.");
	}

}
