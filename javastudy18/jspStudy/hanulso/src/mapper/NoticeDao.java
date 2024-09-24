package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.NoticeVo;
import util.Criteria;
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
	
	public List<NoticeVo> noticeSelectWithPage(Criteria cri) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		String sql = "select * from (\r\n" + 
				"    select /*+ index_desc (notice notice_pk)*/ \r\n" + 
				"    rownum rn, idx, title, content, writer, regdate, viewcount\r\n" + 
				"    from notice\r\n" + 
				"    where rownum <= (?*?))\r\n" + 
				"where rn > ((?-1)*?)";
		
		List<NoticeVo> list = new ArrayList<NoticeVo>();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
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
		
		return list;
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
		
		return list;
	}
	
	public NoticeVo getSelectIdx(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from notice where idx = ?";
		
		NoticeVo vo = null;

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new NoticeVo();
				vo.setIdx(idx);
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regdate").substring(0,10));
				vo.setWriter(rs.getString("writer"));
				vo.setViewcount(rs.getInt("viewcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return vo;
	}
	
	public void deleteNoticeIdx(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from notice where idx = ?";
		
		NoticeVo vo = null;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
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
	
	public int selectPostCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as count from notice where idx is not null";
		
		int count = 0;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return count;
	}
	
	public void increaseCountUpdate(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set viewcount = viewcount + 1 where idx = ?";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
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
	
	public void noticeDetailUpdate(NoticeVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set title = ?, content = ? where idx = ?";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getIdx());
			
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
	
	public NoticeVo noticePrevTitleSelect(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from notice where idx = (select min(idx) from notice where idx > ?)";
		
		NoticeVo vo = null;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new NoticeVo();
				vo.setTitle(rs.getString("title"));
				vo.setIdx(rs.getInt("idx"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return vo;
	}
	
	public NoticeVo noticeNextTitleSelect(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from notice where idx = (select max(idx) from notice where idx < ?)";
		
		NoticeVo vo = null;
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new NoticeVo();
				vo.setTitle(rs.getString("title"));
				vo.setIdx(rs.getInt("idx"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return vo;
	}
	
	public List<Map<String, Object>> noticeMapSelect() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from notice order by idx desc";
		
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("idx", rs.getInt("idx"));
				map.put("title", rs.getString("title"));
				map.put("content", rs.getString("content"));
				map.put("regdate", rs.getString("regdate").substring(0,10));
				map.put("writer", rs.getString("writer"));
				map.put("viewcount", rs.getInt("viewcount"));
				
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return list;
	}
}
