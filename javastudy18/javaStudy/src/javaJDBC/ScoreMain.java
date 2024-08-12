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
			System.out.println("[1]�Է�[2]���[3]�˻�[4]����[5]����[0]����");
			System.out.print("�۾����� >> ");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.print("�̸� ���� ���� ���� �Է� >> ");
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

				System.out.println("�Է� �Ϸ�");
			} else if (sel == 2) {
				ArrayList<ScoreVo> list = dao.scorePrint();
				if (list == null) {
					System.out.println("������ X");
				} else {
					System.out.println("\t\t\t����ǥ");
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���");
					for (ScoreVo vo : list) {
						System.out.println(vo.getBno() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng()
								+ "\t" + vo.getMat() + "\t" + vo.getTot() + "\t" + df.format(vo.getAve()) + "\t"
								+ vo.getGrade() + "\t");
					}
				}
			} else if (sel == 3) {
				System.out.print("�˻��� �й� �Է� >> ");
				int selBno = sc.nextInt();
				ScoreVo vo = dao.scoreSelect(selBno);
				if (vo == null) {
					System.out.println("�������� �ʴ� �й�");
				} else {
					System.out.println("\t\t\t����ǥ");
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���");
					System.out.println(vo.getBno() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng()
							+ "\t" + vo.getMat() + "\t" + vo.getTot() + "\t" + df.format(vo.getAve()) + "\t"
							+ vo.getGrade() + "\t");
				}
			} else if (sel == 4) {
				System.out.print("������ �й� �Է� >> ");
				int modBno = sc.nextInt();
				ScoreVo vo = dao.scoreSelect(modBno);
				if (vo == null) {
					System.out.println("�������� �ʴ� �й�");
				} else {
					System.out.println("\t\t\t����ǥ");
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���");
					System.out.println(vo.getBno() + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng()
							+ "\t" + vo.getMat() + "\t" + vo.getTot() + "\t" + df.format(vo.getAve()) + "\t"
							+ vo.getGrade() + "\t");
					System.out.println();
					System.out.print("[y]����[n]���� >> ");
					String yn = sc.next();
					if (yn.equalsIgnoreCase("y")) {

						System.out.print("���� ���� ���� �Է� : ");
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
							System.out.println("���� �Ϸ�");
						} else {
							System.out.println("���� ����");
						}
					} else {
						continue;
					}
				}

			} else if (sel == 5) {
				System.out.print("������ �й� �Է� >> ");
				int delBno = sc.nextInt();
				int delResult = dao.scoreDelete(delBno);
				if (delResult > 0) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("�ش� �й� X");
				}
			} else if (sel == 0) {
				flag = false;
				break;
			} else {
				System.out.println("�߸��� �Է�");
				return;
			}

		}

	}

}
