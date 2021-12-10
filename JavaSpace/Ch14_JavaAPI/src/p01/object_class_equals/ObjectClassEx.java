package p01.object_class_equals;

public class ObjectClassEx {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		
		boolean result1 = obj1.equals(obj2);
		System.out.println("result1 = " + result1);
		
		boolean result2 = (obj1 == obj2);
		System.out.println("result2 = " + result2);
		
	}
}
