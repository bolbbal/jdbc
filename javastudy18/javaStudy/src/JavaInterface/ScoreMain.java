package JavaInterface;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		// [1]입력 [2]출력 [3]종료
		// 입력예시
		// 학번 이름 국어 영어 수학점수 입력
		// 출력 예시
		// 학번 이름 국어 영어 수학 총점 평균 학점 등수
		// 
		Scanner sc = new Scanner(System.in);
		ScoreMethod sm = new ScoreMethod();
		boolean check = true;
		while(check) {
			System.out.print("[1]입력|[2]출력|[3]검색|[5]종료 >> ");
			int num = sc.nextInt();
			if(num == 1) {
				sm.scoreInsert();
			} else if(num == 2) {
				sm.scorePrint();
			} else if(num == 3) {
				System.out.print("검색할 학번을 입력하세요.");
				String search = sc.next();
				sm.scoreSearch(search);
			} else if(num == 5) {
				check = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}
	}

}
