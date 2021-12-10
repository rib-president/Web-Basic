package p02.datatypes.basic;

// char : 문자 한글자를 관리하기 위한 타입
// 1. 문자열을 이루는 문자 한 글자를 관리함(예: 문자열 "홍길동"은
//	char 문자인 "홍", "길", "동")
// 2. ASCII (American Standard Code Information Interchange)
//		- 컴퓨터에서 영문자, 숫자, 특수기호들을 이진수로 표현한 것임
//		- 1950년대에는 영문자 (대문자 26, 소문자 26)를 이진수로 표현하였음
public class CharEx {

	public static void main(String[] args) {
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';		// unicode
		
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';		// unicode
		
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);

		System.out.println("c4 = " + c4);
		System.out.println("c5 = " + c5);
		System.out.println("c6 = " + c6);

	}

}
