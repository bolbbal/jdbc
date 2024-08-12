package javaJDBCemp;

public class EmpVo { //테이블을 보고 객체 형태로 데이터 주고받기 위한 Vo클래스 만들기
	private int eno;       
	private String ename;              
	private String job;            
	private int manager;              
	private String hiredate;               
	private int salary;
	private double commission;
	private int dno;
	
	private int saltot;
	private double salave;
	private int jobtot;
	private int maxsal;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getSaltot() {
		return saltot;
	}
	public void setSaltot(int saltot) {
		this.saltot = saltot;
	}
	public double getSalave() {
		return salave;
	}
	public void setSalave(double salave) {
		this.salave = salave;
	}
	public int getJobtot() {
		return jobtot;
	}
	public void setJobtot(int jobtot) {
		this.jobtot = jobtot;
	}
	public int getMaxsal() {
		return maxsal;
	}
	public void setMaxsal(int maxsal) {
		this.maxsal = maxsal;
	}
	
	
	
	
}
