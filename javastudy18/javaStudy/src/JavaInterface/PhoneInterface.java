package JavaInterface;

public interface PhoneInterface {
	public final int TIMEOUT = 10000; // ���
	public abstract void sendCall(); //��ȭ�ɱ�
	public abstract void receiveCall(); //��ȭ�ޱ�
	
	default void printLogo() { //JDK 1.8 �̻� �������� �����ΰ� �ִ� �޼ҵ带 default�� ���� ���� �� �ִ�.
		System.out.println("--phone--");
	}
}
