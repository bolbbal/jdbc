package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopDao {

	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

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

		}
	}

	public int getCustno() {
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

		} finally {
			close(conn, pstmt, rs);
		}
		return custno;
	}

	public void insertMember(ShopVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member_tbl_02 values (?,?,?,?,?,?,?)";

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

		} finally {
			close(conn, pstmt);
		}
	}

	public String getJoindate() {
		Date today = new Date();
		today.toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		String joindate = sdf.format(today);

		return joindate;
	}

	public List<ShopVo> selectAllMemberValues() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member_tbl_02";

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
				vo.setJoindate(rs.getString("joindate").substring(0,10));
				String grade = rs.getString("grade");
				if(grade.equals("A")) {
					grade = "VIP";
				} else if(grade.equals("B")) {
					grade = "일반";
				} else if(grade.equals("C")) {
					grade = "직원";
				}
				vo.setGrade(grade);
				vo.setCity(rs.getString("city"));
				list.add(vo);
			}
		} catch (Exception e) {

		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<ShopVo> selectMemberPrice() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select mem.custno, mem.custname, mem.grade, sum(mon.price) as price from member_tbl_02 mem, money_tbl_02 mon where mem.custno = mon.custno group by mem.custno, mem.custname, mem.grade order by price desc";

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
				} else if(grade.equals("B")) {
					grade = "일반";
				} else if(grade.equals("C")) {
					grade = "직원";
				}
				vo.setGrade(grade);
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {

		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
}
