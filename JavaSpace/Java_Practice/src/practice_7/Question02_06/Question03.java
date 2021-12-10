package practice_7.Question02_06;

import java.util.*;

public class Question03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		
		List<Integer> list = new ArrayList<>();
		
		System.out.println("list의 원소 정수 10개를 입력하시오.");
		for(int i=0;i<10;i++) {
			list.add(input.nextInt());
		}
		
		removeDuplicate(list);
		
		input.close();
	}

	public static void removeDuplicate(List<Integer> list) {
		Set<Integer> set = new HashSet<>(list);
		List<Integer> uniqueList = new ArrayList<>(set);
		
		for(Integer i : uniqueList) {
			System.out.print(i + " ");
		}
	}
	

//	public static void removeDuplicate(List<Integer> list) {
//		String unique = "";
//		
//		for(Integer i : list) {
//			String s = String.valueOf(i);
//			if(unique.indexOf(s) == -1) {
//				unique += s;
//			}
//		}	
//		char[] uniqueArray = unique.toCharArray();
//
//		for(char c : uniqueArray) {
//			System.out.print(c + " ");
//		}
//	}
}
