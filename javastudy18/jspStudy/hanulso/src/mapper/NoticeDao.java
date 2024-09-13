package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.NoticeVo;
import util.DBManager;

public class NoticeDao {

	private static NoticeDao instance = new NoticeDao();

	private NoticeDao() {
	}

	public static NoticeDao getInstance() {
		return instance;
	}

	public void noticeInsert(NoticeVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into notice (idx, writer, title, content) values (notice_seq.nextval, ?,?,?)";

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	}
	
	public List<NoticeVo> noticeSelect() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from notice order by idx desc";
		
		List<NoticeVo> list = new ArrayList<NoticeVo>();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeVo vo = new NoticeVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regdate").substring(0,10));
				vo.setWriter(rs.getString("writer"));
				vo.setViewcount(rs.getInt("viewcount"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return list;
	}
}
