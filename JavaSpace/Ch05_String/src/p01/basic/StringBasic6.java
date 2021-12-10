package p01.basic;

import java.util.Scanner;

//	문자열을 console에서 읽기
//	1.console에서 단어 단위로 읽기 => Scanner class의 method 중에 next()
//	사용 : space를 단어 사이의 구분자로 삼음
//	2.console에서 1 line 단위로 읽기 => Scanner class의 method 중에
//	nextLine() 사용
//	영어로 된 문자열을 대문자로 변환, 소문자로 변환
//	toUppercase(), toLowercase()
public class StringBasic6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		
		System.out.println("space로 구분된 3개의 단어를 입력하세요.");
		String s1 = input.next();
		String s2 = input.next();
		String s3 = input.next();
		
		input.nextLine();
		System.out.println("1줄을 입력하세요.");
		String s4 = input.nextLine();
		
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);		
		System.out.println("s4 = " + s4);
		
		System.out.println("s4 대문자로 출력 = " + s4.toUpperCase());
		System.out.println("s4 소문자로 출력 = " + s4.toLowerCase());
		
		input.close();
	}
}
