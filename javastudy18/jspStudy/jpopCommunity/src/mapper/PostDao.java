package mapper;

import java.sql.*;
import java.util.*;

import domain.PostSuggestVo;
import domain.PostTypeVo;
import domain.PostVo;
import domain.PostWithSuggestVo;
import domain.SingerVo;
import domain.UserVo;
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

	private PostDao() {}

	public static PostDao getInstance() {
		return instance;
	}

	public void insertPost(PostVo postVo, PostSuggestVo suggestVo, UserVo userVo) {

		String sql = null;

		if (suggestVo != null) {
			
			sql = "insert into post (post_idx, post_type_idx, title, contents, nickname, password, imgurl, user_idx) values (post_idx_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				conn = DBManager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, postVo.getPost_type_idx());
				pstmt.setNString(2, postVo.getTitle());
				pstmt.setNString(3, postVo.getContents());
				pstmt.setNString(4, userVo.getUserNickname());
				pstmt.setNString(5, userVo.getUserPw());
				pstmt.setNString(6, postVo.getImgurl());
				pstmt.setInt(7, userVo.getUserIdx());

				pstmt.executeUpdate();
				
				sql = "SELECT post_idx_seq.currval FROM dual";
		        pstmt = conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        
		        int currentPostIdx = 0;
		        if (rs.next()) {
		            currentPostIdx = rs.getInt(1);
		            System.out.println("Current Post Index: " + currentPostIdx);
		        }
		        
		        insertPostSuggest(suggestVo, currentPostIdx);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
		} else {
			
			sql = "insert into post (post_idx, title, contents, nickname, password, imgurl, user_idx) values (post_idx_seq.nextval, ?, ?, ?, ?, ?, ?)";
			
			try {
				conn = DBManager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setNString(1, postVo.getTitle());
				pstmt.setNString(2, postVo.getContents());
				pstmt.setNString(3, userVo.getUserNickname());
				pstmt.setNString(4, userVo.getUserPw());
				pstmt.setNString(5, postVo.getImgurl());
				pstmt.setInt(6, userVo.getUserIdx());

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				close();
			}
		}
	}
	
	public void insertPost(PostVo postVo, PostSuggestVo suggestVo) {

		String sql = null;

		if (suggestVo != null) {
			
			sql = "insert into post (post_idx, post_type_idx, title, contents, nickname, password, imgurl) values (post_idx_seq.nextval, ?, ?, ?, ?, ?, ?)";
			
			try {
				conn = DBManager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, postVo.getPost_type_idx());
				pstmt.setNString(2, postVo.getTitle());
				pstmt.setNString(3, postVo.getContents());
				pstmt.setNString(4, postVo.getNickname());
				pstmt.setNString(5, postVo.getPassword());
				pstmt.setNString(6, postVo.getImgurl());

				pstmt.executeUpdate();
				
				sql = "SELECT post_idx_seq.currval FROM dual";
		        pstmt = conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        
		        int currentPostIdx = 0;
		        if (rs.next()) {
		            currentPostIdx = rs.getInt(1);
		            System.out.println("Current Post Index: " + currentPostIdx);
		        }
		        
		        insertPostSuggest(suggestVo, currentPostIdx);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
		} else {
			
			sql = "insert into post (post_idx, title, contents, nickname, password, imgurl) values (post_idx_seq.nextval, ?, ?, ?, ?, ?)";
			
			try {
				conn = DBManager.getInstance().getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setNString(1, postVo.getTitle());
				pstmt.setNString(2, postVo.getContents());
				pstmt.setNString(3, postVo.getNickname());
				pstmt.setNString(4, postVo.getPassword());
				pstmt.setNString(5, postVo.getImgurl());

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				close();
			}
		}
	}
	
	public void insertPostSuggest(PostSuggestVo suggestVo, int currentPostIdx) {
		
		String sql = "";
		
		try {

			conn = DBManager.getInstance().getConnection();
		
	        sql = "insert into post_suggest (post_idx, youtube_url, thumnail, music, singer, lyrics) values (?, ?, ?, ?, ?, ?)";
	        
			pstmt = conn.prepareStatement(sql);
			System.out.println(suggestVo.getThumnail());
			pstmt.setInt(1, currentPostIdx);
			pstmt.setNString(2, suggestVo.getYoutube_url());
			pstmt.setNString(3, suggestVo.getThumnail());
			pstmt.setNString(4, suggestVo.getMusic());
			pstmt.setNString(5, suggestVo.getSinger());
			pstmt.setNString(6, suggestVo.getLyrics());

			pstmt.executeUpdate();
			
			checkSingerInfo(suggestVo, currentPostIdx);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void checkSingerInfo(PostSuggestVo suggestVo, int currentPostIdx) {
		
		String sql = "select * \r\n" + 
				"from singer\r\n" + 
				"where singer like ?";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, "'%"+suggestVo.getSinger()+"%'");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int singer_idx = rs.getInt("singer_idx");
				
				insertMusicInfo(suggestVo, singer_idx, currentPostIdx);
				
			} else {
				
				insertSingerInfo(suggestVo, currentPostIdx);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void insertSingerInfo(PostSuggestVo suggestVo, int currentPostIdx) {
		
		String sql = "insert into singer (singer_idx, post_idx, singer) values (singer_seq.nextval, ?, ?)";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, currentPostIdx);
			pstmt.setNString(2, suggestVo.getSinger());
			
			pstmt.executeUpdate();
			
			sql = "SELECT singer_seq.currval FROM dual";
	        pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        int currentSingerIdx = 0;
	        if (rs.next()) {
	        	currentSingerIdx = rs.getInt(1);
	            System.out.println("Current singer Index: " + currentSingerIdx);
	        }
	        
	        insertMusicInfo(suggestVo, currentSingerIdx, currentPostIdx);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void insertMusicInfo(PostSuggestVo suggestVo, int currentSingerIdx, int currentPostIdx) {
		
		String sql = "insert into music (post_idx, singer_idx, music_idx, music, lyrics) values (?, ?, music_seq.nextval, ?, ?)";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, currentPostIdx);
			pstmt.setInt(2, currentSingerIdx);
			pstmt.setNString(3, suggestVo.getMusic());
			pstmt.setNString(4, suggestVo.getLyrics());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
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
	
	public int getPopularPostCount(String query) {

		String sql = "";
		int count = 0;

		if (query != "") {
			sql = "select count(*) as count from post where likecount > 4 and " + query;
		} else {
			sql = "select count(*) as count from post where likecount > 4";
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
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, user_idx\r\n" + 
					"      FROM (\r\n" + 
					"        SELECT p.*, pt.*\r\n" + 
					"        FROM post p\r\n" + 
					"        JOIN post_type pt ON p.post_type_idx = pt.post_type_idx\r\n" + 
					"        ORDER BY p.post_idx DESC\r\n" + 
					"    ) p "+  
					"      where rownum <= (? * ?)) p \r\n" + 
					"where rn > ((?-1) * ?)";
		} else {
			sql = "select * \r\n" + 
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, user_idx\r\n" + 
					"      FROM (\r\n" + 
					"        SELECT p.*, pt.*\r\n" + 
					"        FROM post p\r\n" + 
					"        JOIN post_type pt ON p.post_type_idx = pt.post_type_idx\r\n" + 
					"        ORDER BY p.post_idx DESC\r\n" + 
					"    ) p " + 
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
				vo.setPost_type(rs.getNString("post_type"));
				vo.setTitle(rs.getNString("title"));
				vo.setContents(rs.getNString("contents"));
				vo.setNickname(rs.getNString("nickname"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setLikecount(rs.getInt("likecount"));
				vo.setReplycount(rs.getInt("replycount"));
				vo.setUser_idx(rs.getInt("user_idx"));
				vo.setImgurl(rs.getNString("imgurl"));

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
			sql = "select * \r\n" + 
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount \r\n" + 
					"      FROM (\r\n" + 
					"        SELECT p.*, pt.post_type\r\n" + 
					"        FROM post p\r\n" + 
					"        JOIN post_type pt ON p.post_type_idx = pt.post_type_idx\r\n" + 
					"        ORDER BY p.post_idx DESC\r\n" + 
					"    ) p "+  
					"      where likecount > 4 and rownum <= (? * ?)) p \r\n" + 
					"where rn > ((?-1) * ?)";
		} else {
			sql = "select * \r\n" + 
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, post_type, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount \r\n" + 
					"      FROM (\r\n" + 
					"        SELECT p.*, pt.post_type\r\n" + 
					"        FROM post p\r\n" + 
					"        JOIN post_type pt ON p.post_type_idx = pt.post_type_idx\r\n" + 
					"        ORDER BY p.post_idx DESC\r\n" + 
					"    ) p " + 
					"      where likecount > 4 and (" + query + ") and rownum <= (? * ?))\r\n" + 
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
				vo.setPost_type(rs.getNString("post_type"));
				vo.setTitle(rs.getNString("title"));
				vo.setContents(rs.getNString("contents"));
				vo.setNickname(rs.getNString("nickname"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setLikecount(rs.getInt("likecount"));
				vo.setReplycount(rs.getInt("replycount"));
				vo.setUser_idx(rs.getInt("user_idx"));
				vo.setImgurl(rs.getNString("imgurl"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	
	public int getPostSuggestCount(String query) {
		
		String sql = "";
		int count = 0;

		if (query != "") {
			sql = "select count(*) as count from post_suggest where " + query;
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
	
	public List<PostWithSuggestVo> getPostSuggestList(Criteria cri, String query) {
		
		String sql = null;

		if (query == "") {
			sql = "select * from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, user_idx, youtube_url, music, singer, thumnail, lyrics\r\n" + 
					"            	FROM (\r\n" + 
					"                    SELECT p.*, ps.youtube_url, ps.thumnail, ps.music, ps.singer, ps.lyrics\r\n" + 
					"                    FROM post p\r\n" + 
					"                    JOIN post_suggest ps ON p.post_idx = ps.post_idx order by p.post_idx desc \r\n" + 
					"                    )\r\n" + 
					"                 where rownum <= (? * ?)\r\n" + 
					"                 )\r\n" + 
					"where rn > ((?-1) * ?)";
		} else {
			sql = "select * \r\n" + 
					"from (select /*+ index_desc (post post_pk) */ rownum rn, post_idx, title, contents, nickname, password, imgurl, regdate, modifydate, viewcount, likecount, replycount, user_idx, youtube_url, music, singer, thumnail, lyrics\r\n" + 
					"		FROM (\r\n" + 
					"            SELECT p.*, ps.youtube_url, ps.thumnail, ps.music, ps.singer, ps.lyrics\r\n" + 
					"            FROM post p\r\n" + 
					"            JOIN post_suggest ps ON p.post_idx = ps.post_idx order by p.post_idx desc \r\n " + 
					"		)\r\n" + 
					"        where rownum <= 5 and (" + query + ")\r\n" + 
					") \r\n" + 
					"where rn > ((?-1) * ?)";
		}

		List<PostWithSuggestVo> list = new ArrayList<PostWithSuggestVo>();

		try {

			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				PostVo postVo = new PostVo();

				postVo.setPost_idx(rs.getInt("post_idx"));
				postVo.setTitle(rs.getNString("title"));
				postVo.setContents(rs.getNString("contents"));
				postVo.setNickname(rs.getNString("nickname"));
				postVo.setRegdate(rs.getNString("regdate").substring(0, 10));
				postVo.setViewcount(rs.getInt("viewcount"));
				postVo.setLikecount(rs.getInt("likecount"));
				postVo.setReplycount(rs.getInt("replycount"));
				postVo.setUser_idx(rs.getInt("user_idx"));
				postVo.setImgurl(rs.getNString("imgurl"));
				
				PostSuggestVo suggestVo = new PostSuggestVo();
				
				suggestVo.setYoutube_url(rs.getNString("youtube_url"));
				suggestVo.setMusic(rs.getNString("music"));
				suggestVo.setSinger(rs.getNString("singer"));
				suggestVo.setThumnail(rs.getNString("thumnail"));
				String lyrics = rs.getNString("lyrics");
			    if (lyrics != null) {
			        // <br> 태그를 기준으로 문자열 분리
			        String[] parts = lyrics.split("<br>");
			        
			        // 세 번째 <br> 까지의 내용을 결합
			        StringBuilder combinedLyrics = new StringBuilder();
			        for (int i = 0; i < Math.min(parts.length, 3); i++) {
			            combinedLyrics.append(parts[i]);
			            if (i < 2) { // 마지막 항목이 아닐 때만 <br> 추가
			                combinedLyrics.append("<br>");
			            }
			        }
			        
			        if (parts.length > 3) {
			            combinedLyrics.append("...");
			        }
			        
			        // 결합된 내용을 suggestVo에 저장
			        suggestVo.setLyrics(combinedLyrics.toString());
			    }
				
				
				PostWithSuggestVo vo = new PostWithSuggestVo();
				vo.setPost(postVo);
				vo.setSuggest(suggestVo);
				
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
				postVo.setReplycount(rs.getInt("replycount"));
				
				list.add(postVo);
				
				if(postVo.getPost_type_idx() == 2) {
					
					suggestVo = new PostSuggestVo();
					
					suggestVo.setPost_idx(rs.getInt("post_idx"));
					suggestVo.setYoutube_url(rs.getNString("youtube_url"));
					suggestVo.setThumnail(rs.getNString("thumnail"));
					suggestVo.setMusic(rs.getNString("music"));
					suggestVo.setSinger(rs.getNString("singer"));
					suggestVo.setLyrics(rs.getNString("lyrics"));
					
					list.add(suggestVo);
				}
	
			} else {
				sql = "select * from post where post_idx = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, post_idx);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
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
					postVo.setReplycount(rs.getInt("replycount"));
					
					list.add(postVo);
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
	
	public PostVo selectPopularCount(int post_idx) {
		
		String sql = "select * from post where post_idx = ?";
		
		PostVo vo = null;
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new PostVo();
				
				vo.setLikecount(rs.getInt("likecount"));
				vo.setReplycount(rs.getInt("replycount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}

	public void UpdateHatecount(int post_idx) {

		String sql = "update post set likecount = likecount - 1 where post_idx = ?";

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

		String sql = "update post set title = ?, contents = ?, imgurl = ?, modifydate = sysdate, post_type_idx = ? where post_idx = ?";
			
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, vo.getTitle());
			pstmt.setNString(2, vo.getContents());
			pstmt.setNString(3, vo.getImgurl());
			pstmt.setInt(4, vo.getPost_type_idx());
			pstmt.setInt(5, vo.getPost_idx());

			pstmt.executeUpdate();
				
			if(suggestVo != null) {
	
				SuggestUpdate(suggestVo);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	} 

	public void SuggestUpdate(PostSuggestVo suggestVo) {
		
		String sql = "update post_suggest set music = ?, singer = ?, youtube_url = ?, thumnail = ? where post_idx = ?";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, suggestVo.getMusic());
			pstmt.setNString(2, suggestVo.getSinger());
			pstmt.setNString(3, suggestVo.getYoutube_url());
			pstmt.setNString(4, suggestVo.getThumnail());
			pstmt.setInt(5, suggestVo.getPost_idx());

			pstmt.executeUpdate();
			
			SingerUpdate(suggestVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void SingerUpdate(PostSuggestVo suggestVo) {
		
		String sql = "update singer set singer = ? where post_idx = ?";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, suggestVo.getSinger());
			pstmt.setInt(2, suggestVo.getPost_idx());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void MusicUpdate(PostSuggestVo suggestVo) {
		
		String sql = "update music set music = ?, lyrics = ? where post_idx = ?";
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, suggestVo.getMusic());
			pstmt.setNString(2, suggestVo.getLyrics());
			pstmt.setInt(3, suggestVo.getPost_idx());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
