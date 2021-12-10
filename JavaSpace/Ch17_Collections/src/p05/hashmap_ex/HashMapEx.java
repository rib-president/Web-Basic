package p05.hashmap_ex;

import java.util.*;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("찾고 싶은 단어는?");
			String word = input.next();
			if (word.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			String kor = dic.get(word);
			if(kor == null) {
				System.out.println(word + "는 한글이 없는 단어입니다.");
			} else {
				System.out.println(kor);
			}
		}
		input.close();
	}
}
