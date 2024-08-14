package javaJDBCsubquery;

import java.sql.*;
import java.util.*;

public class SubQueryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SubDao dao = new SubDao();
		
		boolean flag = true;
		
		while(flag) {
			System.out.print("[1]�˻�[2]���� >> ");
			String menu = sc.next();
			
			if (menu.equals("1")) {
				List<SubVo> list = new ArrayList<SubVo>();
				list = dao.selectNotM(list);
				
				System.out.println("��� �޿����� ���� �ް� �̸��� M�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿�");
				System.out.println("�����ȣ\t�̸�\t�޿�");
				
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
				System.out.println("���α׷� ����");
				flag = false;
				break;
			} else {
				System.out.println("�߸��� �Է�");
				return;
			}
		}
	}

}