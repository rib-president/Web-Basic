package p01.basic;

//	문자열을 비교 (==, <, >)
//	1.문자열 내용 같은지 비교(==) : s1.equals(s2) 사용 => s1과 s2의 내용이
//	같으면 true가 되고 틀리면 false가 됨
//	-단, 문자열 내용이 같은지를 비교할 때 '=='를 사용하면 안됨 
//	2. == : String 등 참조타입에도 사용은 가능 => 참조하는 객체가 같다 의미
//	3.문자열이 어느 것이 큰지 비교(>, <) : s1.compareTo(s2) 메소드 사용
//	-s1과 s2중에 s1이 큰 경우 => compareTo의 실행 결과가 양의 정수( > 0)
//	-s1과 s2중에 s2가 큰 경우 => compareTo의 실행 결과가 음의 정수( < 0)
//	-s1과 s2가 같은 경우 => compareTo의 실행 결과가 양의 정수( == 0)
public class StringBasic7 {
	public static void main(String[] args) {
		String s1 = "Welcome to Java";
		String s2 = "Welcome to Java";
		String s3 = "Welcome to C++";
		
		if (s1.equals(s2)) {
			System.out.println("s1과 s2 문자열 contents(내용)이 같습니다.");
		} else {
			System.out.println("s1과 s2 문자열 contents(내용)이 다릅니다.");
		}

		if (s2.equals(s3)) {
			System.out.println("s2과 s3 문자열 contents(내용)이 같습니다.");
		} else {
			System.out.println("s2과 s3 문자열 contents(내용)이 다릅니다.");
		}
	
		if (s1 == s2) {
			System.out.println("s1과 s2 객체가 서로 같습니다.");
		} else {
			System.out.println("s1과 s2 객체가 서로 다릅니다.");
		}
		
		String s4 = "apple";
		String s5 = "banana";
		String s6 = "pineapple";
		
		System.out.println(s4 + "와 " + s5 + " 크기비교 결과 "+ 
						s4.compareTo(s5));
		System.out.println(s5 + "와 " + s4 + " 크기비교 결과 "+ 
				s5.compareTo(s4));
		System.out.println(s4 + "와 " + s6 + " 크기비교 결과 "+ 
				s4.compareTo(s6));
		System.out.println(s6 + "와 " + s4 + " 크기비교 결과 "+ 
				s6.compareTo(s4));
		System.out.println(s5 + "와 banana 크기비교 결과 "+ 
				s5.compareTo("banana"));
		System.out.println("kiwi와 orange 크기비교 결과 "+ 
				"kiwi".compareTo("orange"));
		
		
	}
}
