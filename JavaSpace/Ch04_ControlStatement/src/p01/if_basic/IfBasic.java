package p01.if_basic;

import java.util.Scanner;

//	if문 : 입력한 데이터 또는 특정 변수의 값이 조건에 맞을 때 해당 명령어를 실행
public class IfBasic {
	public static void main(String[] args) {
		//	원의 반지름이 주어질 경우 원의 면적을 구한다면
		//	원의 반지름이 >= 0인 경우만 원의 면적을 계산
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("원의 반지름을 입력하세요 : ");
		int radius = input.nextInt();
		
		double area = 0.0;
		
		if (radius >= 0) {
			int temp;
			
			area = radius * radius * 3.14159;
			temp = 50*12;
			System.out.println("temp값은 " + temp + "입니다.");
		}
		
		System.out.println("원의 면적은 " + area + "입니다.");
		
	}
}

