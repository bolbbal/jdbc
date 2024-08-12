package JavaAbstract;

public abstract class Score {
	//초 - 과, 점, 중 기 수
	//중 - 과, 점, 중 기 수 출 봉
	//고 - 과, 점, 교사, 중 기 수 출 봉
	protected String subjectName;
	protected int score;
	protected int midTest;
	protected int finalTest;
	protected int performScore;
	
	abstract void inputMethod();
	abstract void outputMethod();
	abstract int scoreCal();
}
