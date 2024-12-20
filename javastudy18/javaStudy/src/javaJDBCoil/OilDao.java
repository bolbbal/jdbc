package javaJDBCoil;

import java.sql.*;
import java.util.*;

public class OilDao {
	public List<OilVo> selectAllSale(List<OilVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select s.saleno, s.oildate, o.oilname, s.amount, s.paytype, c.custname, c.custno, c.custtel1, c.custtel2, c.custtel3, s.creditcart, s.oilcost\r\n" + 
				"from tbl_saleinfo_202010 s\r\n" + 
				"left outer join tbl_oilinfo_202010 o\r\n" + 
				"on s.oiltype = o.oiltype\r\n" + 
				"left outer join tbl_cusinfo_202010 c\r\n" + 
				"on s.custno = c.custno\r\n" + 
				"order by s.saleno";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OilVo vo = new OilVo();
				vo.setSaleno(rs.getString("saleno"));
				vo.setOildate(rs.getString("oildate").substring(0,4) + "년" + rs.getString("oildate").substring(4,6) + "월" + rs.getString("oildate").substring(6) + "일");
				vo.setOilname(rs.getString("oilname"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPaytype(rs.getString("paytype"));
				if (vo.getPaytype().equals("1")) {
					vo.setPaytype("현금");
				} else if (vo.getPaytype().equals("2")) {
					vo.setPaytype("카드");
				}
				vo.setCustname(rs.getString("custname"));
				if (vo.getCustname() == null) {
					vo.setCustname("비회원");
				}
				vo.setCustno(rs.getString("custno"));
				if (vo.getCustno() == null) {
					vo.setCustno("비회원");
				}
				vo.setTel(rs.getString("custtel1") + rs.getString("custtel2") + rs.getString("custtel3"));
				vo.setTel(vo.getTel().substring(0,3) + "-" + vo.getTel().substring(3,7) + "-" + vo.getTel().substring(7));
				if (vo.getTel().equals("nul-lnul-lnull")) {
					vo.setTel("000-0000-0000");
				}
				vo.setCreditcart(rs.getString("creditcart"));
				if (vo.getCreditcart() == null) {
					vo.setCreditcart("\t\t");
				}
				vo.setOilcost(rs.getInt("oilcost"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<OilVo> selectDailySale(List<OilVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select s.oildate, o.oilname, count(s.oiltype) as count, sum(s.oilcost) as tot\r\n" + 
				"from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o\r\n" + 
				"where s.oiltype = o.oiltype\r\n" + 
				"group by s.oildate, o.oilname\r\n" + 
				"order by s.oildate asc, o.oilname asc";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OilVo vo = new OilVo();
				vo.setOildate(rs.getString("oildate").substring(0,4) + "년" + rs.getString("oildate").substring(4,6) + "월" + rs.getString("oildate").substring(6) + "일");
				vo.setOilname(rs.getString("oilname"));
				vo.setCount(rs.getInt("count"));
				vo.setTot(rs.getInt("tot"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<OilVo> selectAllSale_modify(List<OilVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select s.saleno, \r\n" + 
				"TO_CHAR(TO_DATE(s.oildate, 'YYYYMMDD'), 'YYYY\"년\"MM\"월\"DD\"일\"') as oildate, o.oilname, s.amount, s.paytype, c.custname, c.custno, \r\n" + 
				"c.custtel1||'-'||c.custtel2||'-'||c.custtel3 as tel, s.creditcart, s.oilcost\r\n" + 
				"from tbl_saleinfo_202010 s\r\n" + 
				"left outer join tbl_oilinfo_202010 o\r\n" + 
				"on s.oiltype = o.oiltype\r\n" + 
				"left outer join tbl_cusinfo_202010 c\r\n" + 
				"on s.custno = c.custno\r\n" + 
				"order by s.saleno";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OilVo vo = new OilVo();
				vo.setSaleno(rs.getString("saleno"));
				vo.setOildate(rs.getString("oildate"));
				vo.setOilname(rs.getString("oilname"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPaytype(rs.getString("paytype"));
				if (vo.getPaytype().equals("1")) {
					vo.setPaytype("현금");
				} else if (vo.getPaytype().equals("2")) {
					vo.setPaytype("카드");
				}
				vo.setCustname(rs.getString("custname"));
				if (vo.getCustname() == null) {
					vo.setCustname("비회원");
				}
				vo.setCustno(rs.getString("custno"));
				if (vo.getCustno() == null) {
					vo.setCustno("비회원");
				}
				vo.setTel(rs.getString("tel"));
				if (vo.getTel().equals("--")) {
					vo.setTel("000-0000-0000");
				}
				vo.setCreditcart(rs.getString("creditcart"));
				if (vo.getCreditcart() == null) {
					vo.setCreditcart("\t\t");
				}
				vo.setOilcost(rs.getInt("oilcost"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<OilVo> selectDailySale_modify(List<OilVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select to_char(to_date(s.oildate,'yyyyMMdd'), 'yyyy\"년\"MM\"월\"dd\"일\"') as oildate, o.oilname, count(s.oiltype) as count, sum(s.oilcost) as tot\r\n" + 
				"from tbl_saleinfo_202010 s, tbl_oilinfo_202010 o\r\n" + 
				"where s.oiltype = o.oiltype\r\n" + 
				"group by s.oildate, o.oilname\r\n" + 
				"order by s.oildate asc, o.oilname asc";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OilVo vo = new OilVo();
				vo.setOildate(rs.getString("oildate"));
				vo.setOilname(rs.getString("oilname"));
				vo.setCount(rs.getInt("count"));
				vo.setTot(rs.getInt("tot"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
