package javaSingleton;

import java.sql.Connection;
import java.sql.DriverManager;

class DBmanager {
	// oracle db ���� => Connection
	
	//�̱��� ����
	private static DBmanager instance = new DBmanager();
	
	private DBmanager() {};
	
	public static DBmanager getInstance() {
		return instance;
	}
	
	//DB�����ϴ� �޼���
	public Connection getDBmanager() {
		//DB�� ���������� ��� ��ü
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jsl18";
		String pw = "1234";
		
		//����ó��
		try {
			Class.forName(driver); //����̹� �ε�
			conn = DriverManager.getConnection(url, id, pw); //DB ����
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}


class DBmanager1 {
	//�̱���
	//db���� �޼���
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
		// �̱���(singleton)
		// �ϳ��� ���ø����̼ǿ��� ������ �� �ϳ��� �����Ǵ� ��ü(�ν��Ͻ�)
		// ����� ȯ�漳��, Ŀ�ؼ� Ǯ, ����� ���� �ε� � ���ȴ�.
			
		// DB����
//		DBmanager db = DBmanager.getInstance();
//		Connection conn = db.getConnection();
		Connection conn = DBmanager.getInstance().getDBmanager();
		if(conn != null) {
			System.out.println("DB1 ���� �Ϸ�");
		} else {
			System.out.println("DB1 ���� ����");
		}
		
		Connection conn1 = DBmanager1.getInstance().getDBmanager();
		if(conn1 != null) {
			System.out.println("DB2 ���� �Ϸ�");
		} else {
			System.out.println("DB2 ���� ����");
		}
		
		Connection conn2 = DBmanager2.getInstance().getDBmanager();
		if(conn2 != null) {
			System.out.println("DB3 ���� �Ϸ�");
		} else {
			System.out.println("DB3 ���� ����");
		}
		
		Connection conn3 = DBmanager3.getInstance().getDBmanager();
		if(conn3 != null) {
			System.out.println("DB4 ���� �Ϸ�");
		} else {
			System.out.println("DB5 ���� ����");
		}
		
		Connection conn4 = DBmanager4.getInstance().getDBmanager();
		if(conn4 != null) {
			System.out.println("DB5 ���� �Ϸ�");
		} else {
			System.out.println("DB5 ���� ����");
		}
		
		Connection conn5 = DBmanager5.getInstance().getDBmanager();
		if(conn5 != null) {
			System.out.println("DB6 ���� �Ϸ�");
		} else {
			System.out.println("DB6 ���� ����");
		}
		
		Connection conn6 = DBmanager6.getInstance().getDBmanager();
		if(conn6 != null) {
			System.out.println("DB7 ���� �Ϸ�");
		} else {
			System.out.println("DB7 ���� ����");
		}
		
		Connection conn7 = DBmanager7.getInstance().getDBmanager();
		if(conn7 != null) {
			System.out.println("DB8 ���� �Ϸ�");
		} else {
			System.out.println("DB8 ���� ����");
		}
		
		
		
		
		
		
		
		
		
		
		
	}	

}








