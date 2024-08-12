package javaJDBCdepart;

import java.sql.*;
import java.util.*;

public class DepartDao {
	public List<DepartVo> selectEmployeeList(List<DepartVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		list = new ArrayList<DepartVo>();
		
		String sql = "select e.e_no, e.e_name, d.name as dname, l.name as lname, w.name as wname, e.performance, e.e_join_date\r\n" + 
				"from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w\r\n" + 
				"where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place\r\n" + 
				"order by e.e_no";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepartVo vo = new DepartVo();
				vo.setE_no(rs.getString("e_no"));
				vo.setE_name(rs.getString("e_name"));
				vo.setDname(rs.getString("dname"));
				vo.setLname(rs.getString("lname"));
				vo.setWname(rs.getString("wname"));
				vo.setPerformance(rs.getString("performance"));
				vo.setE_join_date(rs.getString("e_join_date"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DepartVo> selectEmployeeSalary(List<DepartVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		list = new ArrayList<DepartVo>();
		
		String sql = "select e.e_no, e.e_name, d.name as dname, l.name as lname, w.name as wname, e.performance,\r\n" + 
				"decode(e.performance, 'A', l.salary + (l.salary * 0.1),\r\n" + 
				"                      'B', l.salary + (l.salary * 0.08),\r\n" + 
				"                      'C', l.salary + (l.salary * 0.05),\r\n" + 
				"                      'D', l.salary) as sal\r\n" + 
				"from tbl_company_employee e, tbl_company_depart d, tbl_company_level l, tbl_company_work w\r\n" + 
				"where e.e_depart = d.depart_code and e.e_level = l.level_code and e.e_work_place = w.work_place\r\n" + 
				"order by d.depart_code";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepartVo vo = new DepartVo();
				vo.setE_no(rs.getString("e_no"));
				vo.setE_name(rs.getString("e_name"));
				vo.setDname(rs.getString("dname"));
				vo.setLname(rs.getString("lname"));
				vo.setWname(rs.getString("wname"));
				vo.setPerformance(rs.getString("performance"));
				vo.setSal(rs.getInt("sal"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<DepartVo> selectDepartSalary(List<DepartVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		list = new ArrayList<DepartVo>();
		
		String sql = "select d.depart_code, d.name as dname,\r\n" + 
				"sum(decode(e.performance, 'A', l.salary + (l.salary * 0.1),\r\n" + 
				"                      'B', l.salary + (l.salary * 0.08),\r\n" + 
				"                      'C', l.salary + (l.salary * 0.05),\r\n" + 
				"                      'D', l.salary)) as sal\r\n" + 
				"from tbl_company_employee e, tbl_company_depart d, tbl_company_level l\r\n" + 
				"where e.e_depart = d.depart_code and e.e_level = l.level_code\r\n" + 
				"group by d.depart_code, d.name\r\n" + 
				"order by d.depart_code";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepartVo vo = new DepartVo();
				vo.setDepart_code(rs.getString("depart_code"));
				vo.setDname(rs.getString("dname"));
				vo.setSal(rs.getInt("sal"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<DepartVo> selectWorkPlaceSalary(List<DepartVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		list = new ArrayList<DepartVo>();
		
		String sql = "select w.work_place, w.name as wname,\r\n" + 
				"sum(decode(e.performance, 'A', l.salary + (l.salary * 0.1),\r\n" + 
				"                      'B', l.salary + (l.salary * 0.08),\r\n" + 
				"                      'C', l.salary + (l.salary * 0.05),\r\n" + 
				"                      'D', l.salary)) as sal\r\n" + 
				"from tbl_company_employee e, tbl_company_level l, tbl_company_work w\r\n" + 
				"where e.e_work_place = w.work_place and e.e_level = l.level_code\r\n" + 
				"group by w.work_place, w.name\r\n" + 
				"order by w.work_place";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepartVo vo = new DepartVo();
				vo.setWork_place(rs.getString("work_place"));
				vo.setWname(rs.getString("wname"));
				vo.setSal(rs.getInt("sal"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
