package JavaCollection;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreDao {
	Scanner sc = new Scanner(System.in);
	ArrayList<ScoreVo> list = new ArrayList<ScoreVo>();
	DecimalFormat df = new DecimalFormat("###.00");
	
	public void scoreInsert() {
		System.out.print("학번 이름 국어 영어 수학 입력 >> ");
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
		System.out.println("\t\t\t18기 성적표");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t순위");
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
		System.out.print("수정하고 싶은 학생의 번호를 입력하세요. >> ");
		String id = sc.next();
		for (ScoreVo vo : list) {
			if (vo.getId().equals(id)) {
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t순위");
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
				System.out.println("수정할 데이터를 수정해주세요.");
				System.out.print("이름 : ");
				String name = sc.next();
				vo.setName(name);
				System.out.print("국어 점수 : ");
				int kor = sc.nextInt();
				vo.setKor(kor);
				System.out.print("영어 점수 : ");
				int eng = sc.nextInt();
				vo.setEng(eng);
				System.out.print("수학 점수 : ");
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
		System.out.println("해당하는 학생이 없습니다.");	
	}
	
	public void scoreDelete() {
		System.out.print("삭제하고 싶은 학생의 번호를 입력하세요. >>");
		String id = sc.next();
		for (ScoreVo vo : list) {
			if (vo.getId().equals(id)) {
				list.remove(vo);
				System.out.println("삭제했습니다.");
				return;
			}
		}
		System.out.println("해당하는 학생이 없습니다.");
	}
	
	public void scoreSelect() {
		System.out.print("검색하고 싶은 학생의 번호를 입력하세요. >>");
		String id = sc.next();
		for (ScoreVo vo : list) {
			if (vo.getId().equals(id)) {
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t순위");
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
		System.out.println("해당하는 학생이 없습니다.");
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
