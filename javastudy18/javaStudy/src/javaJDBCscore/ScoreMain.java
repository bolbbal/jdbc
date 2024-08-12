package javaJDBCscore;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;

public class ScoreMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		ScoreDao dao = new ScoreDao();
		DecimalFormat df = new DecimalFormat("###.#");
		while (flag) {
			System.out.println("[1]학생성적조회[2]반별통계[0]종료");
			System.out.print("작업 선택 >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("프로그램 종료");
				flag = false;
				break;
			} else if (sel == 1) {
				List<ScoreVo> list = dao.selectStdScore();
				int korTot = 0;
				int engTot = 0;
				int matTot = 0;
				System.out.println("\t\t\t학생성적조회");
				System.out.println("학년-반-번호\t이름\t성별\t국어\t영어\t수학\t총점\t평균");
				for (ScoreVo vo : list) {
					System.out.print(vo.getSyear() + "-" + vo.getSclass() + "-" + vo.getSno() + "\t\t");
					System.out.print(vo.getSname() + "\t");
					System.out.print(vo.getGender() + "\t");
					System.out.print(vo.getKor() + "\t");
					korTot += vo.getKor();
					System.out.print(vo.getEng() + "\t");
					engTot += vo.getEng();
					System.out.print(vo.getMat() + "\t");
					matTot += vo.getMat();
					System.out.print(vo.getTot() + "\t");
					System.out.print(vo.getAve() + "\t");
					System.out.println();
				}
				double korAve = korTot / 9.;
				double engAve = engTot / 9.;
				double matAve = matTot / 9.;
				System.out.println("\t\t\t학년총점\t" + korTot + "\t" + engTot + "\t" + matTot);
				System.out.println("\t\t\t학년평균\t" + df.format(korAve) + "\t" + df.format(engAve) + "\t" + df.format(matAve));

			} else if (sel == 2) {
				List<ScoreVo> list = dao.selectClassTot();
				System.out.println("\t\t\t반별통계");
				System.out.println("학년\t반\t교사명\t국어총점\t영어총점\t수학총점\t국어평균\t영어평균\t수학평균");
				for (ScoreVo vo : list) {
					System.out.print(vo.getSyear() + "\t");
					System.out.print(vo.getSclass() + "\t");
					System.out.print(vo.getTname() + "\t");
					System.out.print(vo.getKorTot() + "\t");
					System.out.print(vo.getEngTot() + "\t");
					System.out.print(vo.getMatTot() + "\t");
					System.out.print(vo.getKorAve() + "\t");
					System.out.print(vo.getEngAve() + "\t");
					System.out.println(vo.getMatAve() + "\t");
				}
			}
		}
	}

}
