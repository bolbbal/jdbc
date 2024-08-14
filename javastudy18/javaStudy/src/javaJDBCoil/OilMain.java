package javaJDBCoil;

import java.sql.*;
import java.util.*;

public class OilMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		OilDao dao = new OilDao();
		
		
		while(flag) {
			System.out.println("[1]��ü������ȸ[2]�� �������[3]��ü������ȸ_sql����[4]�� �������_sql����[0]����");
			System.out.print("�۾� ���� >> ");
			String sel = sc.next();
			if (sel.equals("0")) {
				System.out.println("���α׷� ����");
				flag = false;
				break;
			} else if (sel.equals("1")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectAllSale(list);
				int sum = 0;
				System.out.println("\t\t\t\t\t��ü������ȸ");
				System.out.println("�����ȣ\t��������\t\t����\t������\t�������\tȸ������\tȸ����ȣ\t��ȭ��ȣ\t\tī���ȣ\t\t\t�ݾ�");
				for(OilVo vo : list) {
					System.out.print(vo.getSaleno() + "\t");
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getAmount() + "\t");
					System.out.print(vo.getPaytype() + "\t");
					System.out.print(vo.getCustname() + "\t");
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getTel() + "\t");
					System.out.print(vo.getCreditcart() + "\t��");
					System.out.print(vo.getOilcost() + "\t");
					sum += vo.getOilcost();
					System.out.println();
				}
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t�����Ѿ�\t\t��" + sum);
			} else if (sel.equals("2")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectDailySale(list);
				System.out.println("\t\t�ϸ������");
				System.out.println("��������\t\t����\t�Ǽ�\t�ݾ�");
				for(OilVo vo : list) {
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getCount() + "��\t��");
					System.out.print(vo.getTot() + "\t");
					System.out.println();
				}
			} else if (sel.equals("3")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectAllSale_modify(list);
				int sum = 0;
				System.out.println("\t\t\t\t\t��ü������ȸ");
				System.out.println("�����ȣ\t��������\t\t����\t������\t�������\tȸ������\tȸ����ȣ\t��ȭ��ȣ\t\tī���ȣ\t\t\t�ݾ�");
				for(OilVo vo : list) {
					System.out.print(vo.getSaleno() + "\t");
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getAmount() + "\t");
					System.out.print(vo.getPaytype() + "\t");
					System.out.print(vo.getCustname() + "\t");
					System.out.print(vo.getCustno() + "\t");
					System.out.print(vo.getTel() + "\t");
					System.out.print(vo.getCreditcart() + "\t��");
					System.out.print(vo.getOilcost() + "\t");
					sum += vo.getOilcost();
					System.out.println();
				}
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t�����Ѿ�\t\t��" + sum);
			} else if (sel.equals("4")) {
				List<OilVo> list = new ArrayList<OilVo>();
				list = dao.selectDailySale(list);
				System.out.println("\t\t�ϸ������");
				System.out.println("��������\t\t����\t�Ǽ�\t�ݾ�");
				for(OilVo vo : list) {
					System.out.print(vo.getOildate() + "\t");
					System.out.print(vo.getOilname() + "\t");
					System.out.print(vo.getCount() + "��\t��");
					System.out.print(vo.getTot() + "\t");
					System.out.println();
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

}