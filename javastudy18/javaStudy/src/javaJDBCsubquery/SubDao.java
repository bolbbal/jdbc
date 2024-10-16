package javaJDBCsubquery;

import java.sql.*;
import java.util.*;

public class SubDao {
	public List<SubVo> selectNotM(List<SubVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select eno, ename, salary from emp where salary > (select avg(salary) from emp) and dno in (select dno from emp where ename like '%M%')";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SubVo vo = new SubVo();
				
				vo.setEno(rs.getInt("eno"));
				vo.setEname(rs.getString("ename"));
				vo.setSalary(rs.getInt("salary"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
