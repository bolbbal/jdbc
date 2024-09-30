package javaStudy;

import java.io.File;

public class FileStudy {

	public static void main(String[] args) {
		// File class
		// 파일의 경로명을 다루는 클래스
		// java.io.File
		// 파일 관리 기능
		// 파일 이름 변경, 삭제, 디렉토리 생성, 크기 등 파일 관리
		// File 객체는 파일을 읽고 쓰는 기능이 없음.
		
		File f = new File("C:\\Users\\jjhh1\\OneDrive\\Documents\\GitHub\\jdbc\\javastudy18\\javaStudy\\src\\javaBasic\\Java08.java");
		
		String fileName = f.getName();
		
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로를 제외한 파일 이름 : " + f.getName());
		System.out.println("확장자를 제외한 파일 이름 : " + fileName.substring(0,pos));
		
	}

}
