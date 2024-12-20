package usedCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class UsedCarDao {
	public List<UsedCarVo> selectMemberAll() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UsedCarVo> list = new ArrayList<UsedCarVo>();
		
		String sql = "select member_no, member_name, member_jumin, member_call, member_address, member_email, \r\n" + 
				"decode (member_type, 1, '일반',\r\n" + 
				"                     2, '딜러') as member_type\r\n" + 
				"from member"
				+ " order by member_no";
		
		try {
			conn = DBManager.getInstance().getDBManager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UsedCarVo vo = new UsedCarVo();
				
				vo.setMember_no(rs.getInt("member_no"));
				vo.setMember_name(rs.getString("member_name"));
				vo.setMember_jumin(rs.getString("member_jumin"));
				vo = getMemberAgeGender(vo);
				vo.setMember_call(rs.getString("member_call"));
				vo.setMember_address(rs.getString("member_address"));
				vo.setMember_email(rs.getString("member_email"));
				if (vo.getMember_email() == null) {
					vo.setMember_email("\t\t");
				}
				vo.setMember_type(rs.getString("member_type"));
				
				list.add(vo);
			}
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	
	public UsedCarVo getMemberAgeGender(UsedCarVo vo) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDD");
		
		String age = vo.getMember_jumin().substring(0,2);
		String gender = vo.getMember_jumin().substring(6,7);
		
		
		if (gender.equals("1") || gender.equals("3")) {
			gender = "남성";
		} else if (gender.equals("2") || gender.equals("4")) {
			gender = "여성";
		}
		
		vo.setMember_age(age);
		vo.setMember_gender(gender);
		
		return vo;
	}
}
