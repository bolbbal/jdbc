package UsedCar;

import java.sql.*;

public class DBManager {
	private static DBManager instance = new DBManager();

	private DBManager() {

	}

	public static DBManager getInstance() {
		return instance;
	}

	public Connection getDBManager() {
		Connection conn = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "usedcar";
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
