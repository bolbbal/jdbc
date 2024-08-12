package javaObject;

import java.text.DecimalFormat;

public class Employee {
	//사원정보
	//사원번호, 사원명, 부서코드, 직위, 근무지, 실적, 입사일
	//멤버변수
	String no;
	String name;
	String depart;
	String level;
	String workspace;
	String performance;
	String joindate;
	
	int salary;
	
	//생성자
	public Employee() {
		
	}
	
	public Employee(String no, String name, String depart, String level, String workspace, String performance, String joindate) {
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.level = level;
		this.workspace = workspace;
		this.performance = performance;
		this.joindate = joindate;
	}
	//메서드
	public void title() {
		System.out.println("\t\t사원목록조회");
		System.out.println("사원번호\t사원명\t부서\t직위\t기본급\t\t근무지\t실적\t입사일");
	}
	
	public void getList() {//사원목록 출력
		DecimalFormat df = new DecimalFormat("#,###");
		
		String departPrint = null;
		if(depart.equals("01")) {
			departPrint = "인사";
		} else if(depart.equals("02")) {
			departPrint = "총무";
		} else if(depart.equals("03")) {
			departPrint = "정보";
		}else if(depart.equals("04")) {
			departPrint = "영업";
		}
		String levelPrint = null;
		if(level.equals("10")) {
			levelPrint = "이사";
			salary = 4500000;
		} else if(level.equals("20")) {
			levelPrint = "부장";
			salary = 3500000;
		} else if(level.equals("30")) {
			levelPrint = "과장";
			salary = 3000000;
		} else if(level.equals("40")) {
			levelPrint = "대리";
			salary = 2500000;
		} else if(level.equals("50")) {
			levelPrint = "사원";
			salary = 2000000;
		}
		System.out.println(no + "\t" + name + "\t" + departPrint + "\t" + levelPrint + "\t" + df.format(salary) +"\t" + workspace + "\t" + performance + "\t" + joindate);
	}
}
