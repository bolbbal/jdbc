package javaBasic;

public class Java19_switch {

	public static void main(String[] args) {
		//switch-case��
		//���ǽ��� ���� ���� ������ �� �ϳ��� �����Ͽ� ó���ϴ� ���ǹ�
		
//		char grade = 'A';
//		switch(���ǽ�) { //���ǽ��� ����, ����, ���� ���� �� �� �ְ� �Ǽ����� ����� �� ����.
//		case ��1: //case���� ���� ����, ����, ���ڿ��� ���. �Ǽ� ���ͷ��� ������ �ʴ´�.
//			���๮��1;
//			break; //break���� ������ switch���� �����. break���� ������ ���� case���� ��� �����Ѵ�.
//		case ��2:
//			���๮��2;
//			break;
//		case ��3:
//			���๮��3;
//		default:
//			���๮�� n;
//		}
		
		char grade = 'c';
		switch(grade) {
		case 'A':
			System.out.println("90~100�� �Դϴ�.");
			break;
		case 'B':
			System.out.println("80~89�� �Դϴ�.");
			break;
		case 'C':
			System.out.println("70~79�� �Դϴ�.");
			break;
		default:
			System.out.println("����� �Դϴ�.");
		}
		
		int b = 10;
		switch(b%2) { //���ǽ����� ������ �� �� �ִ�.
		case 0:
			System.out.println("0");
			break;
		case 1:
			System.out.println("1");
			break;
		}
		
		String s = "yes";
		switch(s) {
		case "yes":
			System.out.println("good");
			break;
		case "no":
			System.out.println("bad");
			break;
		}
		
		
	}

}
