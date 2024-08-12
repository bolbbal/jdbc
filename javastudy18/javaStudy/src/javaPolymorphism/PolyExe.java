package javaPolymorphism;

class Tv {
	int channel;
	boolean power;
	void channelUp() {++channel;}
	void channelDown() {--channel;}
	void power() {power = !power;}
}

class SmartTv extends Tv {
	String text;
}
class AiTv extends Tv {
	String think;
}
public class PolyExe {

	public static void main(String[] args) {
		//다형성(polymorphism)
		//사전적 의미 : 여러가지 형태를 취할 수 있는 능력
		//프로그램적 의미 : 하나의 참조 변수로 여러 타입의 객체를 참조할 수 있다.
		//즉, 상속관계에 있을 경우 조상의 참조 변수로 자손 타입의 객체를 다룰 수 있는 것
		
		Tv t = new Tv();
		SmartTv s = new SmartTv();
		AiTv a = new AiTv();
		
		//다형성
		Tv t1 = new SmartTv();
		t1.channel = 1;
		t1.power = false;
		t1.channelUp();
		t1.channelDown();
		t1.power();
		//t1.text; 부모타입은 자신이 물려준 것만 사용 가능하다.
		Tv t2 = new AiTv();
		
		//차이점
		//t1으로 SmartTv의 모든 멤버 요소를 사용할 수 없다.
		//부모가 물려준 멤버요소만 사용이 가능하다.
		//왜 사용할 수 없는가?
		//Tv의 멤버 개수보다 참조변수의 멤버 요소가 더 많기 때문이다.
		
		//자손 타입의 참조변수로 조상 타입의 객체를 사용할 수 있나?
//		SmartTv stv = new Tv(); //안된다.
		
		//참조변수의 형변환
		//업캐스팅(Upcasting) : 자손 타입의 객체를 조상 타입의 객체로 변환
		//다운캐스팅(DownCasting) : 업캐스팅의 반대
		Tv t3 = s; //업캐스팅 -> 조상 클래스의 멤버 요소만 사용 가능하다.
		SmartTv s3 = (SmartTv)t3; //조상다입을 자손으로 변경할 경우에는 반드시 변환타입을 꼭 적을 것
		
		//instanceof
		//레퍼런스가 가리키는 객체의 타입 식별을 위해 사용
		
		if(t1 instanceof SmartTv) {
			
		}
		if(t2 instanceof AiTv) {
			
		}
		
	}

}
