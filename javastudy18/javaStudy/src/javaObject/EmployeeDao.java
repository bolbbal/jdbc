package javaObject;

import java.text.DecimalFormat;

public class EmployeeDao {
	//메서드
	public void title() {
		System.out.println("\t\t\t사원목록조회");
		System.out.println("사원번호\t사원명\t부서\t직위\t기본급\t\t근무지\t실적\t입사일");
	}
	
	public void getList(Employee[] emp) {//사원목록 출력
		DecimalFormat df = new DecimalFormat("#,###");
		
		for(int i = 0; i < emp.length; i++) {
			int salary = 0;
			String departPrint = null;
			if(emp[i].depart.equals("01")) {
				departPrint = "인사";
			} else if(emp[i].depart.equals("02")) {
				departPrint = "총무";
			} else if(emp[i].depart.equals("03")) {
				departPrint = "정보";
			}else if(emp[i].depart.equals("04")) {
				departPrint = "영업";
			}
			String levelPrint = null;
			if(emp[i].level.equals("10")) {
				levelPrint = "이사";
				salary = 4500000;
			} else if(emp[i].level.equals("20")) {
				levelPrint = "부장";
				salary = 3500000;
			} else if(emp[i].level.equals("30")) {
				levelPrint = "과장";
				salary = 3000000;
			} else if(emp[i].level.equals("40")) {
				levelPrint = "대리";
				salary = 2500000;
			} else if(emp[i].level.equals("50")) {
				levelPrint = "사원";
				salary = 2000000;
			}
			System.out.println(emp[i].no + "\t" + emp[i].name + "\t" + departPrint + "\t" + levelPrint + "\t" + df.format(salary) +"\t" + emp[i].workspace + "\t" + emp[i].performance + "\t" + emp[i].joindate);
		}
		
	}
}
