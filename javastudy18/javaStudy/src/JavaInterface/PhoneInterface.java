package JavaInterface;

public interface PhoneInterface {
	public final int TIMEOUT = 10000; // 상수
	public abstract void sendCall(); //전화걸기
	public abstract void receiveCall(); //전화받기
	
	default void printLogo() { //JDK 1.8 이상 버전부터 구현부가 있는 메소드를 default를 통해 만들 수 있다.
		System.out.println("--phone--");
	}
}
