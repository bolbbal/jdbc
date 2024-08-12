package JavaAbstract;

import java.util.Scanner;

public class MiddleScore extends Score {
	Scanner sc = new Scanner(System.in);
	String teacher;
	int attendanceScore;
	int volunteerScore;
	@Override
	void inputMethod() {
		System.out.println("���л� ����");
		System.out.print("����� �Է� >> ");
		super.subjectName = sc.next();
		System.out.print("��米�� �Է� >> ");
		this.teacher = sc.next();
		System.out.print("�߰� ���� ���� �Է� >> ");
		super.midTest = sc.nextInt();
		System.out.print("�⸻ ���� ���� �Է� >> ");
		super.finalTest = sc.nextInt();
		System.out.print("���� �� ���� �Է� >> ");
		super.performScore = sc.nextInt();
		System.out.print("�⼮ ���� �Է� >> ");
		this.attendanceScore = sc.nextInt();
		System.out.print("���� ���� �Է� >> ");
		this.volunteerScore = sc.nextInt();

	}

	@Override
	void outputMethod() {
		System.out.println("\t\t����ǥ");
		System.out.println("-----------------------------------------------------");
		System.out.println("�����\t��米��\t�߰�����\t�⸻����\t������\t�⼮����\t��������\t����");
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
