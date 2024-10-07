package javaStudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOStream {

	public static void main(String[] args) throws Exception {
		// IO Stream java 교재 614
		// 자바에서 데이터는 스트림을 통해서 입출력된다.
		// 스트림은 단방향으로 연속적으로 흘러가는 것을 말한다.
		// 데이터는 출발지에서 도착지로 흘러간다.
		// 프로그램이 출발지냐 도착지냐에 따라 스트림의 종류가 달라진다.
		// 프로그램이 도착지라면 데이터를 입력받아야 하므로 입력 스트림을 사용한다.
		// 프로그램이 출발지라면 데이터를 출력해야 하므로 출력 스트림을 사용한다.
		
		// IO Stream 종류
		// 바이트 기반 스트림 : 그림, 멀티미디어 등의 데이터를 읽고 출력할때 사용
		// 문자 기반 스트림 : 문자 데이터를 읽고 쓸때 사용
		
		//				바이트 기반 스트림						문자 기반 스트림
		//최상위 클래스		InputStream    OutputStream		Reader	  Writer
		//하위 클래스		xxxInputStream xxxOutputStream	xxxReader xxxWriter
		
		//OutputStream 주요 메서드
		//Writer(int b) : 1byte씩 출력, flush() : 출력 버퍼에 잔류하는 모든 바이트 출력, close() : 출력 스트림 종료
		//InputStream 주요 메서드
		//read(int b) : 1byte씩 읽고 바이트 리턴,  close() : 입력 스트림 종료
		
		OutputStream out = new FileOutputStream("C:/Temp/stream.txt");
		byte[] array = {'a','b','c','d'};
		out.write(array);
		out.flush();
		out.close();
		
		InputStream in = new FileInputStream("C:/Temp/stream.txt");
		byte[] buffer = new byte[1234];
		while(true) {
			int readByte = in.read(buffer);
			if(readByte == -1) {
				System.out.println("값이 없음");
				break;
			}
			for(int i = 0; i < readByte; i++) {
				System.out.println((char)buffer[i]);
			}
		}
		in.close();
	}
}
