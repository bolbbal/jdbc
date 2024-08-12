package JavaAbstract;

import java.util.Scanner;

public class ElementScore extends Score {
	Scanner sc = new Scanner(System.in);
	@Override
	void inputMethod() {
		System.out.println("초등학생 성적");
		System.out.print("과목명 입력 >> ");
		super.subjectName = sc.next();
		System.out.print("중간 시험 점수 입력 >> ");
		super.midTest = sc.nextInt();
		System.out.print("기말 시험 점수 입력 >> ");
		super.finalTest = sc.nextInt();
		System.out.print("수행 평가 점수 입력 >> ");
		super.performScore = sc.nextInt();
	}
	
	@Override
	void outputMethod() {
		System.out.println("\t\t성적표");
		System.out.println("-----------------------------------------------------");
		System.out.println("과목명\t중간시험\t기말시험\t수행평가\t총점");
		System.out.println(super.subjectName + "\t" + super.midTest  + "\t" + 
							super.finalTest  + "\t" + super.performScore + "\t" + 
							super.score  );
	}
	
	@Override
	int scoreCal() {
		super.score = super.midTest + super.finalTest + super.performScore;
		return super.score;
	}
}
