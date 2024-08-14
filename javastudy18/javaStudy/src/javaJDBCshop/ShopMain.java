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
			System.out.println("[1]ȸ�����[2]ȸ����� ��ȸ[3]ȸ��������ȸ[4]����");
			System.out.print("�۾� ���� >> ");
			String sel = sc.next();

			if (sel.equals("1")) {
				ShopVo vo = new ShopVo();
				int custno = dao.getAuto();
				System.out.println("Ȩ���� ȸ�� ���");
				System.out.println("ȸ����ȣ(�ڵ��߻�) : " + custno);
				vo.setCustno(custno);
				
				System.out.print("ȸ������ : ");
				String custname = sc.next();
				vo.setCustname(custname);
				
				System.out.print("ȸ����ȭ : ");
				String phone = sc.next();
				vo.setPhone(phone);
				
				System.out.print("ȸ���ּ� : ");
				String address = sc.next();
				vo.setAddress(address);
				
				System.out.println("�������� : " + now1);
				vo.setJoindate(now1);
				
				System.out.print("�������[A:VIP,B:�Ϲ�,C:����] : ");
				String grade = sc.next();
				vo.setGrade(grade);
				
				System.out.print("�����ڵ� : ");
				String city = sc.next();
				vo.setCity(city);
				
				System.out.print("��� ����[y/n] : ");
				String agree = sc.next();
				
				if (agree.equalsIgnoreCase("y")) {
					dao.insertMember(vo);
				} else if (agree.equalsIgnoreCase("n")) {
					return;
				}

			} else if (sel.equals("2")) {
				List<ShopVo> list = dao.selectMember();
				
				System.out.println("\t\t\tȸ�������ȸ/����");
				System.out.println("ȸ����ȣ\tȸ������\t��ȭ��ȣ\t\t�ּ�\t\t��������\t\t�������\t��������");
				
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
						grade = "�Ϲ�";
					} else if (vo.getGrade().equals("C")) {
						grade = "����";
					}
					
					System.out.print(grade + "\t");
					System.out.println(vo.getCity() + "\t");
				}
			} else if (sel.equals("3")) {
				List<ShopVo> list = dao.selectMemberTotCost();
				System.out.println("\tȸ��������ȸ");
				System.out.println("ȸ����ȣ\tȸ������\t�������\t����");
				for (ShopVo vo : list) {
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getCustname() + "\t");
					String grade = null;
					if (vo.getGrade().equals("A")) {
						grade = "VIP";
					} else if (vo.getGrade().equals("B")) {
						grade = "�Ϲ�";
					} else if (vo.getGrade().equals("C")) {
						grade = "����";
					}
					System.out.print(grade + "\t");
					System.out.println(vo.getTotcost() + "\t");
				}
			} else if (sel.equals("4")) {
				System.out.println("���α׷�����");
				flag = false;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

}