package javaJDBCOdition;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
public class OditionDao {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat ndf = new SimpleDateFormat("yyyy년 MM월 dd일");
	DecimalFormat df = new DecimalFormat("###.00");
	public void insertOdition() {
		
		System.out.print("참가번호 : ");
		String id = sc.next();
		System.out.print("참가자명 : ");
		String name = sc.next();
		System.out.print("생년월일 : ");
		String birth = sc.next();
		System.out.print("성별 : [남자:M,여자:F] ");
		String gender = sc.next();
		System.out.print("특기 : [1]댄스[2]랩[3]노래 ");
		String talent = sc.next();
		System.out.print("소속사 : ");
		String agency = sc.next();
		System.out.print("등록하시겠습니까?[y/n] ");
		String answer = sc.next();
		
		if (answer.equalsIgnoreCase("n")) {
			return;
		} else if (answer.equalsIgnoreCase("y")) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "insert into tbl_artist_201905 (artist_id, artist_name, artist_gender, artist_birth, talent, agency)values (?,?,?,?,?,?)";
			
			try {
				conn = DBManager.getInstance().getDBmanager();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, gender);
				pstmt.setString(4, birth);
				pstmt.setString(5, talent);
				pstmt.setString(6, agency);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void selectArtist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select * from tbl_artist_201905";
		
		try {
			conn = DBManager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<OditionVo> list = new ArrayList<OditionVo>();
			System.out.println("\t\t참가자 목록 조회");
			System.out.println("참가번호\t참가자명\t생년월일\t\t성별\t특기\t소속사");
			while(rs.next()) {
				OditionVo vo = new OditionVo();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
				list.add(vo);
			}
			for(OditionVo vo : list) {
				System.out.print(vo.getArtist_id() + "\t");
				System.out.print(vo.getArtist_name() + "\t");
				String birth = vo.getArtist_birth();
				Date formatDate = sdf.parse(birth);
				String realBirth = ndf.format(formatDate);
				System.out.print(realBirth + "\t");
				String gender = null;
				if (vo.getArtist_gender().equalsIgnoreCase("f")) {
					gender = "여성";
				} else if (vo.getArtist_gender().equalsIgnoreCase("m")) {
					gender = "남성";
				}
				System.out.print(gender + "\t");
				String talent = null;
				if (vo.getTalent().equals("1")) {
					talent = "댄스";
				} else if (vo.getTalent().equals("2")) {
					talent = "랩";
				} else if (vo.getTalent().equals("3")) {
					talent = "노래";
				}
				System.out.print(talent + "\t");
				System.out.println(vo.getAgency());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectMentoPoint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select p.serial_no, p.artist_id, p.mento_id, a.artist_birth, p.point, m.mento_name\r\n" + 
				"from tbl_point_201905 p, tbl_artist_201905 a, tbl_mento_201905 m\r\n" + 
				"where p.artist_id = a.artist_id and p.mento_id = m.mento_id\r\n" + 
				"order by p.serial_no asc";
		
		try {
			conn = DBManager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<OditionVo> list = new ArrayList<OditionVo>();
			System.out.println("\t\t멘토 점수 목록 조회");
			System.out.println("채점번호\t참가번호\t참가자명\t생년월일\t\t점수\t평점\t멘토");
			while(rs.next()) {
				OditionVo vo = new OditionVo();
				vo.setSerial_no(rs.getString("serial_no"));
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("mento_id"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setPoint(rs.getInt("point"));
				
				if (vo.getPoint() >= 90) {
					vo.setGrade("A");
				} else if (vo.getPoint() >= 80) {
					vo.setGrade("B");
				} else if (vo.getPoint() >= 70) {
					vo.setGrade("C");
				} else if (vo.getPoint() >= 60) {
					vo.setGrade("D");
				} else if (vo.getPoint() < 60) {
					vo.setGrade("F");
				}
				vo.setMento_name(rs.getString("mento_name"));
				list.add(vo);
			}
			for(OditionVo vo : list) {
				System.out.print(vo.getSerial_no() + "\t");
				System.out.print(vo.getArtist_id() + "\t");
				System.out.print(vo.getArtist_name() + "\t");
				String birth = vo.getArtist_birth();
				Date formatDate = sdf.parse(birth);
				String realBirth = ndf.format(formatDate);
				System.out.print(realBirth + "\t");
				System.out.print(vo.getPoint() + "\t");
				System.out.print(vo.getGrade() + "\t");
				System.out.println(vo.getMento_name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectArtistRank() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select a.artist_id, a.artist_name, a.artist_gender, sum(p.point) as sum, round(avg(p.point), 2) as ave\r\n" + 
				"from tbl_point_201905 p, tbl_artist_201905 a\r\n" + 
				"where p.artist_id = a.artist_id\r\n" + 
				"group by a.artist_id, a.artist_name, a.artist_gender\r\n" + 
				"order by ave desc";
		
		try {
			conn = DBManager.getInstance().getDBmanager();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<OditionVo> list = new ArrayList<OditionVo>();
			int rank = 1;
			System.out.println("\t\t참가자 등수 조회");
			System.out.println("참가번호\t참가자명\t성별\t총점\t평균\t등수");
			while(rs.next()) {
				OditionVo vo = new OditionVo();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTot(rs.getInt("sum"));
				vo.setAve(rs.getDouble("ave"));
				vo.setRank(rank);
				list.add(vo);
				rank++;
			}
			for(OditionVo vo : list) {
				System.out.print(vo.getArtist_id() + "\t");
				System.out.print(vo.getArtist_name() + "\t");
				String gender = null;
				if (vo.getArtist_gender().equalsIgnoreCase("f")) {
					gender = "여성";
				} else if (vo.getArtist_gender().equalsIgnoreCase("m")) {
					gender = "남성";
				}
				System.out.print(gender + "\t");
				System.out.print(vo.getTot() + "\t");
				System.out.print(df.format(vo.getAve()) + "\t");
				System.out.println(vo.getRank());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
