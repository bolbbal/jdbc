package JavaCalendar;

import java.util.Calendar;

public class CalendarApi {
	
	public void prn(int year, int month) {
		Calendar cal = Calendar.getInstance();
		System.out.printf("\t\t%d�� %d�� \n", year, month);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		cal.set(year, month-1, 1); //set -> Calendar ����
		int start = cal.get(Calendar.DAY_OF_WEEK); //����
		for (int i = 1; i < start; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			//getActualMaximum() ���� ������ ��¥
			System.out.printf("%d\t", i);
			if (start % 7 == 0) {
				System.out.println();
			}
			start++; //���� ��(1) ~ ��(7)
		}
	}
}
