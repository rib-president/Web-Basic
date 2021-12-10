package practice_1;

import java.util.Scanner;

//	2개의 정수를 키보드로부터 읽어 덧셈, 빼기, 곱하기, 평균, 최대값, 최소값을 구해
//	출력하시오.
public class Question05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("2개의 정수를 입력하시오.");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		System.out.println("덧셈 : " + (num1 + num2));
		System.out.println("뺄셈 : " + (num1 - num2));
		System.out.println("곱하기 : " + (num1 * num2));
		System.out.println("평균 : " + ((num1 + num2)/2));
		
		if (num1 > num2) {
			System.out.println("최대값 : " + num1);
			System.out.println("최소값 : " + num2);			
		} else {
			System.out.println("최대값 : " + num2);
			System.out.println("최소값 : " + num1);
		}			
	}
}
