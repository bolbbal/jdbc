package javaJDBCTest;

import java.text.DecimalFormat;
import java.util.*;

public class ScoreMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		ScoreDao dao = new ScoreDao();
		DecimalFormat df = new DecimalFormat("###.##");
		while(flag) {
			System.out.println("[1]입력[2]출력[0]종료");
			System.out.print("작업 선택 >> ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("이름, 국어, 영어, 수학 입력 >> ");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				ScoreVo vo = new ScoreVo();
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				dao.insert(vo);
			} else if (sel == 2) {
				ArrayList<ScoreVo> list = dao.print();
				System.out.println("\t\t\t성적표");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
				for(ScoreVo vo : list) {
					System.out.println(vo.getBno() + "\t" +
									vo.getName() + "\t" +
									vo.getKor() + "\t" +
									vo.getEng() + "\t" +
									vo.getMat() + "\t" +
									vo.getTot() + "\t" +
									df.format(vo.getAve()) + "\t" +
									vo.getGrade() + "\t");
				}
			} else if (sel == 3) {
				dao.select();
			} else if (sel == 4) {
				dao.update();
			} else if (sel == 5) {
				dao.delete();
			} else if (sel == 0) {
				flag = false;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}
	}
}
