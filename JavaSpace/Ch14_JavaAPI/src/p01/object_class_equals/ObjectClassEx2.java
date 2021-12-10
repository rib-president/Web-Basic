package p01.object_class_equals;

public class ObjectClassEx2 {
	public static void main(String[] args) {
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 = "홍길동1";
		String s4 = new String("홍길동");
		String s5 = new String("홍길동");
		
		boolean result;
		
		result = (s1 == s2);
		System.out.println("s1 == s2 : " + result);
		
		result = (s1 == s3);
		System.out.println("s1 == s3 : " + result);

		result = (s4 == s5);
		System.out.println("s4 == s5 : " + result);
		
		System.out.println("s1.equals(s2) :  "  + s1.equals(s2));
		System.out.println("s1.equals(s3) :  "  + s1.equals(s3));
		System.out.println("s4.equals(s5) :  "  + s4.equals(s5));
	}
}
