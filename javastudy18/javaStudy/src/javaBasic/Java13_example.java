package javaBasic;

import java.util.Scanner;

public class Java13_example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȣ�� �Է��ϼ���.");
		int bno = sc.nextInt();
		System.out.print("\n�̸��� �Է��ϼ���.");
		String name = sc.next();
		System.out.print("\n���� ������ �Է��ϼ���.");
		int kor = sc.nextInt();
		System.out.print("\n���� ������ �Է��ϼ���.");
		int eng = sc.nextInt();
		System.out.print("\n���� ������ �Է��ϼ���.");
		int mat = sc.nextInt();
		
		int tot = kor + eng + mat;
		double avg = (double) tot / 3;
		avg = Math.round((avg-0.002) * 100) / 100.0;
		System.out.println("\t\t\t����ǥ");
		System.out.println("---------------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t�հݿ���");
		System.out.println("---------------------------------------------------------------");
		System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + (avg>=70?"�հ�":"�����"));
	}
}