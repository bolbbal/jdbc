package JavaCollection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreDao {
	Scanner sc = new Scanner(System.in);
	ArrayList<ScoreVo> list = new ArrayList<ScoreVo>();
	DecimalFormat df = new DecimalFormat("###.00");
	
	public void scoreInsert() {
		System.out.print("�й� �̸� ���� ���� ���� �Է� >> ");
		String id = sc.next();
		String name = sc.next();
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int mat = sc.nextInt();
		int tot = calTot(kor, eng, mat);
		double avg = calAvg(tot);
		String grade = calGrade(avg);
		
		ScoreVo vo = new ScoreVo();
		
		vo.setId(id);
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		vo.setTot(tot);
		vo.setAvg(avg);
		vo.setGrade(grade);
		int rank = calRank(vo);
		vo.setRank(rank);
		
		list.add(vo);
	}
	
	public void scorePrint() {
		System.out.println("\t\t\t18�� ����ǥ");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t����");
		for (ScoreVo vo : list) {
			int rank = calRank(vo);
			vo.setRank(rank);
			System.out.print(vo.getId() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMat() + "\t");
			System.out.print(vo.getTot() + "\t");
			System.out.print(df.format(vo.getAvg()) + "\t");
			System.out.print(vo.getGrade() + "\t");
			System.out.println(vo.getRank() + "\t");
		}
		
	}
	
	public void scoreUpdate() {
		System.out.print("�����ϰ� ���� �л��� ��ȣ�� �Է��ϼ���. >> ");
		String id = sc.next();
		for (ScoreVo vo : list) {
			if (vo.getId().equals(id)) {
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t����");
				System.out.print(vo.getId() + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getKor() + "\t");
				System.out.print(vo.getEng() + "\t");
				System.out.print(vo.getMat() + "\t");
				System.out.print(vo.getTot() + "\t");
				System.out.print(df.format(vo.getAvg()) + "\t");
				System.out.print(vo.getGrade() + "\t");
				System.out.println(vo.getRank() + "\t");
				System.out.println("---------------------------------------------");
				System.out.println("������ �����͸� �������ּ���.");
				System.out.print("�̸� : ");
				String name = sc.next();
				vo.setName(name);
				System.out.print("���� ���� : ");
				int kor = sc.nextInt();
				vo.setKor(kor);
				System.out.print("���� ���� : ");
				int eng = sc.nextInt();
				vo.setEng(eng);
				System.out.print("���� ���� : ");
				int mat = sc.nextInt();
				vo.setMat(mat);
				int tot = calTot(kor, eng, mat);
				double avg = calAvg(tot);
				String grade = calGrade(avg);
				vo.setTot(tot);
				vo.setAvg(avg);
				vo.setGrade(grade);
				int rank = calRank(vo);
				vo.setRank(rank);
				return;
				}
			}
		System.out.println("�ش��ϴ� �л��� �����ϴ�.");	
	}
	
	public void scoreDelete() {
		System.out.print("�����ϰ� ���� �л��� ��ȣ�� �Է��ϼ���. >>");
		String id = sc.next();
		for (ScoreVo vo : list) {
			if (vo.getId().equals(id)) {
				list.remove(vo);
				System.out.println("�����߽��ϴ�.");
				return;
			}
		}
		System.out.println("�ش��ϴ� �л��� �����ϴ�.");
	}
	
	public void scoreSelect() {
		System.out.print("�˻��ϰ� ���� �л��� ��ȣ�� �Է��ϼ���. >>");
		String id = sc.next();
		for (ScoreVo vo : list) {
			if (vo.getId().equals(id)) {
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t����");
				System.out.print(vo.getId() + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getKor() + "\t");
				System.out.print(vo.getEng() + "\t");
				System.out.print(vo.getMat() + "\t");
				System.out.print(vo.getTot() + "\t");
				System.out.print(df.format(vo.getAvg()) + "\t");
				System.out.print(vo.getGrade() + "\t");
				System.out.println(vo.getRank() + "\t");
				return;
			}
		}
		System.out.println("�ش��ϴ� �л��� �����ϴ�.");
	}
	
	public int calTot(int kor, int eng, int mat) {
		int tot = 0;
		tot = kor + eng + mat;
		return tot;
	}
	
	public double calAvg(int tot) {
		double avg = 0;
		avg = (double) tot / 3.;
		return avg;
	}
	
	public String calGrade(double avg) {
		String grade = null;
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}
	
	public int calRank(ScoreVo vo) {
	    int rank = 1;
	    for (ScoreVo scoreVo : list) {
	        if (vo.getAvg() < scoreVo.getAvg()) {
	            rank++;
	        }
	    }
	    return rank;
	}
}
