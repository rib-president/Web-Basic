package p01.basic;

//	문자열 합치기
//	1.concat method를 사용
//	=>예로 s1.concat(s2) => 합쳐지는 순서는 s1 앞 s2가 뒤로 합쳐짐
//	2.산술연산자인 '+'를 사용하는 것도 가능
public class StringBasic4 {
	public static void main(String[] args) {
		String s1 = "Welcome to ";
		String s2 = "Java";
		String s3;
		
		s3 = s1.concat(s2);
		System.out.println("합친 문자열 s3는 " + s3);
		System.out.println("s1의 길이 = " + s1.length());
		System.out.println("s2의 길이 = " + s2.length());
		System.out.println("s3의 길이 = " + s3.length());
	
		s3 = s2.concat(s1);
		System.out.println("합친 문자열 s3는 " + s3);
		
		s3 = s1 + s2;
		System.out.println("합친 문자열 s3는 " + s3);		

		s3 = s2 + s1;
		System.out.println("합친 문자열 s3는 " + s3);		
	}
}
