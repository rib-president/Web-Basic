package p11.arrays_method;

import java.util.Arrays;

public class SortEx {
	public static void main(String[] args) {
		int[] scores = {99, 95, 44, 97, 98};
		
		// 정렬전 scores 출력
		for(int i=0;i<scores.length;i++) {
			System.out.println("scores[" + i + "]=" + scores[i]);
		}
		System.out.println();
		Arrays.sort(scores);
		
		// 정렬 후 scores 출력
		for(int i=0;i<scores.length;i++) {
			System.out.println("scores[" + i + "]=" + scores[i]);
		}
		
		System.out.println();
		
		String[] names = {"홍길동", "박동수", "김민수"};
		Arrays.sort(names);

		for(int i=0;i<names.length;i++) {
			System.out.println("names[" + i + "]=" + names[i]);
		}
		
		System.out.println();
		
		Member[] members = {
				new Member("홍길동"),
				new Member("박동수"),
				new Member("김민수")
		};
		Arrays.sort(members);

		for(int i=0;i<members.length;i++) {
			System.out.println("members[" + i + "].name=" + members[i].name);
		}
		
		
	}
}
