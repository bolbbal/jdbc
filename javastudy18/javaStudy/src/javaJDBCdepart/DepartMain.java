package javaJDBCdepart;

import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DepartMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		DepartDao dao = new DepartDao();
		DecimalFormat df = new DecimalFormat("#,###");
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
		List<DepartVo> list = new ArrayList<DepartVo>();
		while(flag) {
			System.out.println("[1]사원목록조회[2]사원급여조회[3]부서별급여조회[4]지역별급여조회[5]종료");
			System.out.print("작업 선택 >> ");
			String sel = sc.next();
			if(sel.equals("1")) {
				list = dao.selectEmployeeList(list);
				System.out.println("\t\t\t사원목록조회");
				System.out.println("사원번호\t사원명\t부서\t직위\t근무지\t실적\t입사일");
				for(DepartVo vo : list) {
					System.out.print(vo.getE_no() + "\t");
					System.out.print(vo.getE_name() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.print(vo.getLname() + "\t");
					System.out.print(vo.getWname() + "\t");
					System.out.print(vo.getPerformance() + "등급\t");
					System.out.println(vo.getE_join_date().substring(0,4) + "-" + vo.getE_join_date().substring(4,6) + "-" + vo.getE_join_date().substring(6) + "\t");
				}
			} else if(sel.equals("2")) {
				list = dao.selectEmployeeSalary(list);
				System.out.println("\t\t\t사원급여조회");
				System.out.println("사원번호\t사원명\t부서\t직위\t근무지\t실적\t급여");
				for(DepartVo vo : list) {
					System.out.print(vo.getE_no() + "\t");
					System.out.print(vo.getE_name() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.print(vo.getLname() + "\t");
					System.out.print(vo.getWname() + "\t");
					System.out.print(vo.getPerformance() + "등급\t");
					System.out.println(df.format(vo.getSal()) + "\t");
				}
			} else if(sel.equals("3")) {
				list = dao.selectDepartSalary(list);
				System.out.println("\t\t\t부서별급여조회");
				System.out.println("부서코드\t부서명\t총급여");
				for(DepartVo vo : list) {
					System.out.print(vo.getDepart_code() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.println(df.format(vo.getSal()) + "\t");
				}
			} else if(sel.equals("4")) {
				list = dao.selectWorkPlaceSalary(list);
				System.out.println("\t\t\t지역별급여조회");
				System.out.println("지역코드\t지역명\t총급여");
				for(DepartVo vo : list) {
					System.out.print(vo.getWork_place() + "\t");
					System.out.print(vo.getWname() + "\t");
					System.out.println(df.format(vo.getSal()) + "\t");
				}
			} else if(sel.equals("5")) {
				System.out.println("작업 종료");
				flag = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}
	}

}
