package javaJDBCemp;
import java.util.*;
import java.sql.*;

public class EmpMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		EmpDao dao = new EmpDao();
		while(flag) {
			System.out.println("[1]�������[2]�μ�,������ �޿��Ѿ����[3]�μ��� �ִ� �޿�[4]�̸� �˻�[5][0]����");
			System.out.print("�۾� ���� >> ");
			int sel = sc.nextInt();
			
			if (sel == 0) {
				System.out.println("���α׷� ����");
				flag = false;
				break;
			}
			else if (sel == 1) {
				List<EmpVo> list = dao.getEmpSelect();
				System.out.println("��ȣ\t�̸�\t����\t\t�Ŵ���\t�Ի���\t����\t���ʽ�\t�ٹ���");
				for (EmpVo vo : list) {
					System.out.print(vo.getEno() + "\t");
					System.out.print(vo.getEname() + "\t");
					System.out.print(vo.getJob() + "\t\t");
					System.out.print(vo.getManager() + "\t");
					String hiredate = vo.getHiredate().substring(2,4)+"-"+vo.getHiredate().substring(5,7)+"-"+vo.getHiredate().substring(8,10);
					System.out.print(hiredate + "\t");
					System.out.print(vo.getSalary() + "\t");
					System.out.print(vo.getCommission() + "\t");
					System.out.print(vo.getDno() + "\t");
					System.out.println();
				}
			} else if (sel == 2) {
				List<EmpVo> list = dao.getAverage();
				System.out.println("�μ�\t����\t��\t�޿��Ѿ�\t�޿����");
				for(EmpVo vo : list) {
					System.out.print(vo.getDno() + "\t");
					System.out.print(vo.getJob() + "\t");
					System.out.print(vo.getJobtot() + "\t");
					System.out.print(vo.getSaltot() + "\t");
					System.out.print(vo.getSalave() + "\t");
					System.out.println();
				}
			} else if (sel == 3) {
				List<EmpVo> list = dao.getHaving();
				System.out.println("�μ�\t�ִ밪");
				for(EmpVo vo : list) {
					System.out.print(vo.getDno() + "\t");
					System.out.print(vo.getMaxsal() + "\t");
					System.out.println();
				}
			} else if (sel == 4) {
				System.out.print("�˻��ϰ� ���� �̸� �Է� >> ");
				String ename = sc.next();
				EmpVo vo = dao.getSearchName(ename);
				System.out.println("��ȣ\t�̸�\t����\t\t�Ŵ���\t�Ի���\t����\t���ʽ�\t�ٹ���");
				System.out.print(vo.getEno() + "\t");
				System.out.print(vo.getEname() + "\t");
				System.out.print(vo.getJob() + "\t\t");
				System.out.print(vo.getManager() + "\t");
				String hiredate = vo.getHiredate().substring(2,4)+"-"+vo.getHiredate().substring(5,7)+"-"+vo.getHiredate().substring(8,10);
				System.out.print(hiredate + "\t");
				System.out.print(vo.getSalary() + "\t");
				System.out.print(vo.getCommission() + "\t");
				System.out.print(vo.getDno() + "\t");
				System.out.println();
				
			}
		}
	}

}
