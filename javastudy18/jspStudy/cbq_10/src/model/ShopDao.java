package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ShopDao {

	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				rs.close();
			}
			if (conn != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertMember(ShopVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member_tbl_02 values (?,?,?,?,?,?,?)";

		int custno = getCustnoAuto();
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);

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
		} finally {
			close(conn, pstmt);
		}
	}

	public int getCustnoAuto() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int custno = 0;

		String sql = "select max(custno)+1 as custno from member_tbl_02";

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				custno = rs.getInt("custno");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return custno;

	}
	
	public String getToday() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = null;
		
		date.toString();
		today = sdf.format(date);
		
		return today;
	}
	
	public List<ShopVo> getMemberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member_tbl_02 order by custno";
		
		List<ShopVo> list = new ArrayList<ShopVo>();
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopVo vo = new ShopVo();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setCity(rs.getString("city"));
				vo.setJoindate(rs.getString("joindate"));
				String grade = rs.getString("grade");
				if(grade.equals("A")) {
					grade = "VIP";
				} else if (grade.equals("B")) {
					grade = "일반";
				} else if (grade.equals("C")) {
					grade = "직원";
				}
				vo.setGrade(grade);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<ShopVo> getMemberPrice() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select mem.custno, mem.custname, mem.grade, sum(price) as price\r\n" + 
				"from member_tbl_02 mem, money_tbl_02 mon\r\n" + 
				"where mem.custno = mon.custno\r\n" + 
				"group by mem.custno, mem.custname, mem.grade\r\n" + 
				"order by price desc";
		
		List<ShopVo> list = new ArrayList<ShopVo>();
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopVo vo = new ShopVo();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				String grade = rs.getString("grade");
				if(grade.equals("A")) {
					grade = "VIP";
				} else if (grade.equals("B")) {
					grade = "일반";
				} else if (grade.equals("C")) {
					grade = "직원";
				}
				vo.setGrade(grade);
				vo.setPrice(rs.getInt("price"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
}
