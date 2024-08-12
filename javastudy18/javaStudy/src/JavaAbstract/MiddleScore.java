package JavaAbstract;

import java.util.Scanner;

public class MiddleScore extends Score {
	Scanner sc = new Scanner(System.in);
	String teacher;
	int attendanceScore;
	int volunteerScore;
	@Override
	void inputMethod() {
		System.out.println("중학생 성적");
		System.out.print("과목명 입력 >> ");
		super.subjectName = sc.next();
		System.out.print("담당교사 입력 >> ");
		this.teacher = sc.next();
		System.out.print("중간 시험 점수 입력 >> ");
		super.midTest = sc.nextInt();
		System.out.print("기말 시험 점수 입력 >> ");
		super.finalTest = sc.nextInt();
		System.out.print("수행 평가 점수 입력 >> ");
		super.performScore = sc.nextInt();
		System.out.print("출석 점수 입력 >> ");
		this.attendanceScore = sc.nextInt();
		System.out.print("봉사 점수 입력 >> ");
		this.volunteerScore = sc.nextInt();

	}

	@Override
	void outputMethod() {
		System.out.println("\t\t성적표");
		System.out.println("-----------------------------------------------------");
		System.out.println("과목명\t담당교사\t중간시험\t기말시험\t수행평가\t출석점수\t봉사점수\t총점");
		System.out.println(super.subjectName + "\t" + this.teacher + "\t" + 
							super.midTest  + "\t" + super.finalTest  + "\t" + 
							super.performScore + "\t" + this.attendanceScore + "\t" +
							this.volunteerScore  + "\t" + super.score  );
	}

	@Override
	int scoreCal() {
		super.score = super.midTest + super.finalTest + super.performScore + this.attendanceScore + this.volunteerScore;
		return super.score;
	}

}
