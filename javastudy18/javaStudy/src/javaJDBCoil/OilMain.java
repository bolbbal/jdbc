package javaJDBCoil;

import java.sql.*;
import java.util.*;

public class OilMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		OilDao dao = new OilDao();
		
		
		while(flag) {
			System.out.println("[1]전체매출조회[2]일 매출통계[3]전체매출조회_sql수정[4]일 매출통계_sql수정[0]종료");
			System.out.print("작업 선택 >> ");
			String sel = sc.next();
			if (sel.equals("0")) {
				System.out.println("프로그램 종료");
				flag = false;
				break;
			} else if (sel.equals("1")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectAllSale(list);
				int sum = 0;
				System.out.println("\t\t\t\t\t전체매출조회");
				System.out.println("매출번호\t주유일자\t\t유종\t주유량\t결제방법\t회원성명\t회원번호\t전화번호\t\t카드번호\t\t\t금액");
				for(OilVo vo : list) {
					System.out.print(vo.getSaleno() + "\t");
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getAmount() + "\t");
					System.out.print(vo.getPaytype() + "\t");
					System.out.print(vo.getCustname() + "\t");
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getTel() + "\t");
					System.out.print(vo.getCreditcart() + "\t￦");
					System.out.print(vo.getOilcost() + "\t");
					sum += vo.getOilcost();
					System.out.println();
				}
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t매출총액\t\t￦" + sum);
			} else if (sel.equals("2")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectDailySale(list);
				System.out.println("\t\t일매출통계");
				System.out.println("주유일자\t\t유종\t건수\t금액");
				for(OilVo vo : list) {
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getCount() + "건\t￦");
					System.out.print(vo.getTot() + "\t");
					System.out.println();
				}
			} else if (sel.equals("3")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectAllSale_modify(list);
				int sum = 0;
				System.out.println("\t\t\t\t\t전체매출조회");
				System.out.println("매출번호\t주유일자\t\t유종\t주유량\t결제방법\t회원성명\t회원번호\t전화번호\t\t카드번호\t\t\t금액");
				for(OilVo vo : list) {
					System.out.print(vo.getSaleno() + "\t");
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getAmount() + "\t");
					System.out.print(vo.getPaytype() + "\t");
					System.out.print(vo.getCustname() + "\t");
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getTel() + "\t");
					System.out.print(vo.getCreditcart() + "\t￦");
					System.out.print(vo.getOilcost() + "\t");
					sum += vo.getOilcost();
					System.out.println();
				}
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t매출총액\t\t￦" + sum);
			} else if (sel.equals("4")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectDailySale(list);
				System.out.println("\t\t일매출통계");
				System.out.println("주유일자\t\t유종\t건수\t금액");
				for(OilVo vo : list) {
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getCount() + "건\t￦");
					System.out.print(vo.getTot() + "\t");
					System.out.println();
				}
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
