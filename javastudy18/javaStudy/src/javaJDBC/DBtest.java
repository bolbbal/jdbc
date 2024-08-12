package javaJDBC;

import java.sql.*;

public class DBtest {

	public static void main(String[] args) {
		//JDBC 연동하여 CRUD 작업 처리
		Connection conn = DBmanager.getInstance().getDBmanager();
		if (conn != null) {
			System.out.println("DB연결 성공");
		} else {
			System.out.println("DB연결 실패");
		}
	}

}