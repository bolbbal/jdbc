package javaJDBCentry;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EntryDao {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat ddf = new SimpleDateFormat("yyMMdd");
	SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일");

	public void insertEntry() {
		EntryVo vo = new EntryVo();
		System.out.println(">>경영점수 등록 화면");
		System.out.print("참가 번호 : ");
		String entryNo = sc.next();
		System.out.println("심사위원 점수 등록");
		System.out.print("김심사 점수 : ");
		int score1 = sc.nextInt();
		System.out.print("이심사 점수 : ");
		int score2 = sc.nextInt();
		System.out.print("박심사 점수 : ");
		int score3 = sc.nextInt();
		System.out.print("황심사 점수 : ");
		int score4 = sc.nextInt();
		System.out.print("조심사 점수 : ");
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
		
		System.out.print("등록여부 [Y/N]");
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
		System.out.print("참가번호를 입력하세요 : ");
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
						System.out.println("참가번호:" + vo2.getEntry_no() + " 님의 경연결과조회");
						System.out.println("참가번호\t" + vo2.getEntry_no());
						System.out.print("성명\t" + vo2.getEntry_name());
						if (vo2.getEntry_jumin().substring(6, 7).equals("1")) {
							System.out.println("(남)");
						} else if (vo2.getEntry_jumin().substring(6, 7).equals("2")) {
							System.out.println("(여)");
						}
						String jumin = vo2.getEntry_jumin().substring(0, 6);
						Date date = ddf.parse(jumin);
						System.out.println("생년월일\t" + sdf.format(date));
						if (vo2.getEntry_type().equals("1")) {
							System.out.println("참가부문\t" + "기악");
						} else if (vo2.getEntry_type().equals("2")) {
							System.out.println("참가부문\t" + "민요");
						} else if (vo2.getEntry_type().equals("3")) {
							System.out.println("참가부문\t" + "무용");
						} else if (vo2.getEntry_type().equals("4")) {
							System.out.println("참가부문\t" + "판소리");
						}
						System.out.println("지역\t" + vo2.getEntry_area());
						System.out.println(vo2.getRname1() + "\t" + vo2.getScore1());
						System.out.println(vo2.getRname2() + "\t" + vo2.getScore2());
						System.out.println(vo2.getRname3() + "\t" + vo2.getScore3());
						System.out.println(vo2.getRname4() + "\t" + vo2.getScore4());
						System.out.println(vo2.getRname5() + "\t" + vo2.getScore5());
						System.out.println("총점\t" + vo2.getS_tot());
						System.out.println("평균\t" + vo2.getS_ave());
						return;
					}

				}
			}
			System.out.println("경연 점수가 존재하지 않습니다.");
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
			System.out.println("\t\t\t최종등수조회");
			System.out.println("참가번호\t성명\t생년월일\t\t참가부문\t지역\t총점\t평균\t등수");
			for (EntryVo vo : list) {
				System.out.print(vo.getEntry_no() + "\t");
				System.out.print(vo.getEntry_name());
				if (vo.getEntry_jumin().substring(6, 7).equals("1")) {
					System.out.print("(남)\t");
				} else if (vo.getEntry_jumin().substring(6, 7).equals("2")) {
					System.out.print("(여)\t");
				}
				String jumin = vo.getEntry_jumin().substring(0, 6);
				Date date = ddf.parse(jumin);
				System.out.print(sdf.format(date) + "\t");
				if (vo.getEntry_type().equals("1")) {
					System.out.print("기악\t");
				} else if (vo.getEntry_type().equals("2")) {
					System.out.print("민요\t");
				} else if (vo.getEntry_type().equals("3")) {
					System.out.print("무용\t");
				} else if (vo.getEntry_type().equals("4")) {
					System.out.print("판소리\t");
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
