package javaBasic;

public class Java26_charAt {

	public static void main(String[] args) {
		//charAt : index��ȣ�� �����ϴ� ���� �Ѱ��� ���Ѵ�.
		//index ��ȣ�� 0���� ����, ���ڿ��� ����� �� �ڵ����� index��ȣ�� ������
		String security = "123456-1234567"; //�ֹι�ȣ
		System.out.println(security.charAt(7));//security�� ����� ������ index��ȣ�� �ش��ϴ� ���� �ϳ� ����
		//security�� ����� �� �� 7��° ���� 1���� ���ؼ� �ⷫ��.
		
//		security.equalsIgnoreCase(anotherString);//���ڿ��� ��ҹ��� ���о��� ���� �� ���
		
		char gender = security.charAt(7);
		if (gender == '1') {
			System.out.println("2000�� ������ �¾ �����Դϴ�.");
		} else if (gender == '2') {
			System.out.println("2000�� ������ �¾ �����Դϴ�.");
		} else if (gender == '3') {
			System.out.println("2000�� ���Ŀ� �¾ �����Դϴ�.");
		} else if (gender == '4') {
			System.out.println("2000�� ���Ŀ� �¾ �����Դϴ�.");
		}
		
		switch (gender) {
		case 1:
			System.out.println("2000�� ������ �¾ �����Դϴ�.");
			break;
		case 2:
			System.out.println("2000�� ������ �¾ �����Դϴ�.");
			break;
		case 3:
			System.out.println("2000�� ���Ŀ� �¾ �����Դϴ�.");
			break;
		case 4:
			System.out.println("2000�� ���Ŀ� �¾ �����Դϴ�.");
			break;
		}

	}
}
