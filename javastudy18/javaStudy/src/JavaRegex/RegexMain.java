package JavaRegex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {

	public static void main(String[] args) {
		// 정규식
		// 텍스트 이용 시 데이터 중에서 원하는 조건(패턴)과 일치하는 문자열을 찾아내기 위해 사용하는 것
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.print("전화번호 입력 >> ");
			String tel = sc.next();
			Pattern p = Pattern.compile("\\d{3}-?\\d{4}-?\\d{4}");
			Matcher matcher = p.matcher(tel);
			if(!matcher.find()) {
				System.out.println("전화번호를 다시 입력해주세요.");
			} else {
				System.out.println("패턴에 맞아요!");
				check = false;
			}
		} while(check);
		
		
	}

}
