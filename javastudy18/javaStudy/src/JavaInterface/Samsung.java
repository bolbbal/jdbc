package JavaInterface;

public class Samsung implements PhoneInterface {

	@Override
	public void sendCall() {
		System.out.println("�츮��~");

	}

	@Override
	public void receiveCall() {
		System.out.println("��ȭ �޾�~~~");
	}

}
