package p01.basic;

import java.util.Scanner;

// 3개의 데이터를 console에서 키보드로 입력받아, 평균값을 구하여 console에 display할 것
public class ComputeAverage {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 1. 3개의 데이터를 console에서 읽기
		System.out.println("3개의 값을 입력하세요 : ");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		
		// 2. 3개의 데이터를 가지고 평균값 구하기
		double average = (number1 + number2 + number3) / 3; 
		
		// 3. console에 평균값 display 
		System.out.println("3개 숫자인 " + number1 + ", " + number2 +
							", " + number3 + "의 평균값은 " + 
							average + " 입니다.");
		
	}

}
