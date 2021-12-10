package p01.basic;

import java.util.Scanner;

//	예외처리코드 작성
public class QuotientWithException {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("2개 정수값을 입력하세요.");
		int num1 = input.nextInt();
		int num2 = input.nextInt();

		try {
			int result = quotient(num1, num2);
			//	정상적으로 프로그램 실행
			System.out.println(num1 + " / " + num2 + " = " + result);
			
		} catch(ArithmeticException e) {
			//	예외 발생시 실행하는 코드
//			System.out.println("Exception 발생 : 분모에 정수 0을 사용하여 나누기 실행");
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 계속 실행");
		
		
		input.close();
	}
	
	public static int quotient(int num1, int num2) {
		if(num2 == 0) {
			throw new ArithmeticException("분모에 해당하는 정수에 0을 사용할 수 없습니다.");
		} 

		return num1 / num2;
	}
}
