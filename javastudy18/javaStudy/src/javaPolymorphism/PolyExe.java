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
		//������(polymorphism)
		//������ �ǹ� : �������� ���¸� ���� �� �ִ� �ɷ�
		//���α׷��� �ǹ� : �ϳ��� ���� ������ ���� Ÿ���� ��ü�� ������ �� �ִ�.
		//��, ��Ӱ��迡 ���� ��� ������ ���� ������ �ڼ� Ÿ���� ��ü�� �ٷ� �� �ִ� ��
		
		Tv t = new Tv();
		SmartTv s = new SmartTv();
		AiTv a = new AiTv();
		
		//������
		Tv t1 = new SmartTv();
		t1.channel = 1;
		t1.power = false;
		t1.channelUp();
		t1.channelDown();
		t1.power();
		//t1.text; �θ�Ÿ���� �ڽ��� ������ �͸� ��� �����ϴ�.
		Tv t2 = new AiTv();
		
		//������
		//t1���� SmartTv�� ��� ��� ��Ҹ� ����� �� ����.
		//�θ� ������ �����Ҹ� ����� �����ϴ�.
		//�� ����� �� ���°�?
		//Tv�� ��� �������� ���������� ��� ��Ұ� �� ���� �����̴�.
		
		//�ڼ� Ÿ���� ���������� ���� Ÿ���� ��ü�� ����� �� �ֳ�?
//		SmartTv stv = new Tv(); //�ȵȴ�.
		
		//���������� ����ȯ
		//��ĳ����(Upcasting) : �ڼ� Ÿ���� ��ü�� ���� Ÿ���� ��ü�� ��ȯ
		//�ٿ�ĳ����(DownCasting) : ��ĳ������ �ݴ�
		Tv t3 = s; //��ĳ���� -> ���� Ŭ������ ��� ��Ҹ� ��� �����ϴ�.
		SmartTv s3 = (SmartTv)t3; //��������� �ڼ����� ������ ��쿡�� �ݵ�� ��ȯŸ���� �� ���� ��
		
		//instanceof
		//���۷����� ����Ű�� ��ü�� Ÿ�� �ĺ��� ���� ���
		
		if(t1 instanceof SmartTv) {
			
		}
		if(t2 instanceof AiTv) {
			
		}
		
	}

}
