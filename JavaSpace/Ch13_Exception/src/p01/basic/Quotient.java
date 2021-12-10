package p01.basic;

import java.util.Scanner;

//	num2에 0 입력 시 arithmetic exception 발생
public class Quotient {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("2개 정수값을 입력하세요.");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		
		input.close();
	}
}
