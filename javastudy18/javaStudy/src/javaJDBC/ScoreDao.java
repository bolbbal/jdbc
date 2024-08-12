package javaJDBC;

import java.util.*;
import java.sql.*;

public class ScoreDao {
	// CRUD작업 메서드
	// insert, update, delete => Connection, PreparedStatement
	// select => Connection, PreparedStatement, ResultSet
	// Connection : DB접속 객체
	// PreparedStatement : SQL 질의어 처리 객체
	// ResultSet : 검색 결과를 담는 객체
	// insert, select, update 실행 => executeUpdate()
	// select 실행 => executeQuery()

	// 입력
	// dB저장 데이터 키보드로부터 입력받아 Vo 객체에 저장한 후 scoreInsert 메서드로 보낸다
	public void scoreInsert(ScoreVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into score (bno, name, kor, eng, mat) values (score_seq.nextval,?,?,?,?)";

		try {
			conn = DBmanager.getInstance().getDBmanager(); // DB접속
			pstmt = conn.prepareStatement(sql); // SQL을 실행시킬 준비
			pstmt.setString(1, vo.getName()); // 해당 물음표에 vo에 저장된 정보를 읽어와서 해당 타입으로 대입
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.executeUpdate(); // sql 실행
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 출력
	public ArrayList<ScoreVo> scorePrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from score order by bno asc";

		ArrayList<ScoreVo> list = new ArrayList<ScoreVo>(); // ScoreVo 객체 저장할 객체배열 생성

		try {
			conn = DBmanager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // 가지고 올 레코드가 존재하면 반복
				ScoreVo vo = new ScoreVo();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
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
					vo.setGrade("불합격");
				}
				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 검색
	public ScoreVo scoreSelect(int selBno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from score where bno = ?";
		ScoreVo vo = null;

		try {
			conn = DBmanager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selBno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ScoreVo();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
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
					vo.setGrade("불합격");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 수정
	public int scoreUpdate(ScoreVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update score set kor = ?, eng = ?, mat = ? where bno = ?";
		int result = 0;
		try {
			conn = DBmanager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getKor());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getMat());
			pstmt.setInt(4, vo.getBno());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 삭제
	public int scoreDelete(int delBno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from score where bno = ?";
		int result = 0;
		try {
			conn = DBmanager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, delBno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
