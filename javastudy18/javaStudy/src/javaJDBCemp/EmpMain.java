package javaJDBCemp;
import java.util.*;
import java.sql.*;

public class EmpMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		EmpDao dao = new EmpDao();
		while(flag) {
			System.out.println("[1]정렬출력[2]부서,직업별 급여총액출력[3]부서별 최대 급여[4]이름 검색[5][0]종료");
			System.out.print("작업 선택 >> ");
			int sel = sc.nextInt();
			
			if (sel == 0) {
				System.out.println("프로그램 종료");
				flag = false;
				break;
			}
			else if (sel == 1) {
				List<EmpVo> list = dao.getEmpSelect();
				System.out.println("번호\t이름\t직군\t\t매니저\t입사일\t연봉\t보너스\t근무지");
				for (EmpVo vo : list) {
					System.out.print(vo.getEno() + "\t");
					System.out.print(vo.getEname() + "\t");
					System.out.print(vo.getJob() + "\t\t");
					System.out.print(vo.getManager() + "\t");
					String hiredate = vo.getHiredate().substring(2,4)+"-"+vo.getHiredate().substring(5,7)+"-"+vo.getHiredate().substring(8,10);
					System.out.print(hiredate + "\t");
					System.out.print(vo.getSalary() + "\t");
					System.out.print(vo.getCommission() + "\t");
					System.out.print(vo.getDno() + "\t");
					System.out.println();
				}
			} else if (sel == 2) {
				List<EmpVo> list = dao.getAverage();
				System.out.println("부서\t직업\t수\t급여총액\t급여평균");
				for(EmpVo vo : list) {
					System.out.print(vo.getDno() + "\t");
					System.out.print(vo.getJob() + "\t");
					System.out.print(vo.getJobtot() + "\t");
					System.out.print(vo.getSaltot() + "\t");
					System.out.print(vo.getSalave() + "\t");
					System.out.println();
				}
			} else if (sel == 3) {
				List<EmpVo> list = dao.getHaving();
				System.out.println("부서\t최대값");
				for(EmpVo vo : list) {
					System.out.print(vo.getDno() + "\t");
					System.out.print(vo.getMaxsal() + "\t");
					System.out.println();
				}
			} else if (sel == 4) {
				System.out.print("검색하고 싶은 이름 입력 >> ");
				String ename = sc.next();
				EmpVo vo = dao.getSearchName(ename);
				System.out.println("번호\t이름\t직군\t\t매니저\t입사일\t연봉\t보너스\t근무지");
				System.out.print(vo.getEno() + "\t");
				System.out.print(vo.getEname() + "\t");
				System.out.print(vo.getJob() + "\t\t");
				System.out.print(vo.getManager() + "\t");
				String hiredate = vo.getHiredate().substring(2,4)+"-"+vo.getHiredate().substring(5,7)+"-"+vo.getHiredate().substring(8,10);
				System.out.print(hiredate + "\t");
				System.out.print(vo.getSalary() + "\t");
				System.out.print(vo.getCommission() + "\t");
				System.out.print(vo.getDno() + "\t");
				System.out.println();
				
			}
		}
	}

}
