package javaStudy;

import java.io.File;
import java.text.SimpleDateFormat;

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
		System.out.println("파일의 절대경로: " + f.getAbsolutePath());
	    System.out.println("파일이 속해 있는 디렉토리: " + f.getParent());
	    System.out.println("OS에서 사용하는 경로 구분자: " + File.pathSeparator); // ;
	    System.out.println("OS에서 사용하는 이름 구분자: " + File.separator); // \
	    System.out.println("User dir = " + System.getProperty("user.dir"));
	    System.out.println("User home = " + System.getProperty("user.home"));
	    System.out.println("User name = " + System.getProperty("user.name"));
	    System.out.println("Java home = " + System.getProperty("java.home"));
	    System.out.println("sun.boot.class.path: " + System.getProperty("sun.boot.class.path"));

		File f1 = new File("C:/Temp/html");
		
		if(f1.exists() == false) {
			f1.mkdir();
		}
		
		File temp = new File("C:/Program Files");
		
		File[] contents = temp.listFiles();
		
		System.out.println("시간\t\t\t형태\t\t크기\t이름");
		System.out.println("--------------------------------------------");
		
		SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for(File file : contents) {
			
			System.out.println(sdr.format(file.lastModified()));
			
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
			
			System.out.println();
			
		}
		
		File f2 = new File("C:/temp/html/a.txt");
		
		if(f2 != null) {
		
			f2.delete();
			
		}
	}

}
