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
			System.out.println("[1]��������ȸ[2]����޿���ȸ[3]�μ����޿���ȸ[4]�������޿���ȸ[5]����");
			System.out.print("�۾� ���� >> ");
			String sel = sc.next();
			if(sel.equals("1")) {
				list = dao.selectEmployeeList(list);
				System.out.println("\t\t\t��������ȸ");
				System.out.println("�����ȣ\t�����\t�μ�\t����\t�ٹ���\t����\t�Ի���");
				for(DepartVo vo : list) {
					System.out.print(vo.getE_no() + "\t");
					System.out.print(vo.getE_name() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.print(vo.getLname() + "\t");
					System.out.print(vo.getWname() + "\t");
					System.out.print(vo.getPerformance() + "���\t");
					System.out.println(vo.getE_join_date().substring(0,4) + "-" + vo.getE_join_date().substring(4,6) + "-" + vo.getE_join_date().substring(6) + "\t");
				}
			} else if(sel.equals("2")) {
				list = dao.selectEmployeeSalary(list);
				System.out.println("\t\t\t����޿���ȸ");
				System.out.println("�����ȣ\t�����\t�μ�\t����\t�ٹ���\t����\t�޿�");
				for(DepartVo vo : list) {
					System.out.print(vo.getE_no() + "\t");
					System.out.print(vo.getE_name() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.print(vo.getLname() + "\t");
					System.out.print(vo.getWname() + "\t");
					System.out.print(vo.getPerformance() + "���\t");
					System.out.println(df.format(vo.getSal()) + "\t");
				}
			} else if(sel.equals("3")) {
				list = dao.selectDepartSalary(list);
				System.out.println("\t\t\t�μ����޿���ȸ");
				System.out.println("�μ��ڵ�\t�μ���\t�ѱ޿�");
				for(DepartVo vo : list) {
					System.out.print(vo.getDepart_code() + "\t");
					System.out.print(vo.getDname() + "\t");
					System.out.println(df.format(vo.getSal()) + "\t");
				}
			} else if(sel.equals("4")) {
				list = dao.selectWorkPlaceSalary(list);
				System.out.println("\t\t\t�������޿���ȸ");
				System.out.println("�����ڵ�\t������\t�ѱ޿�");
				for(DepartVo vo : list) {
					System.out.print(vo.getWork_place() + "\t");
					System.out.print(vo.getWname() + "\t");
					System.out.println(df.format(vo.getSal()) + "\t");
				}
			} else if(sel.equals("5")) {
				System.out.println("�۾� ����");
				flag = false;
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
		}
	}

}