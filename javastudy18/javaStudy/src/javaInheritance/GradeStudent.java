package javaInheritance;

public class GradeStudent extends Student {
	
	private int tot;
	private double ave;
	private String grade;
	
	public GradeStudent() {}
	
	public GradeStudent(String id, String name, int kor, int eng, int mat) {
		super(id, name, kor, eng, mat);
		this.tot = calculateTot();
		this.grade = calculateAve();
		
	}
	
	private int calculateTot() {
		return super.kor + eng + mat;
	}
	
	private String calculateAve() {
		ave = tot / 3.;
		if(ave >= 90) {
			return "A";
		} else if(ave >= 80) {
			return "B";
		} else if(ave >= 70) {
			return "C";
		} else if(ave >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	@Override
	public String toString() {
		return "Student Id : " + id + "\t name : " + name + 
				"\t kor : " + kor + "\t eng : " + eng +
				"\t mat : " + mat + "\t tot : " + tot +
				"\t ave : " + ave + "\t grade : " + grade;
	}
}
