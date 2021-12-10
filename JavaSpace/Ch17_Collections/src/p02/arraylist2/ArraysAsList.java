package p02.arraylist2;

import java.util.*;

public class ArraysAsList {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동", "김자바", "신용권");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		
		for(int number : numbers) {
			System.out.println(number);
		}
	}
}
