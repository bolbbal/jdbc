package javaJDBCjoin;

import java.util.*;

public class JoinMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		List<JoinVo> list = new ArrayList<JoinVo>();
		JoinDao dao = new JoinDao();
		while(flag) {
			System.out.println("[1]3���� ���̺� ���� �˻�[0]����");
			System.out.print("�۾� ���� >> ");
			int sel = sc.nextInt();
			if(sel == 0) {
				System.out.println("���α׷� ����");
				flag = false;
				break;
			} else if(sel == 1) {
				list = dao.getJoin();
				System.out.println("�����\t��å\t����\t���");
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
