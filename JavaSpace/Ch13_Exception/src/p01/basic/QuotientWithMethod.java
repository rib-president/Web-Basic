package p01.basic;

import java.util.Scanner;

//	num2가 0인지 체크하는 로직을 method에 작성
public class QuotientWithMethod {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("2개 정수값을 입력하세요.");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		int result = quotient(num1, num2);
		
		System.out.println(num1 + " / " + num2 + " = " + result);
		
		input.close();
	}
	
	public static int quotient(int num1, int num2) {
		if(num2 == 0) {
			System.out.println("분모에 해당하는 정수에 0을 사용할 수 없습니다.");
			System.exit(1);
		} 
		return num1 / num2;
	}
}
