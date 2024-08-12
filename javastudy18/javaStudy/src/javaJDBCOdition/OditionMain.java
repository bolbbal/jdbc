package javaJDBCOdition;

import java.util.*;
import java.sql.*;

public class OditionMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		OditionDao dao = new OditionDao();
		while(flag) {
			System.out.print("작업선택 : [1]오디션등록[2]참가자 목록 조회[3]멘토 점수 목록 조회[4]참가자 등수 조회[5]종료 ");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("오디션 등록 실행");
				dao.insertOdition();
			} else if (sel == 2) {
				System.out.println("참가자 목록 조회 실행");
				dao.selectArtist();
			} else if (sel == 3) {
				System.out.println("멘토 점수 목록 조회 실행");
				dao.selectMentoPoint();
			} else if (sel == 4) {
				System.out.println("참가자 등수 조회 실행");
				dao.selectArtistRank();
			} else if (sel == 5) {
				System.out.println("작업 종료");
				flag = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				return;
			}
		}
	}

}
