package javaBasic;

import java.util.Scanner;

public class Java25_switch {
	public static void main(String[] args) {
		//Ű����� �ڵ�����ȣ(4�ڸ�), �����ð�(��)�� �Է¹޾Ƽ�
		//��������� ����Ͽ� ����Ͻÿ�
		//[�Է�]
		//�ڵ�����ȣ(4�ڸ�), �����ð�(��) �Է� : 3810 42
		//[���]
		//�ڵ�����ȣ : 3810
		//������� : 1500��
		//ó������
		//������� 10�� �̸��� ����, 30�� ������ 500��, 30�� ���ĺ��ʹ� 10�д� 500���� ���
		//���� �����ð��� 42���� ��� ��������� 1500���� �ȴ�
		//�Ϸ� ���� ����� �ִ� 30,000������ ����ϸ�, 30,000���� �ʰ��ϴ��� 30,000���� ¡���Ѵ�.
		
		Scanner sc = new Scanner(System.in); // crtl + shift + o ������ import�ȵȰ� ��
		
		String carNo; //������ȣ
		int time; //�����ð�
		int parkingFee = 0; //���� ���
		
		System.out.println("[�Է�]");
		System.out.print("�ڵ�����ȣ(4�ڸ�), �����ð�(��) �Է� : ");
		carNo = sc.next();
		time = sc.nextInt();
		
		if(time < 10) {
			parkingFee = 0;
		} else if (10 <= time && time < 30) {
			parkingFee = 500;
		} else {
			parkingFee = (500 * ((time-10)/10));
		}
		
//		switch(time/10) {
//		case 0:
//			parkingFee = 0;
//			break;
//		case 1: case 2: 
//			parkingFee = 500;
//			break;
//		case 3: case 4:
//			if(time%10 > 0) {
//				parkingFee = (500 * ((time/10)-1));
//			}
//			
//			
//			break;
//		
//		}
		
		if(parkingFee > 30000) {
			parkingFee = 30000;
		}
		
		System.out.println("�ڵ�����ȣ : " + carNo);
		System.out.println("������� : " + parkingFee + "��");
	} 
}
