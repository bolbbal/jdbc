package JavaAbstract;

class StudentAve extends Student {
	
	@Override
	public void ave() { //������{}�� ������ �Ѵ�
		super.ave = super.tot / 3.;
	}
}
public class StudentMain {

	public static void main(String[] args) {
		//�߻� Ŭ����
		//�̿ϼ� ���赵��� �ϸ�, �̿ϼ� �޼��带 �����ִ� Ŭ������ ���Ѵ�.
		//��ü����(Instance)�� �� �� ����.
		//����� ���� �߻� �޼��带 �ϼ��ؾ� ��ü ������ �����ϴ�.
		//�߻� Ŭ������ �߻� �޼��带 �����ϰ� �ִٴ� ���� �����ϰ�� �Ϲ� Ŭ������ ����.
		//�߻� Ŭ�������� �����ڰ� ������, ��� ������ �޼��嵵 ���� �� �ִ�.
		//Ű���� : Abstract
		
		//�߻� �޼����
		//�̿ϼ� �޼���. ������(����{})�� ���� �޼���
		//abstract ����Ÿ�� �޼����̸�(); - > ����θ� �ְ� �����ΰ� ���� �޼���
		//�� �ʿ������� �ڼո��� �ٸ��� ������ ������ ����Ǵ� ��쿡 ���
		
//		Student stu = new Student(); // ����
		
		StudentAve sta = new StudentAve();
		sta.id = "2024";
		sta.name = "jsl";
		sta.kor = 100;
		sta.eng = 100;
		sta.mat = 100;
		sta.tot();
		sta.ave();
		
	}

}
