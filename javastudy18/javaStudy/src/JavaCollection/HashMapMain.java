package JavaCollection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		//HashMap<K, V>
		//키와 값의 쌍으로 구성된 요소를 다루는 컬렉션
		//인덱스를 이용하여 요소에 접근할 수 없고, 값을 검색하기 위해서는 반드시 키를 사용해야한다.
		//요소 삽입 : put(), 요소 검색 : get()
		
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("찾고 싶은 단어 입력 : ");
			String eng = sc.next();
			if(eng.equals("quit")) {
				//출력1
				Set<String> keySet = dic.keySet(); //key를 가져옴
				for(String key : keySet) {
					System.out.println(key + " : " + dic.get(key));
				}
				
				//출력2
				Collection<String> values = dic.values(); //value를 가져옴
				System.out.println(values);
				
				//출력3
				dic.forEach((key,value) -> { // -> 람다식
					System.out.println(key + " : " + value);
				});
				
				System.out.println("종료!");
				break;
			}
			
			String kor = dic.get(eng); //eng key를 호출하면 value값을 리턴해 준다.
			if(kor == null) {
				System.out.println(eng + "는 없는 단어");
			} else {
				System.out.println(kor);
			}
		}

	}

}
