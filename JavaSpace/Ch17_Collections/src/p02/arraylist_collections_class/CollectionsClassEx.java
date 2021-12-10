package p02.arraylist_collections_class;

import java.util.*;

public class CollectionsClassEx {
	public static void main(String[] args) {
		Integer[] numbers = {1123, 1412, 23, 44, 512132};
		List<Integer> list = Arrays.asList(numbers);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, 44));
		
		List<Integer> list1 = Arrays.asList(121, 23532, 123, 1, 41234);
		System.out.println(Collections.disjoint(list,  list1));
		
		List<Integer> source = new ArrayList<>();
		source.add(100);
		source.add(23);
		
		Collections.copy(list1, source);
		System.out.println(list1);
		
		Collections.reverse(list1);
		System.out.println(list1);
		
	}
}
