package JavaCalendar;

import java.util.Scanner;

public class YmCalendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		CalendarApi cal = new CalendarApi();
		cal.prn(year, month);
	}

}
