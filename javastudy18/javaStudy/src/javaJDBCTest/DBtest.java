package javaJDBCTest;

import java.sql.Connection;

public class DBtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBmanager.getInstance().DBconn();
		
	}

}
