package p03.linkedlist;

import java.util.*;

public class LinkedListEx {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 소요시간 : " + (endTime-startTime));

	
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 소요시간 : " + (endTime-startTime));

	}
}
