package javaInheritance;

public class Jsl18 extends People {
	private int grade;
	private String major;
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String information() {
		// TODO Auto-generated method stub
		return super.information() + "\t grade : " + grade + "\t major : " + major;
	}
}
