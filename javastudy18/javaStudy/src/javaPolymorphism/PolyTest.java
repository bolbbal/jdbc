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
	
	void buy(Product p) { //�Ű������� ������. �θ�Ÿ���� ���� ������ �ڼ� Ÿ���� ��ü�� �ٷ� �� �ִ�.

		if(money < p.price) {
			System.out.println("�ܾ� ����");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p.toString() + "�� �����ϼ̽��ϴ�.");
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
		System.out.println("���� �ܾ��� " + b.money + " �Դϴ�.");
		System.out.println("���� ����Ʈ�� " + b.bonusPoint + " �Դϴ�.");
	}

}
