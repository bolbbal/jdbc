package JavaInterface;

import java.util.Scanner;

public class ScoreMethod implements ScoreInterface {
	Scanner sc = new Scanner(System.in);
	Score[] s = new Score[3];
	
	@Override
	public void scoreInsert() {
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				Score sr = new Score();
				System.out.print("�й� �Է� >> ");
				sr.setId(sc.next());
				System.out.print("�̸� �Է� >> ");
				sr.setName(sc.next());
				System.out.print("�������� �Է� >> ");
				sr.setKor(sc.nextInt());
				System.out.print("�������� �Է� >> ");
				sr.setEng(sc.nextInt());
				System.out.print("�������� �Է� >> ");
				sr.setMat(sc.nextInt());
				sr.setTot(sr.getKor() + sr.getEng() + sr.getMat());
				sr.setAve(sr.getTot() / 3.);
				
				if(sr.getAve() >= 90) {
					sr.setGrade("A");
				} else if(sr.getAve() >= 80) {
					sr.setGrade("B");
				} else if(sr.getAve() >= 70) {
					sr.setGrade("C");
				} else if(sr.getAve() >= 60) {
					sr.setGrade("D");
				} else {
					sr.setGrade("���հ�");
				}
				s[i] = sr;
				return;
			}
		}
		rank();
	}
	
	@Override
	public void scorePrint() {
		rank();
		System.out.println("\t\t����ǥ");
		System.out.println("-----------------------------------------");
		System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t����\t���");
		for(int i = 0; i < s.length; i++) {
			if(s[i] != null) {
				System.out.print(s[i].getId() + "\t");
				System.out.print(s[i].getName()  + "\t");
				System.out.print(s[i].getKor()+ "\t");
				System.out.print(s[i].getEng() + "\t");
				System.out.print(s[i].getMat() + "\t");
				System.out.print(s[i].getTot() + "\t");
				System.out.print(s[i].getAve() + "\t");
				System.out.print(s[i].getGrade() + "\t");
				System.out.println(s[i].getRank());
			}
			
		}
		
		return;
	}
	
	public void rank() {
		for(int i = 0; i < s.length; i++) {
			int rank = 1;
			for(int j = 0; j < s.length; j++) {
				if(s[i] != null && s[j] != null) {
					if(s[i].getAve() < s[j].getAve()) {
						rank++;
						s[i].setRank(rank);
					}
				}
			}
		}
	}
	
	@Override
	public void scoreSearch(String num) {
		rank();
		for(int i = 0; i < s.length; i++) {
			if(s[i] != null && num.equals(s[i].getId())) {
				System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t����\t���");
				System.out.print(s[i].getId() + "\t");
				System.out.print(s[i].getName()  + "\t");
				System.out.print(s[i].getKor()+ "\t");
				System.out.print(s[i].getEng() + "\t");
				System.out.print(s[i].getMat() + "\t");
				System.out.print(s[i].getTot() + "\t");
				System.out.print(s[i].getAve() + "\t");
				System.out.print(s[i].getGrade() + "\t");
				System.out.println(s[i].getRank());
				return;
			}
			
		}
		for(int i = 0; i < s.length; i++) {
			if(!(num.equals(s[i].getId()))) {
				System.out.println("�ش� ��ȣ�� �����ϴ�.");
				return;
			}
		}
	}
}
