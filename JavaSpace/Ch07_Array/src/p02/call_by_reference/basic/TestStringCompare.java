package p02.call_by_reference.basic;

public class TestStringCompare {
	public static void main(String[] args) {
		String s1 = "Welcome to Java";
		String s2 = "Welcome to Java";
		String s3 = "Welcome to C++";
		int num1 = 1;
		int num2 = 3;

		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		
		//	s1과 s2의 실제 값을 비교
		if (s1.equals(s2)) {
			System.out.println("s1과 s2 문자열 contents(내용)이 같습니다.");
		} else {
			System.out.println("s1과 s2 문자열 contents(내용)이 다릅니다.");			
		}

		// stack의 값인 주소값을 서로 비교
		if (s1 == s2) {
			//	객체 : heap memory에 생성된 객체
			//	s1과 s2 객체가 서로 같습니다. => heap memory의 객체가 서로 동일
			System.out.println("s1과 s2 객체가 서로 같습니다.");
		} else {
			System.out.println("s1과 s2 객체가 서로 다릅니다.");			
		}
		
		if (num1 == num2) {
			System.out.println("num1과 num2의 값이 서로 같습니다.");
		} else {
			System.out.println("num1과 num2의 값이 서로 다릅니다.");			
		}		
	
	}
}
