package JavaPackage;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class JavaObject {

	public static void print(Object obj) { //다형성
		System.out.println(obj.getClass().getName());
		System.out.println(obj.hashCode());
		//hashCode : 객체를 식별하는 하나의 고유 정수값. 객체의 주소를 int 타입으로 반환
		System.out.println(obj.toString());
		System.out.println(obj);
		
	}
	public static void main(String[] args) {
		//패키지(Package)
		//서로 관련된 클래스와 인터페이스의 컴파일 된 클래스 파일들을 하나의 디렉토리에 모아 놓은 것
		//패키즈는 .jar 파일로 압축할 수 있음
		//JDK에서 제공하는 표준 패키지는 rt.jar에 압축되어 있다.
		//주요 패키지
		//java.lang : 수학함수, 입출력 등 자바 프로그래밍에 필요한 기본적인 클래스와 인터페이스
		//java.util : 날짜, 시간, 벡터, 헤시맵 등과 같은 다양한 유틸리티 클래스와 인터페이스
		//java.io : 키보드, 모니터, 프린터, 디스크 등에 입출력할 수 있는 클래스와 인터페이스
		//java.swing : 자바 GUI 프로그래밍을 위한 스윙 패키지
		
		//자바 API 참조 :
		//Object 클래스
		//모든 클래스의 Super Class
		//모든 클래스는 강제 상속을 받는다. 
		
		Point p = new Point(2,3);
		print(p);
		
	}

}
