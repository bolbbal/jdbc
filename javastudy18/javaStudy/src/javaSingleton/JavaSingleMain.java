package javaSingleton;

import java.sql.Connection;
import java.sql.DriverManager;

class DBmanager {
	// oracle db 접속 => Connection
	
	//싱글톤 패턴
	private static DBmanager instance = new DBmanager();
	
	private DBmanager() {};
	
	public static DBmanager getInstance() {
		return instance;
	}
	
	//DB접속하는 메서드
	public Connection getDBmanager() {
		//DB에 접속정보를 담는 객체
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jsl18";
		String pw = "1234";
		
		//예외처리
		try {
			Class.forName(driver); //드라이버 로딩
			conn = DriverManager.getConnection(url, id, pw); //DB 접속
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}


class DBmanager1 {
	//싱글톤
	//db접속 메서드
	private static DBmanager1 instance = new DBmanager1();
	private DBmanager1() {}
	
	public static DBmanager1 getInstance() {
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

class DBmanager2 {
	private static DBmanager2 instance = new DBmanager2();
	private DBmanager2() {}
	public static DBmanager2 getInstance() {
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

class DBmanager3 {
	private static DBmanager3 instance = new DBmanager3();
	private DBmanager3() {}
	public static DBmanager3 getInstance() {
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

class DBmanager4 {
	private static DBmanager4 instance = new DBmanager4();
	private DBmanager4() {}
	
	public static DBmanager4 getInstance() {
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
			conn = DriverManager.getConnection(url,id,pw);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

class DBmanager5 {
	private static DBmanager5 instance = new DBmanager5();
	private DBmanager5() {}
	public static DBmanager5 getInstance() {
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

class DBmanager6 {
	private static DBmanager6 instance = new DBmanager6();
	private DBmanager6() {}
	public static DBmanager6 getInstance() {
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
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}

class DBmanager7 {
	private static DBmanager7 instance = new DBmanager7();
	private DBmanager7() {}
	
	public static DBmanager7 getInstance() {
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
public class JavaSingleMain {

	public static void main(String[] args) {
		// 싱글톤(singleton)
		// 하나의 애플리케이션에서 오로지 단 하나만 생성되는 객체(인스턴스)
		// 사용자 환경설정, 커넥션 풀, 사용자 정보 로딩 등에 사용된다.
			
		// DB접속
//		DBmanager db = DBmanager.getInstance();
//		Connection conn = db.getConnection();
		Connection conn = DBmanager.getInstance().getDBmanager();
		if(conn != null) {
			System.out.println("DB1 접속 완료");
		} else {
			System.out.println("DB1 접속 실패");
		}
		
		Connection conn1 = DBmanager1.getInstance().getDBmanager();
		if(conn1 != null) {
			System.out.println("DB2 접속 완료");
		} else {
			System.out.println("DB2 접속 실패");
		}
		
		Connection conn2 = DBmanager2.getInstance().getDBmanager();
		if(conn2 != null) {
			System.out.println("DB3 접속 완료");
		} else {
			System.out.println("DB3 접속 실패");
		}
		
		Connection conn3 = DBmanager3.getInstance().getDBmanager();
		if(conn3 != null) {
			System.out.println("DB4 접속 완료");
		} else {
			System.out.println("DB5 접속 실패");
		}
		
		Connection conn4 = DBmanager4.getInstance().getDBmanager();
		if(conn4 != null) {
			System.out.println("DB5 접속 완료");
		} else {
			System.out.println("DB5 접속 실패");
		}
		
		Connection conn5 = DBmanager5.getInstance().getDBmanager();
		if(conn5 != null) {
			System.out.println("DB6 접속 완료");
		} else {
			System.out.println("DB6 접속 실패");
		}
		
		Connection conn6 = DBmanager6.getInstance().getDBmanager();
		if(conn6 != null) {
			System.out.println("DB7 접속 완료");
		} else {
			System.out.println("DB7 접속 실패");
		}
		
		Connection conn7 = DBmanager7.getInstance().getDBmanager();
		if(conn7 != null) {
			System.out.println("DB8 접속 완료");
		} else {
			System.out.println("DB8 접속 실패");
		}
		
		
		
		
		
		
		
		
		
		
		
	}	

}








