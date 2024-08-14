package javaJDBCOdition;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
public class OditionDao {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat ndf = new SimpleDateFormat("yyyy�� MM�� dd��");
	DecimalFormat df = new DecimalFormat("###.00");
	public void insertOdition() {
		
		System.out.print("������ȣ : ");
		String id = sc.next();
		System.out.print("�����ڸ� : ");
		String name = sc.next();
		System.out.print("������� : ");
		String birth = sc.next();
		System.out.print("���� : [����:M,����:F] ");
		String gender = sc.next();
		System.out.print("Ư�� : [1]����[2]��[3]�뷡 ");
		String talent = sc.next();
		System.out.print("�Ҽӻ� : ");
		String agency = sc.next();
		System.out.print("����Ͻðڽ��ϱ�?[y/n] ");
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
			System.out.println("\t\t������ ��� ��ȸ");
			System.out.println("������ȣ\t�����ڸ�\t�������\t\t����\tƯ��\t�Ҽӻ�");
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
					gender = "����";
				} else if (vo.getArtist_gender().equalsIgnoreCase("m")) {
					gender = "����";
				}
				System.out.print(gender + "\t");
				String talent = null;
				if (vo.getTalent().equals("1")) {
					talent = "����";
				} else if (vo.getTalent().equals("2")) {
					talent = "��";
				} else if (vo.getTalent().equals("3")) {
					talent = "�뷡";
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
			System.out.println("\t\t���� ���� ��� ��ȸ");
			System.out.println("ä����ȣ\t������ȣ\t�����ڸ�\t�������\t\t����\t����\t����");
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
			System.out.println("\t\t������ ��� ��ȸ");
			System.out.println("������ȣ\t�����ڸ�\t����\t����\t���\t���");
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
					gender = "����";
				} else if (vo.getArtist_gender().equalsIgnoreCase("m")) {
					gender = "����";
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