package practice_1;

import java.util.Scanner;

//	매월 적금 금액과 1년 이자율을 키보드에서 읽어
//	6개월 후의 이자와 원금을 합한 총금액을 출력하시오.
public class Question03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("매월 적금 금액을 입력하시오.");
		int credit = input.nextInt();
		System.out.println("1년 이자율을 입력하시오.");
		int annualInterestRate = input.nextInt();
		double monthlyInterestRate = (annualInterestRate / 12.0)
				* 0.01;
		
		double balance = 0;
		
		for (int i=6;i>0;i--) {
			balance = (credit+balance) * (1 + monthlyInterestRate);
		}
		
		System.out.println("6개월 후의 총 적금 금액은 " + balance + 
				"원 입니다.");
	}
}
