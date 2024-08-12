package JavaCalendar;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDateCalendar {

	public static void main(String[] args) {
		// ��¥
		// Date : ��¥�� �ð� ������ �����ϴ� Ŭ����
		// Calendar : �ü���� ������ �ð��� ���� �� ���
		
		// Date Ŭ������ ��ü ���� ����
		// Calendar Ŭ������ ��ü ���� �Ұ���. getInstance() �޼��带 �̿��Ͽ� OS���� ������ �ð��븦 �������� ���� ��ü�� ��� ����
		Date now = new Date();
		
		String now1 = now.toString();
		System.out.println(now1);
		
		// �� �� �Ϸ� ��� ���� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ss��");
		String now2 = sdf.format(now);
		System.out.println(now2);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf2.format(now));
		
		Calendar now3 = Calendar.getInstance();
		int year = now3.get(Calendar.YEAR); //�⵵�� ����
		int month = now3.get(Calendar.MONTH)+1; //���� ����. ���� 0���� �����ϱ� ������ +1
		int day = now3.get(Calendar.DAY_OF_MONTH); //�� ����
		int week = now3.get(Calendar.DAY_OF_WEEK);
		int amPm = now3.get(Calendar.AM_PM);
		int hour = now3.get(Calendar.HOUR);
		int minute = now3.get(Calendar.MINUTE);
		int second = now3.get(Calendar.SECOND);
		
		if(week == Calendar.MONDAY) {
			System.out.println("������");	
		} else if(week == Calendar.TUESDAY) {
			System.out.println("ȭ����");
		} else if(week == Calendar.WEDNESDAY) {
			System.out.println("������");
		} else if(week == Calendar.THURSDAY) {
			System.out.println("�����");
		} else if(week == Calendar.FRIDAY) {
			System.out.println("�ݿ���");
		} else if(week == Calendar.SATURDAY) {
			System.out.println("�����");
		} else if(week == Calendar.SUNDAY) {
			System.out.println("�Ͽ���");
		}
		
		if(amPm == Calendar.PM) {
			System.out.println("����");
		}
	}

}
