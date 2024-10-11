package service.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.Action;

public class EmailSend implements Action{
	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		
		String host = "smtp.naver.com";
		String user = "cyw9007@naver.com";
		String password = "royalwook123";
		
		Properties props = new Properties(); //Map은 키와 값(Object, Object)
		//Properties는 Object가 아닌 String 형태로만 젖아하는 간단한 컬렉션 클래스
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		StringBuffer temp = new StringBuffer();
		
		Random rmd = new Random();
		
		String to_email = email;
		
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
		
		HttpSession authKey = request.getSession(); //세션 생성
		authKey.setAttribute("authenticationKey", authenticationKey);
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(user, password);
			}
		});
		
		
		
		try {
			MimeMessage msg = new MimeMessage(session);
			// 메일보내기 주제, 수신자의 이메일 주소, 발송지의 이메일 주소, 보낸 날짜와 같은 실제 이메일
			// 메세지의 세부 사항을 나타낸다.
			msg.setFrom(new InternetAddress(user, "hanulso"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
			msg.setSubject("hanulso에서 보내는 인증번호 입니다."); // 메일 제목
			msg.setText("인증번호 : " + temp); //메일 내용
			
			Transport.send(msg); //메세지 전송
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "메일전송 성공");
		map.put("certinum", authenticationKey);
		
		Gson gson = new Gson();
		String msg = gson.toJson(map);
		
//		PrintWriter out = response.getWriter();
//		out.write(msg.toString());
		
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(msg.toString());
	}
}
