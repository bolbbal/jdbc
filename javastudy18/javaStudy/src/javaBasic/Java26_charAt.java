package javaBasic;

public class Java26_charAt {

	public static void main(String[] args) {
		//charAt : index번호가 지정하는 문자 한개를 구한다.
		//index 번호는 0부터 시작, 문자열은 저장될 때 자동으로 index번호가 정해짐
		String security = "123456-1234567"; //주민번호
		System.out.println(security.charAt(7));//security에 저장된 값에서 index번호에 해당하는 문자 하나 발췌
		//security에 저장된 값 중 7번째 문자 1개를 구해서 출략함.
		
//		security.equalsIgnoreCase(anotherString);//문자열을 대소문자 구분없이 비교할 때 사용
		
		char gender = security.charAt(7);
		if (gender == '1') {
			System.out.println("2000년 이전에 태어난 남성입니다.");
		} else if (gender == '2') {
			System.out.println("2000년 이전에 태어난 여성입니다.");
		} else if (gender == '3') {
			System.out.println("2000년 이후에 태어난 남성입니다.");
		} else if (gender == '4') {
			System.out.println("2000년 이후에 태어난 여성입니다.");
		}
		
		switch (gender) {
		case 1:
			System.out.println("2000년 이전에 태어난 남성입니다.");
			break;
		case 2:
			System.out.println("2000년 이전에 태어난 여성입니다.");
			break;
		case 3:
			System.out.println("2000년 이후에 태어난 남성입니다.");
			break;
		case 4:
			System.out.println("2000년 이후에 태어난 여성입니다.");
			break;
		}

	}
}
