package JavaCollection;

import java.text.DecimalFormat;
import java.util.ArrayList;import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ScoreMapDao {
	Scanner sc = new Scanner(System.in);
	HashMap<String, ScoreVo> list = new HashMap<String, ScoreVo>();
	DecimalFormat df = new DecimalFormat("###.00");
	Set<String> keySet = list.keySet();
	
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
		
		if(list.containsKey(vo.getId())) { //containsKey() ������ Ű�� �����ϰ� ������ true ����.
			System.out.println("�̹� �����ϴ� �л��Դϴ�.");
		} else {
			list.put(id, vo);			
		}
	}
	
	public void scorePrint() {
		System.out.println("\t\t\t18�� ����ǥ");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t����");
		calRank();
		for (String key : keySet) {
			System.out.print(list.get(key).getId() + "\t");
			System.out.print(list.get(key).getName() + "\t");
			System.out.print(list.get(key).getKor() + "\t");
			System.out.print(list.get(key).getEng() + "\t");
			System.out.print(list.get(key).getMat() + "\t");
			System.out.print(list.get(key).getTot() + "\t");
			System.out.print(df.format(list.get(key).getAvg()) + "\t");
			System.out.print(list.get(key).getGrade() + "\t");
			System.out.println(list.get(key).getRank() + "\t");
		}
		
	}
	
	public void scoreUpdate() {
		System.out.print("�����ϰ� ���� �л��� ��ȣ�� �Է��ϼ���. >> ");
		String id = sc.next();
		for (String vo : keySet) {
			if (list.get(vo).getId().equals(id)) {
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t����");
				System.out.print(list.get(vo).getId() + "\t");
				System.out.print(list.get(vo).getName() + "\t");
				System.out.print(list.get(vo).getKor() + "\t");
				System.out.print(list.get(vo).getEng() + "\t");
				System.out.print(list.get(vo).getMat() + "\t");
				System.out.print(list.get(vo).getTot() + "\t");
				System.out.print(df.format(list.get(vo).getAvg()) + "\t");
				System.out.print(list.get(vo).getGrade() + "\t");
				System.out.println(list.get(vo).getRank() + "\t");
				System.out.println("---------------------------------------------");
				System.out.println("������ �����͸� �������ּ���.");
				System.out.print("�̸� : ");
				String name = sc.next();
				list.get(vo).setName(name);
				System.out.print("���� ���� : ");
				int kor = sc.nextInt();
				list.get(vo).setKor(kor);
				System.out.print("���� ���� : ");
				int eng = sc.nextInt();
				list.get(vo).setEng(eng);
				System.out.print("���� ���� : ");
				int mat = sc.nextInt();
				list.get(vo).setMat(mat);
				int tot = calTot(kor, eng, mat);
				double avg = calAvg(tot);
				String grade = calGrade(avg);
				list.get(vo).setTot(tot);
				list.get(vo).setAvg(avg);
				list.get(vo).setGrade(grade);
	
				return;
				}
			}
		System.out.println("�ش��ϴ� �л��� �����ϴ�.");	
	}
	
	public void scoreDelete() {
		System.out.print("�����ϰ� ���� �л��� ��ȣ�� �Է��ϼ���. >>");
		String id = sc.next();
		for (String key : keySet) {
			if (list.get(key).getId().equals(id)) {
				list.remove(key);
				System.out.println("�����߽��ϴ�.");
				return;
			}
		}
		System.out.println("�ش��ϴ� �л��� �����ϴ�.");
	}
	
	public void scoreSelect() {
		System.out.print("�˻��ϰ� ���� �л��� ��ȣ�� �Է��ϼ���. >>");
		String id = sc.next();
		for (String key : keySet) {
			if (list.get(key).getId().equals(id)) {
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t����");
				System.out.print(list.get(key).getId() + "\t");
				System.out.print(list.get(key).getName() + "\t");
				System.out.print(list.get(key).getKor() + "\t");
				System.out.print(list.get(key).getEng() + "\t");
				System.out.print(list.get(key).getMat() + "\t");
				System.out.print(list.get(key).getTot() + "\t");
				System.out.print(df.format(list.get(key).getAvg()) + "\t");
				System.out.print(list.get(key).getGrade() + "\t");
				System.out.println(list.get(key).getRank() + "\t");
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
	
	public void calRank() {
		
	    for (String key : keySet) {
	    	int rank = 1;
	    	list.get(key).setRank(rank);
	    	for (String key2 : keySet) {
	    		 if (list.get(key).getAvg() < list.get(key2).getAvg()) {
	    			rank++;
	 	            list.get(key).setRank(rank);
	 	        }
	    	}
	       
	    }
	}
}
