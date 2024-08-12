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
				System.out.print("학번 입력 >> ");
				sr.setId(sc.next());
				System.out.print("이름 입력 >> ");
				sr.setName(sc.next());
				System.out.print("국어점수 입력 >> ");
				sr.setKor(sc.nextInt());
				System.out.print("영어점수 입력 >> ");
				sr.setEng(sc.nextInt());
				System.out.print("수학점수 입력 >> ");
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
					sr.setGrade("불합격");
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
		System.out.println("\t\t성적표");
		System.out.println("-----------------------------------------");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t등수");
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
				System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t등수");
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
				System.out.println("해당 번호가 없습니다.");
				return;
			}
		}
	}
}
