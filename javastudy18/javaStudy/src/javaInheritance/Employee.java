package javaInheritance;

public class Employee extends People {
	private int salaly; //급여
	private String dept; //부서
	
	public int getSalaly() {
		return salaly;
	}
	public void setSalaly(int salaly) {
		this.salaly = salaly;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String information() {
		// TODO Auto-generated method stub
		return super.information() + "\t salaly : " + salaly + "\t dept : " + dept;
	}
}
