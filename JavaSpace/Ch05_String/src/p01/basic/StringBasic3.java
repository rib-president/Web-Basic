package p01.basic;

//	문자열에서 특정 문자를 가져오는 방법
//	1.charAt(index) 메소드 사용
//		- index는 0부터 시작(첫번째 문자가 0, 두번째 문자는 1,~~~)
public class StringBasic3 {
	public static void main(String[] args) {
		String message = "Welcome to Java";
		int length = message.length();
		
		char firstChar = message.charAt(0);
		char thirdChar = message.charAt(2);
		char lastChar = message.charAt(length-1);
		
		System.out.println(message + "의 첫번째 글자는 " + firstChar
				 + " 입니다.");
		System.out.println(message + "의 세번째 글자는 " + thirdChar
				 + " 입니다.");
		System.out.println(message + "의 마지막 글자는 " + lastChar
				 + " 입니다.");
		
		// message의 모든 글자를 출력
		for (int i=0;i<length;i++) {
			System.out.println(message + "의 " + (i+1) + "번째 글자는 " +
			message.charAt(i) + " 입니다.");
		}
	}
}
