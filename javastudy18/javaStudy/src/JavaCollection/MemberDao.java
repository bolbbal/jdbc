package JavaCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDao {
	//crud�۾� ó���� �ϱ����� �޼��� ����
	
	ArrayList<MemberVo> list = new ArrayList<MemberVo>(); 
	Scanner sc = new Scanner(System.in);
	int id = 0;
	
	public void insert() {
		System.out.print("�̸� ��ȭ��ȣ �̸��� ����(10 = �̻�, 20 = ����, 30 = ����) : ");
		
		String name = sc.next();
		String tel = sc.next();
		String email = sc.next();
		int code = sc.nextInt();
		int salaly = 0;
		
		MemberVo vo = new MemberVo();
		id++;
		
		vo.setId(id);
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setCode(code);
		salaly = calSalaly(code);
		vo.setSalaly(salaly);
		
		
		list.add(vo);
	}
	
	public void printMember() {
		int acount = 0;
		int bcount = 0;
		int ccount = 0;
		int asalaly = 500;
		int bsalaly = 400;
		int csalaly = 300;
		
		System.out.println("ȸ����ȣ\t�̸�\t��ȭ��ȣ\t�̸���\t����\t�޿�");
		for (MemberVo vo : list) {
			System.out.print(vo.getId() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getTel() + "\t");
			System.out.print(vo.getEmail() + "\t");
			if (vo.getCode() == 10) {
				acount++;
				System.out.print("�̻�" + "\t");
				//System.out.println(vo.getSalaly());
			} else if (vo.getCode() == 20) {
				bcount++;
				System.out.print("����" + "\t");
				//System.out.println(vo.getSalaly());
			} else if (vo.getCode() == 30) {
				ccount++;
				System.out.print("����" + "\t");
				//System.out.println(vo.getSalaly());
			}
			System.out.println(vo.getSalaly() + "\t");
		}
		System.out.println("�̻� �ο� �� : " + acount);
		System.out.println("���� �ο� �� : " + bcount);
		System.out.println("���� �ο� �� : " + ccount + "\n");
		System.out.println("�̻� �� �޿� : " + (acount * asalaly));
		System.out.println("���� �� �޿� : " + (bcount * bsalaly));
		System.out.println("���� �� �޿� : " + (ccount * csalaly));
	}
	
	public void memberDelete() {
		System.out.print("������ ��ȣ�� �Է��ϼ��� >> ");
		int id = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				System.out.println("�ش� �����͸� �����߽��ϴ�.");
				return;
			}
		}
		System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�.");
//		for (MemberVo vo : list) {
//			if(vo.getId() == id) {
//				list.remove(index);
//			}
//		}
	}
	
	public void memberModify() {
		System.out.print("�����ϰ� ���� ȸ���� ��ȣ�� �Է��ϼ��� >> ");
		int id = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				System.out.println("���� �� ������");
				System.out.print("��ȭ��ȣ : " + list.get(i).getTel());
				System.out.println(", �̸��� : " + list.get(i).getEmail());
				System.out.print("������ ��ȭ �Է� : ");
				String tel = sc.next();
				list.get(i).setTel(tel);
				System.out.print("������ �̸��� �Է� : ");
				String email = sc.next();
				list.get(i).setEmail(email);
				return;
			} 
		}
		System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�.");
	}
	
	public void memberSelect() {
		System.out.print("�˻��ϰ� ���� ȸ���� ��ȣ�� �Է��ϼ��� >> ");
		int id = sc.nextInt();
		System.out.println("ȸ����ȣ\t�̸�\t��ȭ��ȣ\t�̸���");
		for (MemberVo vo : list) {
			if (vo.getId() == id) {
				System.out.print(vo.getId() + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getTel() + "\t");
				System.out.println(vo.getEmail() + "\t");
				return;
			}
		}
		System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�.");
	}
	
	public int calSalaly(int code) {
		int salaly = 0;
		if (code == 10) {
			salaly = 500;
		} else if (code == 20) {
			salaly = 400;
		} else if (code == 30) {
			salaly = 300;
		}
		return salaly;
		
	}
}
