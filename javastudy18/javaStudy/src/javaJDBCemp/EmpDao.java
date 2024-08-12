package javaJDBCemp;

import java.util.*;
import java.sql.*;

public class EmpDao {
	Connection conn = DBmanager.getInstance().getDBmanager();
	
	public List<EmpVo> getEmpSelect() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from emp order by salary desc, ename asc";
		List<EmpVo> list = new ArrayList<EmpVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setEno(rs.getInt("eno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setManager(rs.getInt("manager"));
				vo.setHiredate(rs.getString("hiredate"));
				vo.setSalary(rs.getInt("salary"));
				vo.setCommission(rs.getDouble("commission"));
				vo.setDno(rs.getInt("dno"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<EmpVo> getAverage() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select dno, job, count(*) as jobtot, sum(salary) as saltot, avg(salary) as salave from emp group by dno, job order by dno, job";
		List<EmpVo> list = new ArrayList<EmpVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setDno(rs.getInt("dno"));
				vo.setJob(rs.getString("job"));
				vo.setJobtot(rs.getInt("jobtot"));
				vo.setSaltot(rs.getInt("saltot"));
				vo.setSalave(rs.getDouble("salave"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<EmpVo> getHaving() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select dno, max(salary) as maxsal from emp group by dno having max(salary) >= 3000";
		
		List<EmpVo> list = new ArrayList<EmpVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setDno(rs.getInt("dno"));
				vo.setMaxsal(rs.getInt("maxsal"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public EmpVo getSearchName(String ename) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp where ename = upper(?)";
		EmpVo vo = new EmpVo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setEno(rs.getInt("eno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setManager(rs.getInt("manager"));
				vo.setHiredate(rs.getString("hiredate"));
				vo.setSalary(rs.getInt("salary"));
				vo.setCommission(rs.getInt("commission"));
				vo.setDno(rs.getInt("dno"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	
	public void insertEmp() {
		
	}
	
	public void printEmp() {
		
	}
	
	public void selectEmp() {
		
	}
	
	public void updateEmp() {
		
	}
	
	public void deleteEmp() {
		
	}
}
