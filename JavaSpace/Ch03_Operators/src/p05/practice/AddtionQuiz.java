package p05.practice;

import java.util.Scanner;

public class AddtionQuiz {
	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		int num1 = (int)(currentTimeMillis % 10);
		int num2 = (int) (currentTimeMillis / 10 % 10);
		
		System.out.println("currentTimeMillis = " + currentTimeMillis);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("숫자 " + num1 + "과 숫자 " + num2 + 
				"의 합계는 얼마인가 ?");
		int answer = input.nextInt();
		boolean bCorrect = ((num1 + num2) == answer);
		System.out.println(num1 + " + " + num2 + " = " + answer
				+ "가 맞는가 ? " + bCorrect);

	}
}
