package practice_3;

import java.util.Scanner;

//	console에서 3개의 정수를 읽어 내림차순으로 정렬하여 출력하는 메소드를 만드시오.
public class Question08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("3개의 정수를 입력하시오.");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		
		displaySortedNumbers(num1, num2, num3);
		
		input.close();
	}
	
	public static void displaySortedNumbers(double num1, double num2,
										double num3) {
		double max = 0;
		double mid = 0;
		double min = 0;
		
		if(num1 > num2 && num1 > num3) {
			max = num1;
			if(num2 > num3) {
				mid = num2;
				min = num3;
			} else {
				mid = num3;
				min = num2;
			}
		} else if(num2 > num1 && num2 > num3) {
			max = num2;
			if(num1 > num3) {
				mid = num1;
				min = num3;
			} else {
				mid = num3;
				min = num1;
			}
		} else {
		if(num1 > num2) {
			mid = num1;
			min = num2;
		} else {
			mid = num2;
			min = num1;
			}
		}
		
		System.out.println((int)max + " " + (int)mid + " " + (int)min);
	}
}
