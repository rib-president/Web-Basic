package practice_1;

import java.util.Scanner;

//	4개의 정수 값을 키보드로부터 읽어, 4개의 정수값이 모두 같으면
//	"4개의 정수값이 동일합니다"를 출력하고, 아니면 "4개의 정수값이 동일하지 않습니다."
//	를 출력하시오.
public class Question04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("4개의 정수 값을 입력하시오.");
		
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		int num4 = input.nextInt();
		
		if ((num1 == num2) && (num2 == num3) && (num3 == num4)) {
			System.out.println("4개 정수값이 동일합니다.");
		} else {
			System.out.println("4개의 정수값이 동일하지 않습니다.");
		}
	}
}
