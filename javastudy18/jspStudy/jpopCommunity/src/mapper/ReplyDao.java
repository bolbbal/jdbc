package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.ReplyVo;
import util.DBManager;

public class ReplyDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	protected void close() {
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
			e.printStackTrace();
		}
	}

	private static ReplyDao instance = new ReplyDao();

	private ReplyDao() {}

	public static ReplyDao getInstance() {
		return instance;
	}
	
	public void insertReply(ReplyVo vo) {
		
		String sql = "insert into reply (reply_idx, post_idx, nickname, reply_password, comments) values (reply_seq.nextval, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPostIdx());
			pstmt.setNString(2, vo.getNickname());
			pstmt.setNString(3, vo.getReply_password());
			pstmt.setNString(4, vo.getComments());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
