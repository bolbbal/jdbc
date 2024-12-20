package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.MemberVo;
import util.DBManager;

public class MemberDao {
	
	private static MemberDao instance = new MemberDao();
	private MemberDao() {};
	
	public static MemberDao getInstance() {
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
	
	public void insertMember(MemberVo vo) {
		
		String sql = "insert into hanulso (member_idx, name, id, password, phone, email) values (hanulso_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, vo.getName());
			pstmt.setNString(2, vo.getId());
			pstmt.setNString(3, vo.getPassword());
			pstmt.setNString(4, vo.getPhone());
			pstmt.setNString(5, vo.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public String selectID(String id) {
		
		String result = "";
		
		String sql = "select * from hanulso where id like ?";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = "1";
			} else {
				result = "-1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public MemberVo SetID(String id) {
		
		String sql = "select * from hanulso where id like ?";
		
		MemberVo vo = null;
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVo();
				
				vo.setId(rs.getNString("id"));
				vo.setMemberIdx(rs.getInt("member_idx"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public int getSelectIdPw(String id, String pw) {
		
		String sql = "select * from hanulso where id like ?";
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getNString("password") != null && rs.getNString("password").equals(pw)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public String getMemberName(int idx) {
		
		String sql = "select name from hanulso where member_idx = ?";
		
		String memberName = "";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberName = rs.getNString("name");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return memberName;
	}
	
}
