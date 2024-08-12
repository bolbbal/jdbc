package JavaCalendar;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDateCalendar {

	public static void main(String[] args) {
		// 날짜
		// Date : 날짜와 시간 정보를 저장하는 클래스
		// Calendar : 운영체제의 날씨와 시간을 얻을 때 사용
		
		// Date 클래스는 객체 생성 가능
		// Calendar 클래스는 객체 생성 불가능. getInstance() 메서드를 이용하여 OS에서 설정된 시간대를 기준으로 하위 객체를 사용 가능
		Date now = new Date();
		
		String now1 = now.toString();
		System.out.println(now1);
		
		// 년 월 일로 출력 형식 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String now2 = sdf.format(now);
		System.out.println(now2);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf2.format(now));
		
		Calendar now3 = Calendar.getInstance();
		int year = now3.get(Calendar.YEAR); //년도를 리턴
		int month = now3.get(Calendar.MONTH)+1; //월을 리턴. 월은 0부터 시작하기 때문에 +1
		int day = now3.get(Calendar.DAY_OF_MONTH); //일 리턴
		int week = now3.get(Calendar.DAY_OF_WEEK);
		int amPm = now3.get(Calendar.AM_PM);
		int hour = now3.get(Calendar.HOUR);
		int minute = now3.get(Calendar.MINUTE);
		int second = now3.get(Calendar.SECOND);
		
		if(week == Calendar.MONDAY) {
			System.out.println("월요일");	
		} else if(week == Calendar.TUESDAY) {
			System.out.println("화요일");
		} else if(week == Calendar.WEDNESDAY) {
			System.out.println("수요일");
		} else if(week == Calendar.THURSDAY) {
			System.out.println("목요일");
		} else if(week == Calendar.FRIDAY) {
			System.out.println("금요일");
		} else if(week == Calendar.SATURDAY) {
			System.out.println("토요일");
		} else if(week == Calendar.SUNDAY) {
			System.out.println("일요일");
		}
		
		if(amPm == Calendar.PM) {
			System.out.println("오후");
		}
	}

}
