package javaObject;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		//���� ó�� �޴� �����
		Score18[] array = new Score18[3];
		Scanner sc = new Scanner(System.in);
		ScoreMethod sm = new ScoreMethod();
		
		boolean flag = true;
		while(flag) {
			System.out.println("�۾� ����");
			System.out.print("[1]�Է�[2]���[3]�˻�[4]����[5]���� >> ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1: //�Է�
				sm.insertMethod(array);
				break;
			case 2: //���
				sm.printAll(array);
				break;
			case 3: //�˻�
				sm.searchMethod(array);
				break;
			case 4: //����
				sm.deleteMethod(array);
				break;
			case 5: //����
				flag = false;				
				break;
			default :
				System.out.println("�������� �ʴ� �۾��Դϴ�. �ٽ� �������ּ���.");
			}
		}
		System.out.println("�̿��� �ּż� �����մϴ�.");
	}

}
