package javaObject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ScoreMethod { //�޼ҵ� ���赵
	int count = 0;
	Scanner sc = new Scanner(System.in);
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	public void insertMethod(Score18[] array) {

		if(array[count] != null && array[count+1] != null && array[count+2] != null) {
			System.out.println("�� ������ �����ϴ�.");
			return;
		} 
		System.out.print("��ȣ �̸� ���� : ");
		String bno = sc.next();
		String name = sc.next();
		int tot = sc.nextInt();	
		
		Score18 s18 = new Score18(bno, name, tot);
				
		for (int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = s18;
				array[i].avg = ((array[i].tot / 3.) * 100 )/ 100;
				array[i].grade = null;
				
				if (array[i].avg >= 90) {
					array[i].grade = "A";
				} else if (array[i].avg >= 80) {
					array[i].grade = "B";
				} else if (array[i].avg >= 70) {
					array[i].grade = "C";
				} else if (array[i].avg >= 60) {
					array[i].grade = "D";
				} else {
					array[i].grade = "F";
				}
				break;
			}
		}
		rank(array);
	}
		
	//��� ���
	public void printAll(Score18[] array) {
		title();
		
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] != null) {
				System.out.println(array[i].bno + "\t" + array[i].name  + "\t" + 
							array[i].tot + "\t" + df.format(array[i].avg) + "\t" +
							array[i].grade + "\t" + array[i].rank
							);
			}
		}
	}
	public void rank(Score18[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				array[i].rank = 1;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
			for (int j = 0; j < array.length; j++) {
				if (array[j] != null) {
					if(array[i].avg < array[j].avg) {
						array[i].rank++;
					}			
				}		
			}
		}
	}
	
	public void title() {
		System.out.println("\t\t18�� ����ǥ");
		System.out.println("��ȣ\t�̸�\t����\t���\t���\t����");
	}
	//�˻� ���
	public void searchMethod(Score18[] array) {
		System.out.print("�˻��� ��ȣ�� �Է��ϼ��� >> ");
		String num = sc.next();
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].bno.equals(num)) {
				title();
				System.out.println(array[i].bno + "\t" + array[i].name  + "\t" + 
							array[i].tot + "\t" + df.format(array[i].avg) + "\t" +
							array[i].grade + "\t" + array[i].rank
							);
				found = true;
				break;
			} 
			
		}
		if(found == false) {
			System.out.println("�ش� ��ȣ�� �л��� �����ϴ�.");
		}
		rank(array);
	}
	//���� ���
	public void deleteMethod(Score18[] array) {
		System.out.print("������ �л��� ��ȣ�� �Է��ϼ��� >> ");
		String num = sc.next();
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].bno.equals(num)) {
				array[i] = null;
				System.out.println("�ش� ��ȣ�� �л��� �����߽��ϴ�.");
				found = true;
				break;
			}
			
		}
		if(found == false) {
			System.out.println("�ش� ��ȣ�� �л��� �����ϴ�.");
		}
		rank(array);
	}
}
