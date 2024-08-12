package JavaCollection;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		//컬렉션 프레임 워크★★
		//다수의 객체를 다루기 위한 표준화된 프로그래밍 방식
		//객체들의 저장소는 자동 조절이 된다
		//삽입, 삭제에 따른 요소의 위치는 자동 처리된다
		//고정크기의 배열을 다루는 어려움을 해소했다.
		//다양한 객체들의 삽입, 삭제, 검색 등의 작업을 쉽게 처리할 수 있다.
		
		//인터페이스 종류
		//List와 Set의 부모 인터페이스는 Collection 이다.
		
		//List : 순서가 있는 데이터의 집합, 데이터의 중복은 허용 예)대기자 명단
			//구현 클래스 : ArrayList, LinkdList, Stack, Vector
		//Set : 순서를 유지하지 않는 데이터의 집합, 데이터의 중복 허용x
			//예)양의 정수의 집합, 소수의 집합
			//구현 클래스 : HashSet, TreeSet
		//Map : 키(key)와 값(Value)의 쌍으로 이루어진 데이터 집합
			//순서는 유지되지 않고, 키는 중복을 허용하지 않고, 값은 중복을 허용한다
			//예)우편번호, 지역번호(전화번호)
			//구현 클래스 : HashMap, TreeMap, HashTable, Properties
			
		//컬렉션은 제네릭 기법으로 구현한다
		//컬렉션의 요소는 객체만 가능하다. 기본 타입은 사용 불가 => Wrapper 클래스 변환(AutoBoxing)
		
		//제네릭(Generices)이란
		//모든 종류의 데이터 타입을 다룰 수 있도록 일반화된 타입 매개 변수로 클래스나 메서드를 작성하는 기법
		//타입 매개 변수 : ArrayList<Point>. ArrayList<Student>, ArrayList<People>
		
		//StudentVo 객체를 저장하기 위한 가변배열
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		//ArrayList에 담을 객체 생성
		StudentVo svo = new StudentVo();
		svo.id = "1";
		svo.name = "홍길동";
		svo.age = "500";
		//생성된 객체를 가변배열에 저장 => add()
		list.add(svo);
		
		StudentVo svo1 = new StudentVo();
		svo1.id = "2";
		svo1.name = "박길동";
		svo1.age = "200";
		list.add(svo1);
		
		list.remove(0);
		//출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).id + "\t");
			System.out.println(list.get(i).name + "\t");
			System.out.println(list.get(i).age + "\t");
			System.out.println();
		}
		
		//향상된 for
		for (StudentVo vo : list) {
			System.out.println(vo.id + "\t");
			System.out.println(vo.name + "\t");
			System.out.println(vo.age + "\t");
		}
		

	}

}
