package p02.object_class_tostring;

import java.util.Date;

public class ToStringEx {
	public static void main(String[] args) {
		Object obj1 = new Object();
		String name = "홍길동";
		Date date = new Date();
		
		System.out.println(System.identityHashCode(obj1));
		
		System.out.println(obj1.toString());
		System.out.println(obj1);

		System.out.println(name.toString());
		System.out.println(name);
		
		System.out.println(date.toString());
		System.out.println(date);
	}
}
