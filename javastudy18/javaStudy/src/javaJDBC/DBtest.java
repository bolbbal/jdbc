package javaJDBC;

import java.sql.*;

public class DBtest {

	public static void main(String[] args) {
		//JDBC �����Ͽ� CRUD �۾� ó��
		Connection conn = DBmanager.getInstance().getDBmanager();
		if (conn != null) {
			System.out.println("DB���� ����");
		} else {
			System.out.println("DB���� ����");
		}
	}

}