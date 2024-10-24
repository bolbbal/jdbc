package usedCar;

import java.util.*;

public class UsedCarMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UsedCarDao dao = new UsedCarDao();
		
		boolean flag = true;
		
		while (flag) {
			
			System.out.println("[1]모든 회원 검색[2]][0]종료");
			System.out.print("작업 선택 >> ");
			String work = sc.next();
			
			if (work.equals("0")) {
				flag = false;
				
				break;
				
			} else if (work.equals("1")) {
				System.out.println("모든 회원 검색 실행" + "\n");
				
				List<UsedCarVo> list = dao.selectMemberAll();
				
				System.out.println("\t\t\t\t회원 목록");
				System.out.println("회원번호\t회원이름\t성별\t나이\t전화번호\t주소\t이메일\t타입");
				
				for(UsedCarVo vo : list) {
					System.out.print(vo.getMember_no() + "\t");
					System.out.print(vo.getMember_name() + "\t");
					System.out.print(vo.getMember_gender() + "\t");
					System.out.print(vo.getMember_age() + "\t");
					System.out.print(vo.getMember_call() + "\t");
					System.out.print(vo.getMember_address() + "\t");
					System.out.print(vo.getMember_email() + "\t");
					System.out.print(vo.getMember_type() + "\t");
					System.out.println();
				}
			}
		}
	}

}
