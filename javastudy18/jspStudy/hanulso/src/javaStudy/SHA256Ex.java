package javaStudy;

import util.SecurityPassword;

public class SHA256Ex {
	
	public static void main(String args[]) {
		String password = "1234";
		String newPassword = SecurityPassword.encoding(password);
		System.out.println(newPassword);
		
		System.out.println(newPassword.equals(SecurityPassword.encoding(password)));
	}
}
