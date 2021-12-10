package practice_3;

import java.util.Scanner;

//	console에서 정수를 입력 받아 입력된 정수값이 역순으로된 정수를 구하는 메소드를 만드시오.
public class Question10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수를 입력하시오.");
		int number = input.nextInt();
		reverse(number);
		
		input.close();
	}
	
	public static void reverse(int number) {
		int result = 0;
				
		while(number > 0) {
			result += number % 10;
			result *= 10;
			number = number / 10;
		}
		System.out.print("reverse => " + (result/10) + "입니다.");	
	}
}
