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
			System.out.println("[1]�Է�[2]���[0]����");
			System.out.print("�۾� ���� >> ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("�̸�, ����, ����, ���� �Է� >> ");
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
				System.out.println("\t\t\t����ǥ");
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���");
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
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
		}
	}
}
