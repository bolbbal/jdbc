package javaJDBCTest;
import java.util.*;
import java.sql.*;

public class DBmanager {
	private static DBmanager instance = new DBmanager();
	private DBmanager() {}
	
	public static DBmanager getInstance() {
		return instance;
	}
	
	public Connection DBconn() {
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jsl18";
		String pw = "1234";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
