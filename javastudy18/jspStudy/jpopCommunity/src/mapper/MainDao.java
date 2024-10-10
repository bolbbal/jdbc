package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainDao {
	
	private static MainDao instance = new MainDao();
	private MainDao() {}
	
	public static MainDao getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	protected void close() {
		try {
			
			if(rs!=null) {
				rs.close();
			}
			
			if(pstmt!=null) {
				pstmt.close();
			}
			
			if(conn!=null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Object> getPoplarPost() {
		
		String sql = "select /*+ index_";
		List<Object> list = new ArrayList<Object>();
		return list;
	}
}
