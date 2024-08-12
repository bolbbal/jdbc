package javaObject;

import java.text.DecimalFormat;

public class Employee {
	//�������
	//�����ȣ, �����, �μ��ڵ�, ����, �ٹ���, ����, �Ի���
	//�������
	String no;
	String name;
	String depart;
	String level;
	String workspace;
	String performance;
	String joindate;
	
	int salary;
	
	//������
	public Employee() {
		
	}
	
	public Employee(String no, String name, String depart, String level, String workspace, String performance, String joindate) {
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.level = level;
		this.workspace = workspace;
		this.performance = performance;
		this.joindate = joindate;
	}
	//�޼���
	public void title() {
		System.out.println("\t\t��������ȸ");
		System.out.println("�����ȣ\t�����\t�μ�\t����\t�⺻��\t\t�ٹ���\t����\t�Ի���");
	}
	
	public void getList() {//������ ���
		DecimalFormat df = new DecimalFormat("#,###");
		
		String departPrint = null;
		if(depart.equals("01")) {
			departPrint = "�λ�";
		} else if(depart.equals("02")) {
			departPrint = "�ѹ�";
		} else if(depart.equals("03")) {
			departPrint = "����";
		}else if(depart.equals("04")) {
			departPrint = "����";
		}
		String levelPrint = null;
		if(level.equals("10")) {
			levelPrint = "�̻�";
			salary = 4500000;
		} else if(level.equals("20")) {
			levelPrint = "����";
			salary = 3500000;
		} else if(level.equals("30")) {
			levelPrint = "����";
			salary = 3000000;
		} else if(level.equals("40")) {
			levelPrint = "�븮";
			salary = 2500000;
		} else if(level.equals("50")) {
			levelPrint = "���";
			salary = 2000000;
		}
		System.out.println(no + "\t" + name + "\t" + departPrint + "\t" + levelPrint + "\t" + df.format(salary) +"\t" + workspace + "\t" + performance + "\t" + joindate);
	}
}
