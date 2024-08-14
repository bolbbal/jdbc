package javaJDBCjoin;
import java.sql.*;
import java.util.*;

public class DBManager {
	private static DBManager instance = new DBManager();
	private DBManager() {}
	public static DBManager getInstance() {
		return instance;
	}
	
	public Connection getDBmanager() {
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