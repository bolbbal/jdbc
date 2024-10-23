package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import util.DBManager;

public class MainDao {
	
	private static MainDao instance = new MainDao();
	private MainDao() {}
	
	public static MainDao getInstance() {
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
	
//	public List<Object> getPoplarPost() {
//		
//	}
	
	public List<PostAndSuggestVo> getRecentlyPost() {
		
		String sql = "select * from post p left outer join post_suggest ps on p.post_idx = ps.post_idx where p.post_idx = (select max(p.post_idx) from post p left outer JOIN post_suggest ps ON p.post_idx = ps.post_idx) or p.post_idx = (select max(p.post_idx) from post p left outer JOIN post_suggest ps ON p.post_idx = ps.post_idx where p.post_idx < (select max(post_idx) from post))";
		
		List<PostAndSuggestVo> list = new ArrayList<PostAndSuggestVo>();
		
		try {
			
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo postVo = new PostVo();
				
				postVo.setPost_idx(rs.getInt("post_idx"));
				postVo.setPost_type_idx(rs.getInt("post_type_idx"));
				postVo.setTitle(rs.getNString("title"));
				postVo.setContents(rs.getNString("contents"));
				postVo.setRegdate(rs.getNString("regdate").substring(0,10));
				if(rs.getNString("modifydate") != null) {
					postVo.setModifydate(rs.getNString("modifydate").substring(0,10));					
				}
				postVo.setUser_idx(rs.getInt("user_idx"));
				postVo.setNickname(rs.getNString("nickname"));
				postVo.setViewcount(rs.getInt("viewcount"));
				postVo.setLikecount(rs.getInt("likecount"));
				
				PostSuggestVo suggestVo = new PostSuggestVo();
				
				suggestVo.setThumnail(rs.getNString("thumnail"));
				suggestVo.setMusic(rs.getNString("music"));
				suggestVo.setSinger(rs.getNString("singer"));
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
				
			    PostAndSuggestVo vo = new PostAndSuggestVo();
			    
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
}
