package javaJDBCentry;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EntryDao {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat ddf = new SimpleDateFormat("yyMMdd");
	SimpleDateFormat sdf = new SimpleDateFormat("yy��MM��dd��");

	public void insertEntry() {
		EntryVo vo = new EntryVo();
		System.out.println(">>�濵���� ��� ȭ��");
		System.out.print("���� ��ȣ : ");
		String entryNo = sc.next();
		System.out.println("�ɻ����� ���� ���");
		System.out.print("��ɻ� ���� : ");
		int score1 = sc.nextInt();
		System.out.print("�̽ɻ� ���� : ");
		int score2 = sc.nextInt();
		System.out.print("�ڽɻ� ���� : ");
		int score3 = sc.nextInt();
		System.out.print("Ȳ�ɻ� ���� : ");
		int score4 = sc.nextInt();
		System.out.print("���ɻ� ���� : ");
		int score5 = sc.nextInt();
		
		vo.setEntry_no(entryNo);
		vo.setScore1(score1);
		vo.setScore2(score2);
		vo.setScore3(score3);
		vo.setScore4(score4);
		vo.setScore5(score5);
		int max = max(vo);
		int min = min(vo);
		int tot = tot(vo);
		double ave = ave(vo);
		vo.setS_max(max);
		vo.setS_min(min);
		vo.setS_tot(tot);
		vo.setS_ave(ave);
		
		System.out.print("��Ͽ��� [Y/N]");
		String decide = sc.next();
		if (decide.equalsIgnoreCase("n")) {
			return;
		} else if (decide.equalsIgnoreCase("y")) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			String sql = "insert into tbl_record_202106 (entry_no, score1, score2, score3, score4, score5, s_max, s_min, s_tot, s_ave)\r\n"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				conn = DBManager.getInstance().getDBManger();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getEntry_no());
				pstmt.setInt(2, vo.getScore1());
				pstmt.setInt(3, vo.getScore2());
				pstmt.setInt(4, vo.getScore3());
				pstmt.setInt(5, vo.getScore4());
				pstmt.setInt(6, vo.getScore5());
				pstmt.setInt(7, vo.getS_max());
				pstmt.setInt(8, vo.getS_min());
				pstmt.setInt(9, vo.getS_tot());
				pstmt.setDouble(10, vo.getS_ave());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void selectEntry() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.print("������ȣ�� �Է��ϼ��� : ");
		String entryNo = sc.next();

		String sql = "select et.entry_no, et.entry_name, et.entry_jumin, et.entry_type, et.entry_area, re.rname1, re.rname2, re.rname3, re.rname4, re.rname5, rc.score1, rc.score2, rc.score3, rc.score4, rc.score5, rc.s_tot, rc.s_ave\r\n" + 
				"from tbl_entry_202106 et, tbl_record_202106 rc, tbl_referee_202106 re\r\n" + 
				"where et.entry_no = rc.entry_no";

		try {
			conn = DBManager.getInstance().getDBManger();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<EntryVo> list = new ArrayList<EntryVo>();
			while (rs.next()) {
				EntryVo vo = new EntryVo();
				vo.setEntry_no(rs.getString("entry_no"));
				if (vo.getEntry_no().equals(entryNo)) {
					vo.setEntry_name(rs.getString("entry_name"));
					vo.setEntry_jumin(rs.getString("entry_jumin"));
					vo.setEntry_type(rs.getString("entry_type"));
					vo.setEntry_area(rs.getString("entry_area"));
					vo.setRname1(rs.getString("rname1"));
					vo.setRname2(rs.getString("rname2"));
					vo.setRname3(rs.getString("rname3"));
					vo.setRname4(rs.getString("rname4"));
					vo.setRname5(rs.getString("rname5"));
					vo.setScore1(rs.getInt("score1"));
					vo.setScore2(rs.getInt("score2"));
					vo.setScore3(rs.getInt("score3"));
					vo.setScore4(rs.getInt("score4"));
					vo.setScore5(rs.getInt("score5"));
					vo.setS_tot(rs.getInt("s_tot"));
					vo.setS_ave(rs.getDouble("s_ave"));
					list.add(vo);

					for (EntryVo vo2 : list) {
						System.out.println("������ȣ:" + vo2.getEntry_no() + " ���� �濬�����ȸ");
						System.out.println("������ȣ\t" + vo2.getEntry_no());
						System.out.print("����\t" + vo2.getEntry_name());
						if (vo2.getEntry_jumin().substring(6, 7).equals("1")) {
							System.out.println("(��)");
						} else if (vo2.getEntry_jumin().substring(6, 7).equals("2")) {
							System.out.println("(��)");
						}
						String jumin = vo2.getEntry_jumin().substring(0, 6);
						Date date = ddf.parse(jumin);
						System.out.println("�������\t" + sdf.format(date));
						if (vo2.getEntry_type().equals("1")) {
							System.out.println("�����ι�\t" + "���");
						} else if (vo2.getEntry_type().equals("2")) {
							System.out.println("�����ι�\t" + "�ο�");
						} else if (vo2.getEntry_type().equals("3")) {
							System.out.println("�����ι�\t" + "����");
						} else if (vo2.getEntry_type().equals("4")) {
							System.out.println("�����ι�\t" + "�ǼҸ�");
						}
						System.out.println("����\t" + vo2.getEntry_area());
						System.out.println(vo2.getRname1() + "\t" + vo2.getScore1());
						System.out.println(vo2.getRname2() + "\t" + vo2.getScore2());
						System.out.println(vo2.getRname3() + "\t" + vo2.getScore3());
						System.out.println(vo2.getRname4() + "\t" + vo2.getScore4());
						System.out.println(vo2.getRname5() + "\t" + vo2.getScore5());
						System.out.println("����\t" + vo2.getS_tot());
						System.out.println("���\t" + vo2.getS_ave());
						return;
					}

				}
			}
			System.out.println("�濬 ������ �������� �ʽ��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectRank() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select et.entry_no, et.entry_name, et.entry_jumin, et.entry_type, et.entry_area, rc.s_tot, rc.s_ave\r\n"
				+ "from tbl_entry_202106 et, tbl_record_202106 rc\r\n" + "where et.entry_no = rc.entry_no\r\n"
				+ "order by s_tot desc, et.entry_no asc";

		try {
			conn = DBManager.getInstance().getDBManger();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<EntryVo> list = new ArrayList<EntryVo>();
			int rank = 1;
			while (rs.next()) {
				EntryVo vo = new EntryVo();
				vo.setEntry_no(rs.getString("entry_no"));
				vo.setEntry_name(rs.getString("entry_name"));
				vo.setEntry_jumin(rs.getString("entry_jumin"));
				vo.setEntry_type(rs.getString("entry_type"));
				vo.setEntry_area(rs.getString("entry_area"));
				vo.setS_tot(rs.getInt("s_tot"));
				vo.setS_ave(rs.getDouble("s_ave"));
				vo.setRank(rank);
				list.add(vo);
				rank++;
			}
			System.out.println("\t\t\t���������ȸ");
			System.out.println("������ȣ\t����\t�������\t\t�����ι�\t����\t����\t���\t���");
			for (EntryVo vo : list) {
				System.out.print(vo.getEntry_no() + "\t");
				System.out.print(vo.getEntry_name());
				if (vo.getEntry_jumin().substring(6, 7).equals("1")) {
					System.out.print("(��)\t");
				} else if (vo.getEntry_jumin().substring(6, 7).equals("2")) {
					System.out.print("(��)\t");
				}
				String jumin = vo.getEntry_jumin().substring(0, 6);
				Date date = ddf.parse(jumin);
				System.out.print(sdf.format(date) + "\t");
				if (vo.getEntry_type().equals("1")) {
					System.out.print("���\t");
				} else if (vo.getEntry_type().equals("2")) {
					System.out.print("�ο�\t");
				} else if (vo.getEntry_type().equals("3")) {
					System.out.print("����\t");
				} else if (vo.getEntry_type().equals("4")) {
					System.out.print("�ǼҸ�\t");
				}
				System.out.print(vo.getEntry_area() + "\t");
				System.out.print(vo.getS_tot() + "\t");
				System.out.print(vo.getS_ave() + "\t");
				System.out.println(vo.getRank());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int max(EntryVo vo) {
		int max = 0;
		int[] array = { vo.getScore1(), vo.getScore2(), vo.getScore3(), vo.getScore4(), vo.getScore5() };
		max = array[0];
		for (int i = 0; i < 5; i++) {
			if (max < array[i]) {
				max = array[i];
			}

		}
		return max;
	}

	public int min(EntryVo vo) {
		int min = 0;
		int[] array = { vo.getScore1(), vo.getScore2(), vo.getScore3(), vo.getScore4(), vo.getScore5() };
		min = array[0];
		for (int i = 0; i < 5; i++) {
			if (min > array[i]) {
				min = array[i];
			}

		}
		return min;
	}
	
	public int tot(EntryVo vo) {
		int tot = 0;
		tot = vo.getScore1() + vo.getScore2() + vo.getScore3() + vo.getScore4() + vo.getScore5();
		return tot;
	}
	
	public double ave(EntryVo vo) {
		double ave = 0;
		ave = (vo.getScore1() + vo.getScore2() + vo.getScore3() + vo.getScore4() + vo.getScore5()) / 5.;
		return ave;
	}
}