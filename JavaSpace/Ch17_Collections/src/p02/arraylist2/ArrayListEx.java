package p02.arraylist2;

import java.util.*;

public class ArrayListEx {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBatis");
		
		System.out.println("전체 개수는 : " + list.size());
		
		for(String s : list) {
			System.out.println(s);
		}
		
		list.remove(2);
		list.remove(2);
		list.remove("iBatis");

		System.out.println();
		System.out.println("전체 개수는 : " + list.size());

		for(String s : list) {
			System.out.println(s);
		}
	}
}
