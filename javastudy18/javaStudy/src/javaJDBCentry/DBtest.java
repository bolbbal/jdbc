package javaJDBCentry;

import java.sql.Connection;

public class DBtest {
	public static void main(String[] args) {
		Connection conn = DBManager.getInstance().getDBManger();
		if(conn != null) {
			System.out.println("o");
		}
	}
}
