package javaJDBCTest;

import java.sql.*;
import java.util.*;

public class ScoreDao {
	public void insert(ScoreVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into Score (bno, name, kor, eng, mat) values (score_seq.nextval,?,?,?,?)";

		try {
			conn = DBmanager.getInstance().DBconn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ScoreVo> print() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from score order by bno asc";

		ArrayList<ScoreVo> list = new ArrayList<ScoreVo>();

		try {
			conn = DBmanager.getInstance().DBconn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getNString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("kor") + rs.getInt("eng") + rs.getInt("mat"));
				vo.setAve(vo.getTot() / 3.);
				if (vo.getAve() >= 90) {
					vo.setGrade("A");
				} else if (vo.getAve() >= 80) {
					vo.setGrade("B");
				} else if (vo.getAve() >= 70) {
					vo.setGrade("C");
				} else if (vo.getAve() >= 60) {
					vo.setGrade("D");
				} else {
					vo.setGrade("F");
				}
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ScoreVo> list = new ArrayList<ScoreVo>();
		
		String sql = "select ? from score where ?";
		try {
			conn = DBmanager.getInstance().DBconn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void delete() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from score where bno = ?";
		
		try {
			conn = DBmanager.getInstance().DBconn();
			pstmt = conn.prepareStatement(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
