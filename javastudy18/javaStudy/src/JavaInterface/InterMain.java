package JavaInterface;

public class InterMain {

	public static void main(String[] args) {
		//인터페이스(Interface)
		//모든 메서드가 추상 메서드이고, 상수와 추상 메서드만 멤버로 가질 수 있으며 다른 어떠한 요소도 허용하지 않는다.
		//키워드 : Interface
		//public abstract 타입을 모든 메서드가 사용하기 때문에 생략 가능
		//public final static 생략 가능
		//인터페이스의 객체를 생성할 수 없다.
		//다른 인터페이스 상속 가능(인터페이스로 부터만 가능)
		//여러개의 인터페이스로부터 다중 상속 가능
		//인터페이스는 상속과 구현을 동시에 할 수 있다.
		//상속 키워드 : extends
		//구현 키워드 : implements
		
		
		//바로 구현부를 만들어서 쓰면 되는데 왜 인터페이스를 만들고 구현 클래스를 따로 만들까
		//1. 개발 기간 단축 가능
		//인터페이스와 구현클래스를 나누어 작업하면 인터페이스만 먼저 작성해 놓으면 이 틀을 사용해서 프로그램을 만들 수 있다.
		//또한 한 쪽에서 구현 클래스를 작성하면서 동시에 다른 개발을 진행할 수 있다.
		//2. 표준화 가능
		//인터페이스 틀을 만들어놓고 개발하면 여러명의 개발자가 작업할 때 일관된 틀 안에서 내용을 구현하기 때문에 정형화된 작업 가능
		//3. 서로 관계 없는 클래스들에게 관계를 맺어줄 수 있다.
		//4. 독립적인 프로그램 가능
		//클래스의 선언과 구현을 분리시켜 독립적인 프로그램을 만들 수 있다.
		//만약 모든 클래스들을 직접 관계로 한다면 한 클래스를 변경할 때마다 직접 관계로 맺어진 클래스를 모두 수정해야한다.
		//하지만 선언과 구현을 나누면서 간접적인 관계로 변경하면 하나의 클래스를 변경하더라도 다른 클래스에 영향을 미치지 않는다.
		
		Samsung sam = new Samsung();
		sam.printLogo();
		sam.sendCall();
		sam.receiveCall();
		System.out.println(sam.TIMEOUT);
		
		SmartPhone sp = new SmartPhone();
		sp.play();
		sp.stop();
		sp.sendCall();
		sp.receiveCall();
		sp.sendSMS();
		sp.receiveSMS();
	}
}
