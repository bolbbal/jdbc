package javaBasic;

public class Java10_compareOperator {

	public static void main(String[] args) {

		//�� ������
		//��Һ� ������ < > <= >=
		//��� ������ == !=
		
		int a = 20;
		int b = 10;
		System.out.println("a > b = " + (a>b));
		System.out.println("a < b = " + (a<b));
		System.out.println("a >= b = " + (a>=b));
		System.out.println("a <= b = " + (a<=b));
		System.out.println("a == b = " + (a==b));
		System.out.println("a != b = " + (a!=b));
 
		String str1 = "abcd";
		String str2 = "abcd";
		System.out.println("str1 == str2 = " + (str1==str2));
		
		//�������� ���� new Ű����� ��ü�� �����ؼ� ����Ѵ�.
		String str3 = new String("abce");
		String str4 = new String("abce");
		System.out.println("str3 == str4 = " + (str3==str4));
		//�� �ڵ�� �ּҰ� ���İ� ���� ���̴�
		
		System.out.println("str3 == str4" + (str3.equals(str4)));
		//new Ű���帣 ���ؼ� ������ ���ڿ��� ���Ҷ��� .equals() �޼��带 ����Ѵ�
		
		String str5 = "abcd";
		String str6 = "ABCD";
		System.out.println("str5 == str6 = " + (str5==str6));
		System.out.println("str5.equals(str6) = " + (str5.equals(str6)));
		System.out.println("str5.equalsIgnor(str6) = " + (str5.equalsIgnoreCase(str6)));
	}

}
