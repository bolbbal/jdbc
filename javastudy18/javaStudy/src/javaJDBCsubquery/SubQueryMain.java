package javaJDBCsubquery;

import java.sql.*;
import java.util.*;

public class SubQueryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SubDao dao = new SubDao();
		
		boolean flag = true;
		
		while(flag) {
			System.out.print("[1]검색[2]종료 >> ");
			String menu = sc.next();
			
			if (menu.equals("1")) {
				List<SubVo> list = new ArrayList<SubVo>();
				list = dao.selectNotM(list);
				
				System.out.println("평균 급여보다 많이 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여");
				System.out.println("사원번호\t이름\t급여");
				
//				for(SubVo vo : list) {
//					System.out.print(vo.getEno() + "\t");
//					System.out.print(vo.getEname() + "\t");
//					System.out.println(vo.getSalary() + "\t");
//				}
				
				list.forEach(vo -> {
					System.out.print(vo.getEno() + "\t");
					System.out.print(vo.getEname() + "\t");
					System.out.println(vo.getSalary() + "\t");
				});
				
			} else if (menu.equals("2")) {
				System.out.println("프로그램 종료");
				flag = false;
				break;
			} else {
				System.out.println("잘못된 입력");
				return;
			}
		}
	}

}
