package practice_2;

import java.util.Scanner;

//	매월 적금 금액과 1년 이자율, 납입 개월을 키보드로부터 입력 받아 적금 만기시
//	받는 이자와 원금을 합한 총금액을 출력하시오.
public class Question07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("매월 적금 금액을 입력하시오.");
		int payment = input.nextInt();
		
		System.out.println("연이자율을 입력하시오.");
		double annualInterestRate = input.nextDouble();
		double monthlyInterestRate = (annualInterestRate / 12.0) * 0.01;
		
		System.out.println("총 납입개월을 입력하시오.");
		int month = input.nextInt();
		
		double balance = 0;	// 잔고
		
		for (int i=1;i<=month;i++) {
			balance = (balance + payment)*(1 + monthlyInterestRate);
		}
		
		System.out.println(month + "개월 후 총금액은 = " + balance + 
				"원 입니다.");
		input.close();
	
	}
}
