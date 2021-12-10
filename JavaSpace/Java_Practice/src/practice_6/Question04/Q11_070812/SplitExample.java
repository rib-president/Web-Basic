package practice_6.Question04.Q11_070812;

import java.util.StringTokenizer;

public class SplitExample {
	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		String[] strArr = str.split(",");
		for(String st : strArr) {
			System.out.println(st);
		}
		
		System.out.println();
		
		StringTokenizer st = new StringTokenizer(str, ",");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
