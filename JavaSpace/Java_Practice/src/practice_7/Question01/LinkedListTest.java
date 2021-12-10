package practice_7.Question01;

import java.util.*;

public class LinkedListTest {
	public static void main(String[] args) {
		//LinkedList => LinkedList<T>
		List<Character> lList = new LinkedList<>();
		
		lList.add(new Character('a'));
		lList.add(new Character('b'));
		lList.add(new Character('c'));
		
		for(int i=0;i<lList.size();i++) {
			System.out.print(lList.get(i) + "\t");
		}
		
		System.out.println();
		
		// 반복자를 통한 출력
		Iterator<Character> iter = lList.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + "\t");
		}
	}
}
