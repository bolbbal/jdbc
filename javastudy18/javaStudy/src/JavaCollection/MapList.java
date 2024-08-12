package JavaCollection;

import java.util.*;

public class MapList {

	public static void main(String[] args) {
		//List¿¡ Map ÀúÀå
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("name", "java01");
		map0.put("score", 100);
		listMap.add(map0);
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "java02");
		map1.put("score", 90);
		listMap.add(map1);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "java01");
		map2.put("score", 95);
		listMap.add(map2);
		
		for(Map<String, Object> list : listMap) {
			System.out.println(list.get("name"));
			System.out.println(list.get("score"));
		}
	}

}
