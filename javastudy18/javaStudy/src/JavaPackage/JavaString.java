package JavaPackage;

public class JavaString {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		String s3 = new String("ABC");
		String s4 = new String("ABC");
		System.out.println(s1 == s2); //번지가 같다
		System.out.println(s3 == s4); //번지가 다르다
		System.out.println(s1.equals("ABC")); //문자열 비교 => true 반환 ★
		System.out.println(s1.concat("java")); //s1 문자열에 java 문자를 덧붙여라
		int result = s1.compareTo(s2); //문자열이 같으면 0 리턴, 다르면 -1 리턴
		System.out.println(result);
		String a = "       abcd      ";
		String b = "       a b c d";
		System.out.println(a);
		System.out.println(a.trim()); // 앞 뒤의 모든 공백 제거 ★
		System.out.println(b.trim());
		
		String c = "class";
		System.out.println(c.charAt(2)); //★
		//위 c에 저장된 문자 중 s 문자가 몇개가 있는지 출력하시오
		int count = 0;
		for(int i = 0; i < c.length(); i++) {
			if(c.charAt(i) == 's') {
				count++;
			}
		}
		System.out.println(count);
		
		String java = "java is very good";
		String cshap = "c#, c++";
		String re = java.replace("java", "phython");
		System.out.println(re);
		
		String array[] = cshap.split(","); //기호를 중심으로 문자열 분리 ★
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println(java.substring(0,4)); //java 배열의 0번째 문자부터 4번째 문자의 앞까지 출력★ 
		System.out.println(java.substring(5)); //5번 문자부터 끝까지
		String idCheck = "123456-1234567";
		char id = idCheck.charAt(7);
		if(id == '1') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		String ext = "my.jpg";
		String[] picArr = ext.split("\\.");
		if(picArr[1].equalsIgnoreCase("jpg")) { //대,소문자 무시
			System.out.println("그림파일 입니다.");
		} else {
			System.out.println("그림파일만 업로드 가능합니다.");
		}
		
		String subject = "Java programming";
		System.out.println(subject.indexOf("programming")); //매개값으로 주어진 문자열이 시작되는 인덱스 번호를 리턴, 주어진 문자열이 포함되어있지 않으면 -1 리턴
		if(subject.indexOf("programming") != -1) {
			System.out.println("문자열이 있어요");
		} else {
			System.out.println("찾는 문자열이 없어요");
		}
		
		System.out.println(subject.toLowerCase()); //소문자로 변경
		System.out.println(subject.toUpperCase()); //대문자로 변경
		
		String str1 = "java";
		String str2 = "JAVA";
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("같아요");
		}
	}

}
