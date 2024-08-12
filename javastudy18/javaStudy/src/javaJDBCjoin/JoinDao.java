package javaJDBCjoin;
import java.util.*;
import java.sql.*;
public class JoinDao {
	Connection conn = DBManager.getInstance().getDBmanager();
	
	public List<JoinVo> getJoin() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select e.ename, d.dname, e.salary, s.grade from emp e, dept d, sal s where e.dno = d.dno and salary between losal and hisal";
		List<JoinVo> list = new ArrayList<JoinVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JoinVo vo = new JoinVo();
				vo.setEname(rs.getString("ename"));
				vo.setDname(rs.getString("dname"));
				vo.setSalary(rs.getInt("salary"));
				vo.setGrade(rs.getInt("grade"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
