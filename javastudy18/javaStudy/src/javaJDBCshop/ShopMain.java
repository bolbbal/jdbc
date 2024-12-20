package javaJDBCshop;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ShopDao dao = new ShopDao();
		Date now = new Date();
		String now1 = sdf.format(now).toString();
		
		boolean flag = true;
		while (flag) {
			System.out.println("[1]회원등록[2]회원등록 조회[3]회원매출조회[4]종료");
			System.out.print("작업 선택 >> ");
			String sel = sc.next();

			if (sel.equals("1")) {
				ShopVo vo = new ShopVo();
				int custno = dao.getAuto();
				System.out.println("홈쇼핑 회원 등록");
				System.out.println("회원번호(자동발생) : " + custno);
				vo.setCustno(custno);
				
				System.out.print("회원성명 : ");
				String custname = sc.next();
				vo.setCustname(custname);
				
				System.out.print("회원전화 : ");
				String phone = sc.next();
				vo.setPhone(phone);
				
				System.out.print("회원주소 : ");
				String address = sc.next();
				vo.setAddress(address);
				
				System.out.println("가입일자 : " + now1);
				vo.setJoindate(now1);
				
				System.out.print("고객등급[A:VIP,B:일반,C:직원] : ");
				String grade = sc.next();
				vo.setGrade(grade);
				
				System.out.print("도시코드 : ");
				String city = sc.next();
				vo.setCity(city);
				
				System.out.print("등록 동의[y/n] : ");
				String agree = sc.next();
				
				if (agree.equalsIgnoreCase("y")) {
					dao.insertMember(vo);
				} else if (agree.equalsIgnoreCase("n")) {
					return;
				}

			} else if (sel.equals("2")) {
				List<ShopVo> list = dao.selectMember();
				
				System.out.println("\t\t\t회원목록조회/수정");
				System.out.println("회원번호\t회원성명\t전화번호\t\t주소\t\t가입일자\t\t고객등급\t거주지역");
				
				for (ShopVo vo : list) {
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getCustname() + "\t");
					System.out.print(vo.getPhone() + "\t");
					System.out.print(vo.getAddress() + "\t");
					System.out.print(vo.getJoindate().substring(0, 10) + "\t");
					
					String grade = null;
					
					if (vo.getGrade().equals("A")) {
						grade = "VIP";
					} else if (vo.getGrade().equals("B")) {
						grade = "일반";
					} else if (vo.getGrade().equals("C")) {
						grade = "직원";
					}
					
					System.out.print(grade + "\t");
					System.out.println(vo.getCity() + "\t");
				}
			} else if (sel.equals("3")) {
				List<ShopVo> list = dao.selectMemberTotCost();
				System.out.println("\t회원매출조회");
				System.out.println("회원번호\t회원성명\t고객등급\t매출");
				for (ShopVo vo : list) {
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getCustname() + "\t");
					String grade = null;
					if (vo.getGrade().equals("A")) {
						grade = "VIP";
					} else if (vo.getGrade().equals("B")) {
						grade = "일반";
					} else if (vo.getGrade().equals("C")) {
						grade = "직원";
					}
					System.out.print(grade + "\t");
					System.out.println(vo.getTotcost() + "\t");
				}
			} else if (sel.equals("4")) {
				System.out.println("프로그램종료");
				flag = false;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
