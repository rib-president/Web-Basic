package practice_7.Question02_06;

import java.util.*;

public class Question02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		System.out.println("list1의 원소 정수 5개를 입력하시오.");
		for(int i=0;i<5;i++) {
			list1.add(input.nextInt());
		}

		System.out.println("list2의 원소 정수 5개를 입력하시오.");
		for(int i=0;i<5;i++) {
			list2.add(input.nextInt());
		}
		
		List<Integer> unionSet = union(list1, list2);
		
		for(Integer i : unionSet) {
			System.out.print(i + " ");
		}
		
		input.close();
	}
	
	public static List<Integer> union(List<Integer> list1,
										List<Integer> list2) {	
		list1.addAll(list2);
		Set<Integer> unionSet = new HashSet<>(list1);

		return new ArrayList<>(unionSet);
	}
}
