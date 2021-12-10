package p01.if_practice;

import java.util.Scanner;

//	2개의 정수로부터 읽어 뺄셈 연산 수행 => 결과 값을 항상 양의 정수로 출력하고 싶음
//	random으로 정수값 생성 : Math.random() 0 ~ 9 사이의 정수
public class SubtractionQuiz {
	public static void main(String[] args) {
		int number1 = (int)(Math.random() * 10);
		int number2 = (int)(Math.random() * 10);
//		double randomNum;
		
//		Math.random() => 0과 1사이의 실수값, 즉 random 숫자를 자동 생성
//		randomNum = Math.random();
//		number1 = (int)(randomNum * 10);
//		System.out.println("randomNum = " + randomNum);
//		System.out.println("number1 = " + number1);
		
		if(number1 < number2) {
			// 예를 들면 number1이 5이고, number2가 7일 때
			// number1에 7, number2에 5가 되도록 스왑하고 싶음
			int temp;
			temp = number1;
			number1 = number2;
			number2 = temp;	
		}
		System.out.println("number1이 " + number1 + "이고 number2가 "
				+ number2 + "인 경우 number1 - number2의 값은? ");
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();
		
		if ((number1 - number2) == answer) {
			System.out.println("예 맞습니다.");
		} else {
			System.out.println("안타깝지만 틀리셨습니다.");
			System.out.println(number1 + " - " + number2 + " 는 "
					+ (number1 - number2) + "이어야 합니다.");
		}
	}
}
