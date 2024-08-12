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
		System.out.println("���� ����");
	}
	@Override
	public void stop() {
		System.out.println("���� ����");
	}
	
	@Override
	public void sendCall() {
		System.out.println("�츮��~");
	}
	
	@Override
	public void receiveCall() {
		System.out.println("��ȭ �Ծ��");
	}
	
	@Override
	public void sendSMS() {
		System.out.println("���� ���¾��");
	}
	
	
	@Override
	public void receiveSMS() {
		System.out.println("���� �Ծ��");
	}
	
	
}