package p01.basic;

//	문자열에서 일부 문자열을 가져오기
//	1.substring(startindex, endindex) method
//		- startindex는 포함, endindex의 문자는 미포함
//	2.substring(startindex) method
//		- startindex부터 문자열 끝까지
public class StringBasic8 {
	public static void main(String[] args) {
		String message = "Welcome to Java";

		System.out.println(message.substring(0, 5));
		System.out.println(message.substring(0, 7));
		System.out.println(message.substring(0, 11));
		
		System.out.println(message.substring(2, 5));
		System.out.println(message.substring(2, 7));
		System.out.println(message.substring(2, 11));

		System.out.println(message.substring(0));
		System.out.println(message.substring(2));

	}
}
