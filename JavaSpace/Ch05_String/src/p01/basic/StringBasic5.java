package p01.basic;

//	String 문자열 합치기 연산자인 '+'에 대해 상세 실습
public class StringBasic5 {
	public static void main(String[] args) {
		String s1 = "Java";
		double pi = 3.14159;
		
		System.out.println("s1의 길이 = " + s1.length());
		s1 = s1 + 5;
		System.out.println("s1의 길이 = " + s1.length());
		System.out.println("s1 문자열 " + s1);
		
		s1 = s1 + pi;
		System.out.println("s1의 길이 = " + s1.length());
		System.out.println("s1의 문자열 " + s1);
		
		s1 = 3 + 3 + "Java";
		System.out.println("s1 문자열 " + s1);
		
		s1 = "Java" + 3 + 3;
		System.out.println("s1 문자열 " + s1);
		
	}
}
