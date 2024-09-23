package mapper;

import java.sql.*;
import java.util.*;

import domain.PostVo;
import util.DBManager;

public class PostDao {

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

	private static PostDao instance = new PostDao();

	private PostDao() {

	}

	public static PostDao getInstance() {
		return instance;
	}
	
	public void insertPost(PostVo vo) {
		
		String sql = null;
		
		if(vo.getSinger()==null) {
			
			sql = "insert into post (idx, title,contents, nickname, password) values (post_seq.nextval, ?, ?, ?, ?)";
			
			try {
				
				conn = DBManager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setNString(1, vo.getTitle());
				pstmt.setNString(2, vo.getContents());
				pstmt.setNString(3, vo.getNickname());
				pstmt.setNString(4, vo.getPassword());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
		} else {
			
			sql = "insert into post (idx, title, singer, contents, nickname, password) values (post_seq.nextval, ?, ?, ?, ?, ?)";
			
			try {
				
				conn = DBManager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setNString(1, vo.getTitle());
				pstmt.setNString(2, vo.getSinger());
				pstmt.setNString(3, vo.getContents());
				pstmt.setNString(4, vo.getNickname());
				pstmt.setNString(5, vo.getPassword());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
		}
		
		
		
	}

	public List<PostVo> getPostList() {

		String sql = "select * from post order by idx desc";
		
		List<PostVo> list = new ArrayList<PostVo>();

		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				PostVo vo = new PostVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getNString("title"));
				vo.setSinger(rs.getNString("singer"));
				vo.setContents(rs.getNString("contents"));
				vo.setNickname(rs.getNString("nickname"));
				vo.setRegdate(rs.getNString("regdate").substring(0,10));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setLikecount(rs.getInt("likecount"));
				vo.setHatecount(rs.getInt("hatecount"));
				vo.setReplycount(rs.getInt("replycount"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public PostVo getPostSelect(int idx) {

		String sql = "select * from post where idx = ?";
		
		PostVo vo = null;

		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new PostVo();
				
				vo.setTitle(rs.getNString("title"));
				vo.setSinger(rs.getNString("singer"));
				vo.setContents(rs.getNString("contents"));
				vo.setNickname(rs.getNString("nickname"));
				vo.setRegdate(rs.getNString("regdate").substring(0,10));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setLikecount(rs.getInt("likecount"));
				vo.setHatecount(rs.getInt("hatecount"));
				vo.setReplycount(rs.getInt("replycount"));
		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public void UpdateViewcount(int idx) {
		
		String sql = "update post set viewcount = viewcount + 1 where idx = ?";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void UpdateLikecount(int idx) {
			
		String sql = "update post set likecount = likecount + 1 where idx = ?";
			
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void UpdateHatecount(int idx) {
		
		String sql = "update post set hatecount = hatecount + 1 where idx = ?";
			
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void UpdateReplycount(int idx) {
		
		String sql = "update post set replycount = replycount + 1 where idx = ?";
			
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void PostContentsUpdate(int idx) {
		
		String sql = "update post set title = ?, singer = ?, contents = ? where idx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, value);
		}
	}
}
