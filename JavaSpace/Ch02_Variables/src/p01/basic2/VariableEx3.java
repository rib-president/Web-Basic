package p01.basic2;

import java.util.Scanner;

public class VariableEx3 {
	public static void main(String[] args) {
		int count = 0;
		double radius = 5;
		double interestRate = 0.1;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("나이를 입력하세요 : ");
		int age = input.nextInt();
		System.out.println("age = " + age);
		
		System.out.println(input.nextInt());
		
		System.out.println("count = " + count);

		System.out.println("interestRate = " + interestRate);

		System.out.println("$radius = " + radius);
	}
}
