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
			System.out.println("[1]�л�������ȸ[2]�ݺ����[0]����");
			System.out.print("�۾� ���� >> ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("���α׷� ����");
				flag = false;
				break;
			} else if (sel == 1) {
				List<ScoreVo> list = dao.selectStdScore();
				int korTot = 0;
				int engTot = 0;
				int matTot = 0;
				System.out.println("\t\t\t�л�������ȸ");
				System.out.println("�г�-��-��ȣ\t�̸�\t����\t����\t����\t����\t����\t���");
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
				System.out.println("\t\t\t�г�����\t" + korTot + "\t" + engTot + "\t" + matTot);
				System.out.println("\t\t\t�г����\t" + df.format(korAve) + "\t" + df.format(engAve) + "\t" + df.format(matAve));

			} else if (sel == 2) {
				List<ScoreVo> list = dao.selectClassTot();
				System.out.println("\t\t\t�ݺ����");
				System.out.println("�г�\t��\t�����\t��������\t��������\t��������\t�������\t�������\t�������");
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
