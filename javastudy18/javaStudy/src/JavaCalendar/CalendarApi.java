package JavaCalendar;

import java.util.Calendar;

public class CalendarApi {
	
	public void prn(int year, int month) {
		Calendar cal = Calendar.getInstance();
		System.out.printf("\t\t%d년 %d월 \n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		cal.set(year, month-1, 1); //set -> Calendar 세팅
		int start = cal.get(Calendar.DAY_OF_WEEK); //요일
		for (int i = 1; i < start; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			//getActualMaximum() 월의 마지막 날짜
			System.out.printf("%d\t", i);
			if (start % 7 == 0) {
				System.out.println();
			}
			start++; //요일 일(1) ~ 토(7)
		}
	}
}
