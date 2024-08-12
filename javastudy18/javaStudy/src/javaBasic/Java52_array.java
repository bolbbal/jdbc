package javaBasic;

public class Java52_array {
	
	static int[] bno = new int[] {1111, 2222, 3333};
	static String[] name = new String[] {"홍길동", "이순신", "강감찬"};
	static int[] kor = new int[] {90, 70, 80};
	static int[] eng = new int[] {80, 70, 60};
	static int[] mat = new int[] {60, 70, 80};
	static int[] tot = new int[3];
	static double[] avg = new double[3];
	static int[] rank = new int[3];
	static int tkor = 0, teng = 0, tmat = 0;
	
	public static void title() {
		System.out.println("\t\t\t18기 성적표");
		System.out.println("--------------------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등수");
		System.out.println("--------------------------------------------------------------");
	}
	
	public static void calculator() {
		for(int i = 0; i < tot.length; i++) {
			tot[i] = kor[i] + eng[i] + mat[i];
			avg[i] = Math.round((tot[i] / 3.) * 100 )/ 100.;
			tkor += kor[i];
			teng += eng[i];
			tmat += mat[i];
		}
	}
	
	public static void rank(double[] avg) {
		for(int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		for(int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if(avg[i] > avg[j]) {
					rank[j]++;
				}
					
			}
		}
	}
	
	public static void print() {
		for(int i = 0; i < bno.length; i++) {
			System.out.println(bno[i] + "\t" + name[i] + "\t" + kor[i] + "\t" + eng[i] +
					"\t" + mat[i] + "\t" + tot[i] + "\t" + avg[i] + "\t" + rank[i]);
		}
		System.out.println("--------------------------------------------------------------");		
		System.out.println("\t\t" +tkor + "\t" + teng + "\t" + tmat);
	}
	
	public static void main(String[] args) {	
		//성적 처리
		//배열이란 같은 데이터 타입의 값을 저장하는 여러개의 기억장소
		calculator();

		rank(avg);
		
		title();
		
		print();
	}

}
