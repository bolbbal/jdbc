package javaBasic;

public class Java19_switch {

	public static void main(String[] args) {
		//switch-case문
		//조건식의 값에 따라 여러개 중 하나를 선택하여 처리하는 조건문
		
//		char grade = 'A';
//		switch(조건식) { //조건식은 정수, 수식, 문자 등이 올 수 있고 실수형은 사용할 수 없다.
//		case 값1: //case문의 값은 문자, 정수, 문자열만 허용. 실수 리터럴은 허용되지 않는다.
//			실행문장1;
//			break; //break문을 만나면 switch문을 벗어난다. break문이 없으면 다음 case문을 계속 실행한다.
//		case 값2:
//			실행문장2;
//			break;
//		case 값3:
//			실행문장3;
//		default:
//			실행문장 n;
//		}
		
		char grade = 'c';
		switch(grade) {
		case 'A':
			System.out.println("90~100점 입니다.");
			break;
		case 'B':
			System.out.println("80~89점 입니다.");
			break;
		case 'C':
			System.out.println("70~79점 입니다.");
			break;
		default:
			System.out.println("재시험 입니다.");
		}
		
		int b = 10;
		switch(b%2) { //조건식으로 수식이 올 수 있다.
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
