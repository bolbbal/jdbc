package JavaCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberDao {
	//crud작업 처리를 하기위한 메서드 집합
	
	ArrayList<MemberVo> list = new ArrayList<MemberVo>(); 
	Scanner sc = new Scanner(System.in);
	int id = 0;
	
	public void insert() {
		System.out.print("이름 전화번호 이메일 직급(10 = 이사, 20 = 부장, 30 = 과장) : ");
		
		String name = sc.next();
		String tel = sc.next();
		String email = sc.next();
		int code = sc.nextInt();
		int salaly = 0;
		
		MemberVo vo = new MemberVo();
		id++;
		
		vo.setId(id);
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setCode(code);
		salaly = calSalaly(code);
		vo.setSalaly(salaly);
		
		
		list.add(vo);
	}
	
	public void printMember() {
		int acount = 0;
		int bcount = 0;
		int ccount = 0;
		int asalaly = 500;
		int bsalaly = 400;
		int csalaly = 300;
		
		System.out.println("회원번호\t이름\t전화번호\t이메일\t직급\t급여");
		for (MemberVo vo : list) {
			System.out.print(vo.getId() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getTel() + "\t");
			System.out.print(vo.getEmail() + "\t");
			if (vo.getCode() == 10) {
				acount++;
				System.out.print("이사" + "\t");
				//System.out.println(vo.getSalaly());
			} else if (vo.getCode() == 20) {
				bcount++;
				System.out.print("부장" + "\t");
				//System.out.println(vo.getSalaly());
			} else if (vo.getCode() == 30) {
				ccount++;
				System.out.print("과장" + "\t");
				//System.out.println(vo.getSalaly());
			}
			System.out.println(vo.getSalaly() + "\t");
		}
		System.out.println("이사 인원 수 : " + acount);
		System.out.println("부장 인원 수 : " + bcount);
		System.out.println("과장 인원 수 : " + ccount + "\n");
		System.out.println("이사 총 급여 : " + (acount * asalaly));
		System.out.println("부장 총 급여 : " + (bcount * bsalaly));
		System.out.println("과장 총 급여 : " + (ccount * csalaly));
	}
	
	public void memberDelete() {
		System.out.print("삭제할 번호를 입력하세요 >> ");
		int id = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				list.remove(i);
				System.out.println("해당 데이터를 삭제했습니다.");
				return;
			}
		}
		System.out.println("해당하는 데이터가 없습니다.");
//		for (MemberVo vo : list) {
//			if(vo.getId() == id) {
//				list.remove(index);
//			}
//		}
	}
	
	public void memberModify() {
		System.out.print("변경하고 싶은 회원의 번호를 입력하세요 >> ");
		int id = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				System.out.println("변경 전 데이터");
				System.out.print("전화번호 : " + list.get(i).getTel());
				System.out.println(", 이메일 : " + list.get(i).getEmail());
				System.out.print("변경할 전화 입력 : ");
				String tel = sc.next();
				list.get(i).setTel(tel);
				System.out.print("변경할 이메일 입력 : ");
				String email = sc.next();
				list.get(i).setEmail(email);
				return;
			} 
		}
		System.out.println("해당하는 데이터가 없습니다.");
	}
	
	public void memberSelect() {
		System.out.print("검색하고 싶은 회원의 번호를 입력하세요 >> ");
		int id = sc.nextInt();
		System.out.println("회원번호\t이름\t전화번호\t이메일");
		for (MemberVo vo : list) {
			if (vo.getId() == id) {
				System.out.print(vo.getId() + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getTel() + "\t");
				System.out.println(vo.getEmail() + "\t");
				return;
			}
		}
		System.out.println("해당하는 데이터가 없습니다.");
	}
	
	public int calSalaly(int code) {
		int salaly = 0;
		if (code == 10) {
			salaly = 500;
		} else if (code == 20) {
			salaly = 400;
		} else if (code == 30) {
			salaly = 300;
		}
		return salaly;
		
	}
}
