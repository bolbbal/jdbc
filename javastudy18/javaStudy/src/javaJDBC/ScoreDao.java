package javaJDBC;

import java.util.*;
import java.sql.*;

public class ScoreDao {
	// CRUD�۾� �޼���
	// insert, update, delete => Connection, PreparedStatement
	// select => Connection, PreparedStatement, ResultSet
	// Connection : DB���� ��ü
	// PreparedStatement : SQL ���Ǿ� ó�� ��ü
	// ResultSet : �˻� ����� ��� ��ü
	// insert, select, update ���� => executeUpdate()
	// select ���� => executeQuery()

	// �Է�
	// dB���� ������ Ű����κ��� �Է¹޾� Vo ��ü�� ������ �� scoreInsert �޼���� ������
	public void scoreInsert(ScoreVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into score (bno, name, kor, eng, mat) values (score_seq.nextval,?,?,?,?)";

		try {
			conn = DBmanager.getInstance().getDBmanager(); // DB����
			pstmt = conn.prepareStatement(sql); // SQL�� �����ų �غ�
			pstmt.setString(1, vo.getName()); // �ش� ����ǥ�� vo�� ����� ������ �о�ͼ� �ش� Ÿ������ ����
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.executeUpdate(); // sql ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���
	public ArrayList<ScoreVo> scorePrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from score order by bno asc";

		ArrayList<ScoreVo> list = new ArrayList<ScoreVo>(); // ScoreVo ��ü ������ ��ü�迭 ����

		try {
			conn = DBmanager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // ������ �� ���ڵ尡 �����ϸ� �ݺ�
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
					vo.setGrade("���հ�");
				}
				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// �˻�
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
					vo.setGrade("���հ�");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// ����
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

	// ����
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
