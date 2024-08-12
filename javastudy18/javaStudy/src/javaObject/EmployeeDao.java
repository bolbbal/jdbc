package javaObject;

import java.text.DecimalFormat;

public class EmployeeDao {
	//�޼���
	public void title() {
		System.out.println("\t\t\t��������ȸ");
		System.out.println("�����ȣ\t�����\t�μ�\t����\t�⺻��\t\t�ٹ���\t����\t�Ի���");
	}
	
	public void getList(Employee[] emp) {//������ ���
		DecimalFormat df = new DecimalFormat("#,###");
		
		for(int i = 0; i < emp.length; i++) {
			int salary = 0;
			String departPrint = null;
			if(emp[i].depart.equals("01")) {
				departPrint = "�λ�";
			} else if(emp[i].depart.equals("02")) {
				departPrint = "�ѹ�";
			} else if(emp[i].depart.equals("03")) {
				departPrint = "����";
			}else if(emp[i].depart.equals("04")) {
				departPrint = "����";
			}
			String levelPrint = null;
			if(emp[i].level.equals("10")) {
				levelPrint = "�̻�";
				salary = 4500000;
			} else if(emp[i].level.equals("20")) {
				levelPrint = "����";
				salary = 3500000;
			} else if(emp[i].level.equals("30")) {
				levelPrint = "����";
				salary = 3000000;
			} else if(emp[i].level.equals("40")) {
				levelPrint = "�븮";
				salary = 2500000;
			} else if(emp[i].level.equals("50")) {
				levelPrint = "���";
				salary = 2000000;
			}
			System.out.println(emp[i].no + "\t" + emp[i].name + "\t" + departPrint + "\t" + levelPrint + "\t" + df.format(salary) +"\t" + emp[i].workspace + "\t" + emp[i].performance + "\t" + emp[i].joindate);
		}
		
	}
}
