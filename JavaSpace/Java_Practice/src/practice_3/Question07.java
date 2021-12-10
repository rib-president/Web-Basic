package practice_3;

import java.util.Scanner;

//	매월 적금 금액, 월 이자율, 적금 기간을 이용하는 적금을 계산하는 메소드를 만들어라
public class Question07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("매월 적금 금액> ");
		double amount = input.nextDouble();
		
		System.out.print("연 이자율> ");
		double annualRate = input.nextDouble();
		double monthlyRate = (annualRate / 12) * 0.01;
		
		System.out.print("적금 기간(월단위)> ");		
		int numOfMonths = input.nextInt();
		
		double totalSavings = calculateSavings(amount, monthlyRate,
												numOfMonths);
		totalSavings = (double)Math.round(totalSavings*100)/100;
		System.out.println("총 " + numOfMonths + "개월이 지난 후의 적금액"
				+ "(원금 + 이자 총액) = " + totalSavings + "원 입니다.");

		input.close();
	}
	
	public static double calculateSavings(double amount,
			double monthlyRate, int numOfMonths) {
		double savings = 0;
		for(int i=0;i<numOfMonths;i++) {
			savings = (savings + amount) * (monthlyRate + 1);
		}
		return savings;
	}
}