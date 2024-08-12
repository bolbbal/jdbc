package JavaCollection;

import java.util.*;

class Vo {
	String name;
	int score;
	int rank;
	
}
public class ListMap {
	
	public static void main(String[] args) {
		//Mapø° List ¿˙¿Â
		Map<String, Object> map = new HashMap<String, Object>();
		List<Vo> list = new ArrayList<Vo>();
		
		Vo vo1 = new Vo();
		vo1.name = "java01";
		vo1.score = 100;
		vo1.rank = 1;
		
		Vo vo2 = new Vo();
		vo2.name = "java02";
		vo2.score = 90;
		vo2.rank = 1;
		
		Vo vo3 = new Vo();
		vo3.name = "java03";
		vo3.score = 80;
		vo3.rank = 1;
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		map.put("maplist", list);
		
		ArrayList<Vo> dto = (ArrayList<Vo>) map.get("maplist");
		
		for(Vo v1 : dto) {
			for(Vo v2 : dto) {
				if(v1.score < v2.score) {
					v1.rank++;
				}
				
			}
		}
		
		for(Vo vo : dto) {
			System.out.println(vo.name);
			System.out.println(vo.score);
			System.out.println(vo.rank);
		}
	}

}
