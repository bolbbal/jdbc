package javaBasic;

import java.util.Scanner;

public class Java25_switch {
	public static void main(String[] args) {
		//키보드로 자동차번호(4자리), 주차시간(분)을 입력받아서
		//주차요금을 계산하여 출력하시오
		//[입력]
		//자동차번호(4자리), 주차시간(분) 입력 : 3810 42
		//[출력]
		//자동차번호 : 3810
		//주차요금 : 1500원
		//처리조건
		//주차요금 10분 미만은 무료, 30분 까지는 500원, 30분 이후부터는 10분당 500원씩 계싼
		//만약 주차시간이 42분인 경우 주차요금은 1500원이 된다
		//하루 주차 요금은 최대 30,000원으로 계산하며, 30,000원을 초과하더라도 30,000원만 징수한다.
		
		Scanner sc = new Scanner(System.in); // crtl + shift + o 누르면 import안된게 됨
		
		String carNo; //차량번호
		int time; //주차시간
		int parkingFee = 0; //주차 요금
		
		System.out.println("[입력]");
		System.out.print("자동차번호(4자리), 주차시간(분) 입력 : ");
		carNo = sc.next();
		time = sc.nextInt();
		
		if(time < 10) {
			parkingFee = 0;
		} else if (10 <= time && time < 30) {
			parkingFee = 500;
		} else {
			parkingFee = (500 * ((time-10)/10));
		}
		
//		switch(time/10) {
//		case 0:
//			parkingFee = 0;
//			break;
//		case 1: case 2: 
//			parkingFee = 500;
//			break;
//		case 3: case 4:
//			if(time%10 > 0) {
//				parkingFee = (500 * ((time/10)-1));
//			}
//			
//			
//			break;
//		
//		}
		
		if(parkingFee > 30000) {
			parkingFee = 30000;
		}
		
		System.out.println("자동차번호 : " + carNo);
		System.out.println("주차요금 : " + parkingFee + "원");
	} 
}
