package Model;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
	DecimalFormat df = new DecimalFormat("##.0");

	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
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

	public void close(Connection conn, PreparedStatement pstmt) {
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

	public void insertStudent(ScoreVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into tbl_student_201905 values (?,?,?,?,?,?,?,?,?)";

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setString(4, vo.getSname());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getTel1());
			pstmt.setString(8, vo.getTel2());
			pstmt.setString(9, vo.getTel3());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}

	public void insertScore(ScoreVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into tbl_score_201905 values (?,?,?,?,?,?)";

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setInt(4, vo.getKor());
			pstmt.setInt(5, vo.getEng());
			pstmt.setInt(6, vo.getMat());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
	}

	public List<ScoreVo> selectScore() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select std.syear, std.sclass, std.sno, std.sname, \r\n" + "decode(std.gender, 'M', '남',\r\n"
				+ "                   'F', '여') as gender, \r\n"
				+ "sc.kor, sc.eng, sc.mat, sum(kor+eng+mat) as tot, \r\n" + "round(avg((kor+eng+mat)/3),1) as ave \r\n"
				+ "from tbl_student_201905 std, tbl_score_201905 sc \r\n"
				+ "where std.sno = sc.sno and std.sclass = sc.sclass\r\n"
				+ "group by std.syear, std.sclass, std.sno, std.sname, sc.kor, \r\n"
				+ "sc.eng, sc.mat, decode(std.gender, 'M', '남', 'F', '여')\r\n" + "order by sclass asc, sno asc";

		List<ScoreVo> list = new ArrayList<ScoreVo>();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setGender(rs.getString("gender"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				double ave = rs.getDouble("ave");
				df.format(ave);
				vo.setAve(ave);

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return list;
	}

	public List<ScoreVo> selectClassScore() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select dept.syear, dept.sclass, dept.tname, \r\n"
				+ "sum(kor) as tkor, sum(eng) as teng, sum(mat) as tmat,\r\n"
				+ "round(avg(kor),1) as akor, round(avg(eng),1) as aeng, round(avg(mat),1) as amat\r\n"
				+ "from tbl_dept_201905 dept, tbl_score_201905 score\r\n" + "where dept.sclass = score.sclass\r\n"
				+ "group by dept.syear, dept.tname, dept.sclass order by dept.sclass asc";

		List<ScoreVo> list = new ArrayList<ScoreVo>();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setTname(rs.getString("tname"));
				vo.setTkor(rs.getInt("tkor"));
				vo.setTeng(rs.getInt("teng"));
				vo.setTmat(rs.getInt("tmat"));

				double akor = rs.getDouble("akor");
				df.format(akor);
				vo.setAkor(akor);

				double aeng = rs.getDouble("aeng");
				df.format(aeng);
				vo.setAeng(aeng);

				double amat = rs.getDouble("amat");
				df.format(amat);
				vo.setAmat(amat);

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return list;
	}

	public ScoreVo selectScoreTot() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select sum(kor) as tkor, sum(eng) as teng, sum(mat) as tmat\r\n" + "from tbl_score_201905";

		ScoreVo vo = new ScoreVo();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setTkor(rs.getInt("tkor"));
				vo.setTeng(rs.getInt("teng"));
				vo.setTmat(rs.getInt("tmat"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return vo;
	}

	public ScoreVo selectScoreAve() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select avg(kor) as akor, avg(eng) as aeng, avg(mat) as amat\r\n" + 
				"from tbl_score_201905";

		ScoreVo vo = new ScoreVo();

		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				double akor = rs.getDouble("akor");
				df.format(akor);
				vo.setAkor(akor);

				double aeng = rs.getDouble("aeng");
				df.format(aeng);
				vo.setAeng(aeng);

				double amat = rs.getDouble("amat");
				df.format(amat);
				vo.setAmat(amat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return vo;
	}
}
