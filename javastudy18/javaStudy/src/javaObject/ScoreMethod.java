package javaObject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ScoreMethod { //메소드 설계도
	int count = 0;
	Scanner sc = new Scanner(System.in);
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	public void insertMethod(Score18[] array) {

		if(array[count] != null && array[count+1] != null && array[count+2] != null) {
			System.out.println("빈 공간이 없습니다.");
			return;
		} 
		System.out.print("번호 이름 총점 : ");
		String bno = sc.next();
		String name = sc.next();
		int tot = sc.nextInt();	
		
		Score18 s18 = new Score18(bno, name, tot);
				
		for (int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = s18;
				array[i].avg = ((array[i].tot / 3.) * 100 )/ 100;
				array[i].grade = null;
				
				if (array[i].avg >= 90) {
					array[i].grade = "A";
				} else if (array[i].avg >= 80) {
					array[i].grade = "B";
				} else if (array[i].avg >= 70) {
					array[i].grade = "C";
				} else if (array[i].avg >= 60) {
					array[i].grade = "D";
				} else {
					array[i].grade = "F";
				}
				break;
			}
		}
		rank(array);
	}
		
	//출력 기능
	public void printAll(Score18[] array) {
		title();
		
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] != null) {
				System.out.println(array[i].bno + "\t" + array[i].name  + "\t" + 
							array[i].tot + "\t" + df.format(array[i].avg) + "\t" +
							array[i].grade + "\t" + array[i].rank
							);
			}
		}
	}
	public void rank(Score18[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				array[i].rank = 1;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null)
			for (int j = 0; j < array.length; j++) {
				if (array[j] != null) {
					if(array[i].avg < array[j].avg) {
						array[i].rank++;
					}			
				}		
			}
		}
	}
	
	public void title() {
		System.out.println("\t\t18기 성적표");
		System.out.println("번호\t이름\t총점\t평균\t등급\t순위");
	}
	//검색 기능
	public void searchMethod(Score18[] array) {
		System.out.print("검색할 번호를 입력하세요 >> ");
		String num = sc.next();
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].bno.equals(num)) {
				title();
				System.out.println(array[i].bno + "\t" + array[i].name  + "\t" + 
							array[i].tot + "\t" + df.format(array[i].avg) + "\t" +
							array[i].grade + "\t" + array[i].rank
							);
				found = true;
				break;
			} 
			
		}
		if(found == false) {
			System.out.println("해당 번호의 학생이 없습니다.");
		}
		rank(array);
	}
	//삭제 기능
	public void deleteMethod(Score18[] array) {
		System.out.print("삭제할 학생의 번호를 입력하세요 >> ");
		String num = sc.next();
		boolean found = false;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].bno.equals(num)) {
				array[i] = null;
				System.out.println("해당 번호의 학생을 삭제했습니다.");
				found = true;
				break;
			}
			
		}
		if(found == false) {
			System.out.println("해당 번호의 학생이 없습니다.");
		}
		rank(array);
	}
}
