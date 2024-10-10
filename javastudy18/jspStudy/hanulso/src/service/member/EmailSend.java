package service.member;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;

public class EmailSend implements Action{
	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		
		String host = "smtp.naver.com";
		String user = "cyw9007@naver.com";
		String password = "royalwook123";
		
		String toEmail = email;
		
		Properties props = new Properties(); //Map은 키와 값(Object, Object)
		//Properties는 Object가 아닌 String 형태로만 젖아하는 간단한 컬렉션 클래스
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		StringBuffer temp = new StringBuffer();
		
		Random rmd = new Random();
		
		for(int i = 0; i < 6; i++) {
			temp.append(rmd.nextInt(10));
		}
		
//		for(int i = 0; i < 10; i++) {
//			
//			int rindex = rmd.nextInt(3);
//			
//			switch(rindex) {
//			
//			case 0:
//				//소문자 a-z
//				temp.append((char)((int)(rmd.nextInt(26))+97));
//				break;
//			case 1:
//				//대문자 A-Z
//				temp.append((char)((int)(rmd.nextInt(26))+65));
//				break;
//			case 2:
//				//숫자 0-9
//				temp.append(rmd.nextInt(10));
//				break;
//			}
//		}
		
		String authenticationKey = temp.toString();
		System.out.println(authenticationKey);
		
	}
}
