package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.ReplyVo;
import util.DBManager;

public class ReplyDao {
	
	private static ReplyDao instance = new ReplyDao();
	private ReplyDao() {}
	public static ReplyDao getInstance() {
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
	
	public int CountReply(int port_idx) {
		
		String sql = "select count(*) as count from reply where port_idx = ?";
		
		int count = 0;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, port_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return count;
	}
	
	public void insertReply(ReplyVo vo) {
		
		String sql = "insert into reply (reply_idx, port_idx, member_idx, reply) values (reply_seq.nextval, ?, ?, ?)";
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getPort_idx());
			pstmt.setInt(2, vo.getMember_idx());
			pstmt.setNString(3, vo.getReply());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<ReplyVo> selectReply(int port_idx) {
		
		String sql = "select * from (select r.*, h.name\r\n" + 
				"                from reply r, hanulso h\r\n" + 
				"                where r.member_idx = h.member_idx) p, portfolio pf\r\n" + 
				"        where pf.idx = ? and p.port_idx = pf.idx";
		
		List<ReplyVo> list = new ArrayList<ReplyVo>();
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, port_idx);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ReplyVo vo = new ReplyVo();
				
				vo.setReply_idx(rs.getInt("reply_idx"));
				vo.setMember_idx(rs.getInt("member_idx"));
				vo.setRegdate(rs.getNString("regdate"));
				vo.setReply(rs.getNString("reply"));
				vo.setMemberName(rs.getNString("name"));
				
				
				list.add(vo);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
}
