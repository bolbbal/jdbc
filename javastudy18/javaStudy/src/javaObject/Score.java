package javaObject;

public class Score {//����ǥ ���赵
	//�������
	int bno;
	String name;
	int kor, eng, mat;
	int tot;
	double avg;
	String grade;
	int rank;
	
	//�������� �̸��� Ŭ������ �̸��� ����.
	//�����ڴ� ���� Ÿ���� ����. ���� Ÿ���� ���ٰ� �ص� void�� ���� �ʴ´�. 
	//Ŭ������ �����ڰ� �ϳ��� ������� ���� ��� �����Ϸ��� ���� �ڵ����� ���Եȴ�.
	
	//�����ε�(Overloading)
	//�̸��� ���� �޼��� �Ǵ� �����ڸ� ������ ���� �� �ִ�. ��, �Ű������� ������ Ÿ���� ���� ���� �ʾƾ� �Ѵ�.
	public Score() {
		
	}
	
	public Score(int bno, String name, int kor, int eng, int mat) {
		this.bno = bno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public Score(int bno, String name, short kor, int eng, int mat) {
		this.bno = bno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//�޼ҵ�
	public void calculator() {
		tot = kor + eng + mat;
		avg = tot / 3.;
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else {
			grade = "�����";
		}
	}
	
	public void title() {
		System.out.println("\t\t\t\t����ǥ");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t���");
	}
	
	public void getRecord() {
		System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng  + "\t" 
				+ mat + "\t" + tot + "\t" + avg + "\t" + grade + "\t" + rank);
	}
	
	public double getSum(int a, int b) {
		int sum = 0;
		sum = sum + a;
		sum = sum + b;
		return sum;
	}
	
	public int getSum() {
		int a = 10; int b = 20;
		int sum = 0;
		sum = sum + a;
		sum = sum + b;
		return sum;
	}

}
