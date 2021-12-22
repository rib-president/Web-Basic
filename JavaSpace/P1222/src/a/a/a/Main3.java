package a.a.a;

import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		List<String> arr = new LinkedList<>();
		
		arr.add("안녕하세요1");
		arr.add("안녕하세요2");
		arr.add("안녕하세요3");
		arr.add("안녕하세요4");
		arr.add("안녕하세요5");
		
		for(String e : arr) {
			System.out.println(e);
		}
		
		Object a = 10;
		Object b = 10.1234;
		Object c = 'a';
		Object d = "안녕하세요";
		Object e = new ArrayList<String>();
		
		Object[] f = new Object[10];
		f[0] = 1;
		f[1] = "dddd";
		f[2] = -3.233;
		f[3] = true;
		f[4] = new Scanner(System.in);
	}
}
