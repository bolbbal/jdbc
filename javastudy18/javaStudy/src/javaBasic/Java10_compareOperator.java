package javaBasic;

public class Java10_compareOperator {

	public static void main(String[] args) {

		//비교 연산자
		//대소비교 연산자 < > <= >=
		//등가비교 연산자 == !=
		
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
		
		//참조형은 워래 new 키워드로 객체를 생성해서 사용한다.
		String str3 = new String("abce");
		String str4 = new String("abce");
		System.out.println("str3 == str4 = " + (str3==str4));
		//위 코드는 주소가 같냐고 묻는 것이다
		
		System.out.println("str3 == str4" + (str3.equals(str4)));
		//new 키워드르 통해서 생성된 문자열을 비교할때는 .equals() 메서드를 사용한다
		
		String str5 = "abcd";
		String str6 = "ABCD";
		System.out.println("str5 == str6 = " + (str5==str6));
		System.out.println("str5.equals(str6) = " + (str5.equals(str6)));
		System.out.println("str5.equalsIgnor(str6) = " + (str5.equalsIgnoreCase(str6)));
	}

}
