package JavaCalendar;

import java.util.Scanner;

public class YmCalendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		int year = sc.nextInt();
		System.out.print("�� �Է� : ");
		int month = sc.nextInt();
		
		CalendarApi cal = new CalendarApi();
		cal.prn(year, month);
	}

}
