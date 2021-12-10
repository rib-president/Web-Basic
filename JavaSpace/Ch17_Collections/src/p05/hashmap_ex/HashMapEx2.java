package p05.hashmap_ex;

import java.util.*;

public class HashMapEx2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 75);
		
		System.out.println("총 entry 수: " + map.size());
		
		System.out.println("홍길동 점수 : " + map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator1 = keySet.iterator();
		while(iterator1.hasNext()) {
			String key = iterator1.next();
			Integer value = map.get(key);
			System.out.println("key : " + key + ", value : " + value);
		}
		System.out.println();
		
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.println("key : " + key + ", value : " + value);
		}
		
		System.out.println();
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator2 = entrySet.iterator();
		while(iterator2.hasNext()) {
			Map.Entry<String, Integer> entry = iterator2.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key : " + key + ", value : " + value);	
		}

		System.out.println();
		
		for(Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key : " + key + ", value : " + value);	
		}
		
		System.out.println();
		
		map.forEach((key, value) -> {System.out.println("key : " + key + ", value : " + value);});
		
		System.out.println();
		
		map.clear();
		System.out.println("총 entry 수 : " + map.size());
		
	}
}
