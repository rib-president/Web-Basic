package p01.basic;

import java.util.Scanner;

//	코딩 단순화 예제
//	1.배열 원소로 올 수 있는 데이터 타입은 어떠한 타입도 가능
//	- primitive type, 참조타입(String, Class, Interface 등)
public class ArrayBasic8 {
	public static void main(String[] args) {
		String[] months = {"January", "February", "March", "April",
				"May", "June", "July", "August", "September",
				"October", "November", "December"};

		Scanner input = new Scanner(System.in);

		System.out.println("달력 숫자를 입력하세요 (1 ~ 12 사이 숫자)");
		int monthNumber = input.nextInt();
		
		System.out.println("이번 달은 "  + months[monthNumber-1] + 
				"입니다.");
		
		input.close();
	}
}
