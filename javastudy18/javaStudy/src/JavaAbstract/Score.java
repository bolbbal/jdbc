package JavaAbstract;

public abstract class Score {
	//�� - ��, ��, �� �� ��
	//�� - ��, ��, �� �� �� �� ��
	//�� - ��, ��, ����, �� �� �� �� ��
	protected String subjectName;
	protected int score;
	protected int midTest;
	protected int finalTest;
	protected int performScore;
	
	abstract void inputMethod();
	abstract void outputMethod();
	abstract int scoreCal();
}
