package javaBasic;

import java.util.Scanner;

public class Java16_score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat;
		System.out.print("�й��� �Է��ϼ��� : ");
		int bno = sc.nextInt();  
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.print("���� ���� ���� ������ �Է��ϼ��� : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		int tot = kor + eng + mat;
		double avg = (double) tot / 3;
		avg = Math.round(avg * 100) / 100.0;
		
		String grade;
		if (avg >= 90) {
			grade = "A����";
		} else if (avg >= 80) {
			grade = "B����";
		} else if (avg >= 70) {
			grade = "C����";
		} else {
			grade = "�����";
		}
		
		System.out.println("\t\t����ǥ");
		System.out.println("-----------------------------------------");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("-----------------------------------------");
		System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + grade);
	}
}
