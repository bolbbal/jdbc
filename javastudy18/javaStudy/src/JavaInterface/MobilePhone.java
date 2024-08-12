package JavaInterface;

public interface MobilePhone extends PhoneInterface {
	public void sendSMS();
	public void receiveSMS();
}

interface Mp3Interface {
	public void play();
	public void stop();
}

class PDA {
	public int calculator(int x, int y) {
		return x+y;
	}
}

class SmartPhone extends PDA implements Mp3Interface, MobilePhone {
	@Override
	public void play() {
		System.out.println("음악 연주");
	}
	@Override
	public void stop() {
		System.out.println("음악 중지");
	}
	
	@Override
	public void sendCall() {
		System.out.println("띠리링~");
	}
	
	@Override
	public void receiveCall() {
		System.out.println("전화 왔어요");
	}
	
	@Override
	public void sendSMS() {
		System.out.println("문자 보냈어요");
	}
	
	
	@Override
	public void receiveSMS() {
		System.out.println("문자 왔어요");
	}
	
	
}