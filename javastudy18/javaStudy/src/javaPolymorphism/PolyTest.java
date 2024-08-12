package javaPolymorphism;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price/10.0);
	}
}

class Com extends Product {
	Com() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Com";
	}
}

class Desk extends Product {
	Desk() {
		super(500);
	}
	@Override
	public String toString() {
		return "Desk";
	}
}

class Moniter extends Product {
	Moniter() {
		super(300);
	}
	@Override
	public String toString() {
		return "Moniter";
	}
}

class Hp extends Product {
	Hp() {
		super(400);
	}
	@Override
	public String toString() {
		return "HandPhone";
	}
}

class Buyer {
	int money = 100000;
	int bonusPoint = 0;
	
	void buy(Product p) { //매개변수의 다형성. 부모타입의 참조 변수로 자손 타입의 객체를 다룰 수 있다.

		if(money < p.price) {
			System.out.println("잔액 부족");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p.toString() + "을 구매하셨습니다.");
	}
}

public class PolyTest {

	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		//Com com = new Com();
		
		b.buy(new Com());
		b.buy(new Desk());
		b.buy(new Moniter());
		b.buy(new Hp());
		System.out.println("현재 잔액은 " + b.money + " 입니다.");
		System.out.println("현재 포인트는 " + b.bonusPoint + " 입니다.");
	}

}
