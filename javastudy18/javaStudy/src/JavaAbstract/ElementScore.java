package JavaAbstract;

import java.util.Scanner;

public class ElementScore extends Score {
	Scanner sc = new Scanner(System.in);
	@Override
	void inputMethod() {
		System.out.println("�ʵ��л� ����");
		System.out.print("����� �Է� >> ");
		super.subjectName = sc.next();
		System.out.print("�߰� ���� ���� �Է� >> ");
		super.midTest = sc.nextInt();
		System.out.print("�⸻ ���� ���� �Է� >> ");
		super.finalTest = sc.nextInt();
		System.out.print("���� �� ���� �Է� >> ");
		super.performScore = sc.nextInt();
	}
	
	@Override
	void outputMethod() {
		System.out.println("\t\t����ǥ");
		System.out.println("-----------------------------------------------------");
		System.out.println("�����\t�߰�����\t�⸻����\t������\t����");
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
