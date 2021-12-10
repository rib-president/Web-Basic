package p01.basic;

import java.util.Scanner;

// Console에서 키보드로 반지름 데이터를 입력받아 원의 면적 계산
public class ComputeAreaWithConsoleInput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// 1. 원의 반지름을 Console에서 키보드로 입력된 데이터로 읽기
		System.out.println("원의 반지름을 입력하세요 : ");
		double radius = input.nextDouble();
		
		// 2. 원의 면적 계산하기 : 입력데이터를 출력데이터로 가공
		double area = radius * radius * 3.14159;
		
		// 3. 원의 면적을 console창에 보여주기
		System.out.println("원의 반지름이 " + radius + "인 "
								+ "원의 면적은 " + area + " 입니다.");
		
	}

}
