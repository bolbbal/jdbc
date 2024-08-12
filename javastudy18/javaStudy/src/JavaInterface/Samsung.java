package JavaInterface;

public class Samsung implements PhoneInterface {

	@Override
	public void sendCall() {
		System.out.println("띠리링~");

	}

	@Override
	public void receiveCall() {
		System.out.println("전화 받어~~~");
	}

}
