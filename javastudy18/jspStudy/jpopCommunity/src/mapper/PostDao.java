package mapper;

import java.sql.*;
import java.util.*;

import domain.PostSuggestVo;
import domain.PostTypeVo;
import domain.PostVo;
import domain.SingerVo;
import util.Criteria;
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

	public void insertPost(PostVo postVo, PostSuggestVo suggestVo) {

		String postSql = null;
		String suggestSql = null;
		String singerSql = null;
		String musicSql = null;
		
		if (suggestVo != null) {
			
			postSql = "insert into post (post_idx, post_type_idx, title, contents, nickname, password, imgurl) values (post_idx_seq.nextval, ?, ?, ?, ?, ?, ?)";
			suggestSql = "insert into postSuggest (post_idx, youtube_url, thumnail, music, singer) values (post_idx_seq, ?, ?, ?, ?)";
			
		} else {
			postSql = "insert into post (post_idx, title, contents, nickname, password, imgurl) values (post_idx_seq.nextval, ?, ?, ?, ?, ?)";
		}

		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(postSql);

			pstmt.setInt(1, postVo.getPost_type_idx());
			pstmt.setNString(2, postVo.getTitle());
			pstmt.setNString(3, postVo.getContents());
			pstmt.setNString(4, postVo.getNickname());
			pstmt.setNString(5, postVo.getPassword());
			pstmt.setNString(6, postVo.getImgurl());

			pstmt.executeUpdate();

			if (suggestVo != null) {
				insertPostSuggest(suggestVo, suggestSql);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close();
		}

	}
	
	public SingerVo getSingerInfo(PostSuggestVo suggestVo) {
		
		String sql = "select * \r\n" + 
				"from singer\r\n" + 
				"where singer like ?";
		
		SingerVo vo = null;
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, "%"+suggestVo.getSinger()+"%");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new SingerVo();
				
				vo.setSinger_idx(rs.getInt("singer_idx"));
				vo.setSinger(rs.getNString("singer"));
				vo.setSinger_img(rs.getNString("singer_img"));
				
			} else {
				
				insertSingerInfo(suggestVo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public void insertSingerInfo(PostSuggestVo suggestVo) {
		
		String sql = "insert into singer (singer_idx, singer) value (singer_seq.nextval, ?)";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, "%"+suggestVo.getSinger()+"%");
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void insertMusicInfo() {
		
	}

	public void insertPostSuggest(PostSuggestVo suggestVo, String suggestSql) {

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(suggestSql);

			pstmt.setNString(1, suggestVo.getYoutube_url());
			pstmt.setNString(2, suggestVo.getThumnail());
			pstmt.setNString(3, suggestVo.getMusic());
			pstmt.setNString(4, suggestVo.getSinger());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getPostCount(String query) {

		String sql = "";
		int count = 0;

		if (query != "") {
			sql = "select count(*) as count from post where " + query;
		} else {
			sql = "select count(*) as count from post";
		}

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return count;
	}

	public List<PostVo> getPostList(Criteria cri, String query) {

		String sql = null;

		if (query == "") {
			sql = "select * \r\n" + 
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount\r\n" + 
					"      from post \r\n" + 
					"      where rownum <= (? * ?))\r\n" + 
					"where rn > ((?-1) * ?)";
		} else {
			sql = "select * \r\n" + 
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, hatecount\r\n" + 
					"      from post \r\n" + 
					"      where (" + query + ") and rownum <= (? * ?))\r\n" + 
					"where rn > ((?-1) * ?)";
		}

		List<PostVo> list = new ArrayList<PostVo>();

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				PostVo vo = new PostVo();

				vo.setPost_idx(rs.getInt("post_idx"));
				vo.setPost_type_idx(rs.getInt("post_type_idx"));
				vo.setTitle(rs.getNString("title"));
				vo.setContents(rs.getNString("contents"));
				vo.setNickname(rs.getNString("nickname"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setLikecount(rs.getInt("likecount"));
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

	public List<PostVo> getPupularPostList(Criteria cri, String query) {

		String sql = null;

		if (query == "") {
			sql = "select * \r\n"
					+ "from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, regdate, modifydate, viewcount, likecount, replycount\r\n"
					+ "      from post where likecount > 4 and rownum <= (? * ?))\r\n" + "where rn > ((?-1) * ?)";
		} else {
			sql = "select * \r\n"
					+ "from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, regdate, modifydate, viewcount, likecount, replycount\r\n"
					+ "      from post where likecount > 4 and (" + query + ") and rownum <= (? * ?))\r\n"
					+ "where rn > ((?-1) * ?)";
		}

		List<PostVo> list = new ArrayList<PostVo>();

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				PostVo vo = new PostVo();

				vo.setPost_idx(rs.getInt("post_idx"));
				vo.setPost_type_idx(rs.getInt("post_type_idx"));
				vo.setTitle(rs.getNString("title"));
				vo.setContents(rs.getNString("contents"));
				vo.setNickname(rs.getNString("nickname"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				vo.setModifydate(rs.getNString("modifydate").substring(0, 10));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setLikecount(rs.getInt("likecount"));
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

	public List<Object> getPostSelect(int post_idx) {

		String sql = "select * from post join post_suggest on post.post_idx = post_suggest.post_idx where post.post_idx = ?";

		List<Object> list = new ArrayList<Object>();

		PostVo postVo = null;
		PostSuggestVo suggestVo = null;

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				postVo = new PostVo();
				
				postVo.setPost_idx(rs.getInt("post_idx"));
				postVo.setPost_type_idx(rs.getInt("post_type_idx"));
				postVo.setTitle(rs.getNString("title"));
				postVo.setContents(rs.getNString("contents"));
				postVo.setNickname(rs.getNString("nickname"));
				postVo.setPassword(rs.getNString("password"));
				postVo.setImgurl(rs.getNString("imgurl"));
				postVo.setRegdate(rs.getNString("regdate").substring(0, 10));
				if(rs.getNString("modifydate")!=null) {
					postVo.setModifydate(rs.getNString("modifydate").substring(0, 10));
				}
				postVo.setViewcount(rs.getInt("viewcount"));
				postVo.setLikecount(rs.getInt("likecount"));
				postVo.setHatecount(rs.getInt("hatecount"));
				postVo.setReplycount(rs.getInt("replycount"));
				
				list.add(postVo);
				
				if(postVo.getPost_type_idx() == 2) {
					
					suggestVo = new PostSuggestVo();
					
					suggestVo.setYoutube_url(rs.getNString("youtube_url"));
					suggestVo.setThumnail(rs.getNString("thumnail"));
					suggestVo.setMusic(rs.getNString("music"));
					suggestVo.setSinger(rs.getNString("singer"));
					suggestVo.setLyrics(rs.getNString("lyrics"));
					
					list.add(suggestVo);
				}
	
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public void UpdateViewcount(int post_idx) {

		String sql = "update post set viewcount = viewcount + 1 where post_idx = ?";

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, post_idx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void UpdateLikecount(int post_idx) {

		String sql = "update post set likecount = likecount + 1 where post_idx = ?";

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, post_idx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void UpdateHatecount(int post_idx) {

		String sql = "update post set hatecount = hatecount + 1 where post_idx = ?";

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, post_idx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void UpdateReplycount(int post_idx) {

		String sql = "update post set replycount = replycount + 1 where post_idx = ?";

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, post_idx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void PostUpdate(PostVo vo, PostSuggestVo suggestVo) {

		String postSql = null;
		String suggestSql = null;

		if (suggestVo != null) {

			postSql = "update post set title = ?, contents = ?, imgurl = ?, modifydate = sysdate where post_idx = ?";
			suggestSql = "update post_suggest set music = ?, singer = ?, youtube_url = ?, thumnail = ? where post_idx = ?";

		}

		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(postSql);

			pstmt.setNString(1, vo.getTitle());
			pstmt.setNString(2, vo.getContents());
			pstmt.setNString(3, vo.getImgurl());
			pstmt.setInt(4, vo.getPost_idx());

			pstmt.executeUpdate();

			if (suggestVo != null) {
				SuggestUpdate(suggestVo, suggestSql);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void SuggestUpdate(PostSuggestVo suggestVo, String suggestSql) {

		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(suggestSql);

			pstmt.setNString(1, suggestVo.getMusic());
			pstmt.setNString(2, suggestVo.getSinger());
			pstmt.setNString(3, suggestVo.getYoutube_url());
			pstmt.setNString(4, suggestVo.getThumnail());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
