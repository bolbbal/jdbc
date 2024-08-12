package javaJDBC;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ScoreDao dao = new ScoreDao();
		DecimalFormat df = new DecimalFormat("###.##");
		boolean flag = true;

		while (flag) {
			System.out.println("[1]입력[2]출력[3]검색[4]수정[5]삭제[0]종료");
			System.out.print("작업선택 >> ");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.print("이름 국어 영어 수학 입력 >> ");
				String name = sc.next();
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();

				ScoreVo vo = new ScoreVo();
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);

				dao.scoreInsert(vo);

				System.out.println("입력 완료");
			} else if (sel == 2) {
				ArrayList<ScoreVo> list = dao.scorePrint();
				if (list == null) {
					System.out.println("데이터 X");
				} else {
					System.out.println("\t\t\t성적표");
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
					for (ScoreVo vo : list) {
						System.out.println(vo.getBno() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng()
								+ "\t" + vo.getMat() + "\t" + vo.getTot() + "\t" + df.format(vo.getAve()) + "\t"
								+ vo.getGrade() + "\t");
					}
				}
			} else if (sel == 3) {
				System.out.print("검색할 학번 입력 >> ");
				int selBno = sc.nextInt();
				ScoreVo vo = dao.scoreSelect(selBno);
				if (vo == null) {
					System.out.println("존재하지 않는 학번");
				} else {
					System.out.println("\t\t\t성적표");
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
					System.out.println(vo.getBno() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng()
							+ "\t" + vo.getMat() + "\t" + vo.getTot() + "\t" + df.format(vo.getAve()) + "\t"
							+ vo.getGrade() + "\t");
				}
			} else if (sel == 4) {
				System.out.print("수정할 학번 입력 >> ");
				int modBno = sc.nextInt();
				ScoreVo vo = dao.scoreSelect(modBno);
				if (vo == null) {
					System.out.println("존재하지 않는 학번");
				} else {
					System.out.println("\t\t\t성적표");
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
					System.out.println(vo.getBno() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng()
							+ "\t" + vo.getMat() + "\t" + vo.getTot() + "\t" + df.format(vo.getAve()) + "\t"
							+ vo.getGrade() + "\t");
					System.out.println();
					System.out.print("[y]수정[n]유지 >> ");
					String yn = sc.next();
					if (yn.equalsIgnoreCase("y")) {

						System.out.print("국어 영어 수학 입력 : ");
						int kor = sc.nextInt();
						int eng = sc.nextInt();
						int mat = sc.nextInt();

						ScoreVo uvo = new ScoreVo();
						uvo.setBno(modBno);
						uvo.setKor(kor);
						uvo.setEng(eng);
						uvo.setMat(mat);
						int result = dao.scoreUpdate(uvo);
						if (result > 0) {
							System.out.println("수정 완료");
						} else {
							System.out.println("수정 실패");
						}
					} else {
						continue;
					}
				}

			} else if (sel == 5) {
				System.out.print("삭제할 학번 입력 >> ");
				int delBno = sc.nextInt();
				int delResult = dao.scoreDelete(delBno);
				if (delResult > 0) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("해당 학번 X");
				}
			} else if (sel == 0) {
				flag = false;
				break;
			} else {
				System.out.println("잘못된 입력");
				return;
			}

		}

	}

}
