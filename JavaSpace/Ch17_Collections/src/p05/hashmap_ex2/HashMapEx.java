package p05.hashmap_ex2;

import java.util.*;

public class HashMapEx {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 92);
		
		System.out.println("총 Entry 수 : " + map.size());
		
	}
}
