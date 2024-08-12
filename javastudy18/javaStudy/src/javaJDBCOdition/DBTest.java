package javaJDBCOdition;

import java.sql.Connection;

public class DBTest {
	public static void main(String[] args) {
		Connection conn = DBManager.getInstance().getDBmanager();
		if (conn!=null) {
			System.out.println("o");
		}
	}
}
