package javaJDBCjoin;

import java.util.*;

public class JoinMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		List<JoinVo> list = new ArrayList<JoinVo>();
		JoinDao dao = new JoinDao();
		while(flag) {
			System.out.println("[1]3개의 테이블 조인 검색[0]종료");
			System.out.print("작업 선택 >> ");
			int sel = sc.nextInt();
			if(sel == 0) {
				System.out.println("프로그램 종료");
				flag = false;
				break;
			} else if(sel == 1) {
				list = dao.getJoin();
				System.out.println("사원명\t직책\t연봉\t등급");
				for(JoinVo vo : list) {
					System.out.print(vo.getEname() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.print(vo.getSalary() + "\t");
					System.out.print(vo.getGrade() + "\t");
					System.out.println();
				}
			}
		}
	}

}
