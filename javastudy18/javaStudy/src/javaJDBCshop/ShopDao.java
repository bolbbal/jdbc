package javaJDBCshop;

import java.sql.*;
import java.util.*;

public class ShopDao {
	public void insertMember(ShopVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member_tbl_02 values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustno());
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
	
	public int getAuto() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select max(custno)+1 as custno\r\n" + 
				"from member_tbl_02";
		int custno = 0;
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ShopVo vo = new ShopVo();
				vo.setCustno(rs.getInt("custno"));
				custno = vo.getCustno();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return custno;
	}
	
	public List<ShopVo> selectMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopVo> list = new ArrayList<ShopVo>();
		String sql = "select *\r\n" + 
				"from member_tbl_02\r\n" + 
				"order by custno";

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ShopVo vo = new ShopVo();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getString("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<ShopVo> selectMemberTotCost() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopVo> list = new ArrayList<ShopVo>();
		String sql = "select mem.custno, mem.custname, mem.grade, sum(mon.price) as totcost\r\n" + 
				"from member_tbl_02 mem, money_tbl_02 mon\r\n" + 
				"where mem.custno = mon.custno\r\n" + 
				"group by mem.custno, mem.custname, mem.grade\r\n" + 
				"order by sum(mon.price) desc";

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ShopVo vo = new ShopVo();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setTotcost(rs.getInt("totcost"));
				
				list.add(vo);
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
