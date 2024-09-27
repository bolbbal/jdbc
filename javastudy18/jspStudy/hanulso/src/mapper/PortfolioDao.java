package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.PortfolioVo;
import util.Criteria;
import util.DBManager;

public class PortfolioDao {
	
	private static PortfolioDao instance = new PortfolioDao();
	private PortfolioDao() {
		
	}
	
	public static PortfolioDao getInstance() {
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
	
	public void insertPortfolio(PortfolioVo vo) {
		
		String sql = "insert into portfolio (idx, writer, title, content, imgurl) values (portfolio_seq.nextval, ?, ?, ?, ?)";
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, vo.getWriter());
			pstmt.setNString(2, vo.getTitle());
			pstmt.setNString(3, vo.getContent());
			pstmt.setNString(4, vo.getImgurl());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public int getPortfolioCount(String query) {
			
		int count = 0;
		
		String sql = "";
		
		if(query!="") {
			sql = "select count(*) as count from portfolio where " + query;
		} else {
			sql = "select count(*) as count from portfolio";
		}
		
				
		
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
			close();
		}
		
		return count;
		
	}

	public List<PortfolioVo> portfolioView(Criteria cri, String query) {
		
		String sql = "";
		
		if(query!="") {
			sql = "select * from (select /*+ index_desc (portfolio portfolio_pk)*/ "
					+ "rownum rn, idx, regdate, title, content, writer, viewcount, imgurl "
					+ "from portfolio "
					+ "where (" + query + ") and rownum <= (? * ?)) "
					+ "where rn > ((? - 1) * ?)";
		} else {
			sql = "select * from (select /*+ index_desc (portfolio portfolio_pk)*/ "
					+ "rownum rn, idx, regdate, title, content, writer, viewcount, imgurl "
					+ "from portfolio "
					+ "where rownum <= (? * ?)) "
					+ "where rn > ((? - 1) * ?)";
		}
		
		List<PortfolioVo> list = new ArrayList<PortfolioVo>();
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				PortfolioVo vo = new PortfolioVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getNString("title"));
				vo.setContent(rs.getNString("content"));
				vo.setWriter(rs.getNString("writer"));
				vo.setImgurl(rs.getNString("imgurl"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				vo.setViewcount(rs.getInt("viewcount"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public PortfolioVo selectPortfolioIdx(int idx) {
		
		String sql = "select * from portfolio where idx = ?";
		
		PortfolioVo vo = new PortfolioVo();
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setTitle(rs.getNString("title"));
				vo.setContent(rs.getNString("content"));
				vo.setWriter(rs.getNString("writer"));
				vo.setImgurl(rs.getNString("imgurl"));
				vo.setRegdate(rs.getNString("regdate").substring(0, 10));
				vo.setViewcount(rs.getInt("viewcount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public void updatePortfolio(PortfolioVo vo) {
		
		String sql = "update set portfolio title = ?, content = ?, imgurl = ? where idx = ?";
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setNString(1, vo.getTitle());
			pstmt.setNString(2, vo.getContent());
			pstmt.setNString(3, vo.getImgurl());
			pstmt.setInt(4, vo.getIdx());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void updatePortfolioViewCount(int idx) {
		
		String sql = "update portfolio set viewcount = viewcount + 1 where idx = ?";
		
		try {
			
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
