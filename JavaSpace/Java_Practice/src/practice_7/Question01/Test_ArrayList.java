package practice_7.Question01;

import java.util.*;

public class Test_ArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("복숭아");	// 0
		list.add("포도");		// 1
		list.add("참외");		// 2
		list.add("사과");		// 3
		list.add("바나나");	// 4
		list.add("키위");		// 5
		list.add("포도");		// 6	List는 중복허용
		list.add("포도");		// 7
		
		System.out.println("요소갯수 : " + list.size());
		
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) {	// 데이터가 존재하는한 반복수행
			System.out.println(iter.next());	// 요소를 얻어내어 출력
		}// while
		
		System.out.println();
	}
}
