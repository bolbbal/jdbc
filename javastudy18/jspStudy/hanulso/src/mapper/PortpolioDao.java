package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.PortpolioVo;
import util.DBManager;

public class PortpolioDao {
	
	private static PortpolioDao instance = new PortpolioDao();
	private PortpolioDao() {
		
	}
	
	public static PortpolioDao getInstance() {
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
	
	public List<PortpolioVo> portpolioView() {
		
		String sql = "select * from (select /*+ index_desc (portpolio portpolio_pk)*/ "
				+ "rownum rn, idx, regdate, title, content, writer, viewcount, imgurl "
				+ "from notice "
				+ "where rn <= (? * ?)) "
				+ "where rn > ((? - 1) * ?)";
		
		List<PortpolioVo> list = new ArrayList<PortpolioVo>();
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	
}
