package JavaAbstract;

public abstract class Student {
	
	//�������
	protected String id;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	//������
	Student() {}
	Student(String id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//�޼���
	public void tot() {
		tot = kor + eng + mat;
	}
	//�߻�޼���
	public abstract void ave();
}
