package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.NoticeVo;
import domain.PortfolioVo;
import util.DBManager;

public class MainDao {
	
	private static MainDao instance = new MainDao();
	private MainDao() {
		
	}
	
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
	
	public List<PortfolioVo> getPortList() {
		
		String sql = "select /*+ index_desc (portfolio portfolio_pk)*/ * "
				+ "from portfolio "
				+ "where rownum < 4";

		List<PortfolioVo> list = new ArrayList<PortfolioVo>();
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				PortfolioVo vo = new PortfolioVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getNString("title"));
				vo.setContent(rs.getNString("content"));
				vo.setImgurl(rs.getNString("imgurl"));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setWriter(rs.getNString("writer"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public List<NoticeVo> getNoticeList() {
		
		String sql = "select /*+ index_desc (notice notice_pk)*/ * "
				+ "from notice "
				+ "where rownum < 5";

		List<NoticeVo> list = new ArrayList<NoticeVo>();
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				NoticeVo vo = new NoticeVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getNString("title"));
				vo.setContent(rs.getNString("content"));
				vo.setViewcount(rs.getInt("viewcount"));
				vo.setWriter(rs.getNString("writer"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				
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
