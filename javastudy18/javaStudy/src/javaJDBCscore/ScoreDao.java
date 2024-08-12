package javaJDBCscore;

import java.sql.*;
import java.util.*;
public class ScoreDao {
	Connection conn = DBmanager.getInstance().getDBmanager();
	
	public List<ScoreVo> selectStdScore() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select std.syear, std.sclass, std.sno, std.sname, std.gender, sc.kor, sc.eng, sc.mat, sc.kor + sc.eng + sc.mat as tot, round((sc.kor + sc.eng + sc.mat) / 3, 1) as ave\r\n" + 
				"from tbl_student_201905 std, tbl_score_201905 sc  \r\n" + 
				"where std.syear = sc.syear and std.sclass = sc.sclass and std.sno = sc.sno";
		List<ScoreVo> list = new ArrayList<ScoreVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setGender(rs.getString("gender"));
				if(vo.getGender().equals("M")) {
					vo.setGender("³²");
				} else if(vo.getGender().equals("F")) {
					vo.setGender("¿©");
				}
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAve(rs.getDouble("ave"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	public List<ScoreVo> selectClassTot() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select d.syear, d.sclass, d.tname, sum(sc.kor) as korSum, sum(sc.eng) as engSum, sum(sc.mat) as matSum, round(avg(sc.kor), 1) as korAve, round(avg(sc.eng), 1) as engAve, round(avg(sc.mat), 1) as matAve\r\n" + 
				"from tbl_dept_201905 d, tbl_score_201905 sc\r\n" + 
				"where d.syear = sc.syear and d.sclass = sc.sclass\r\n" + 
				"group by d.syear, d.sclass, d.tname";
		List<ScoreVo> list = new ArrayList<ScoreVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVo vo = new ScoreVo();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setTname(rs.getString("tname"));
				vo.setKorTot(rs.getInt("korsum"));
				vo.setEngTot(rs.getInt("engsum"));
				vo.setMatTot(rs.getInt("matsum"));
				vo.setKorAve(rs.getDouble("korave"));
				vo.setEngAve(rs.getDouble("engave"));
				vo.setMatAve(rs.getDouble("matave"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
