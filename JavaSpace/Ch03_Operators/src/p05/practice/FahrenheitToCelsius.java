package p05.practice;

import java.util.Scanner;

public class FahrenheitToCelsius {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("화씨(F)를 입력하세요 ");
		double fahrenheit = input.nextDouble();
		
		double celsius = (5.0 / 9) * (fahrenheit - 32);
		System.out.println("입력된 화씨 " + fahrenheit + "는 섭씨 "
				+ celsius + "도 입니다.");
	}
}
