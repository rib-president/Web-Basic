package p02.arraylist;

import java.util.*;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			System.out.println("이름을 입력하세요.");
			String name = input.next();
			a.add(name);
		}
		
		for(String name : a) {
			System.out.println("입력된 이름 :" + name);
		}
		
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println("Iterator name : " + name);
		}
		
		input.close();
	}
}
