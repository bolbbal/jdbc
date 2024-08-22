package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShopDao {
	
	public void insertMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member_tbl_02 values (?,?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			ShopVo vo = new ShopVo();
			int custno = getCustno();
			
			pstmt.setInt(1, custno);
			pstmt.setString(2, vo.getCustname());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getJoindate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getCity());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getCustno() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select max(custno) + 1 as custno from member_tbl_02";
		
		int custno = 0;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				custno = rs.getInt("custno");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return custno;
	}
	
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		date.toString();
		String joindate = sdf.format(date);
		
		
		return joindate;
	}
}
