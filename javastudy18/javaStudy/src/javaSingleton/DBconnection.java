package javaSingleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	private static DBconnection instance = new DBconnection();
	private DBconnection() {}
	
	public static DBconnection getInstance() {
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

class test {
	public static void main(String[] args) {
		Connection conn = DBconnection.getInstance().getDBmanager();
		if(conn != null) {
			System.out.println("o");
		} else {
			System.out.println("x2");
		}
	}
}
























