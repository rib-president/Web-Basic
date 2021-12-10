package p01.basic;

import java.util.Scanner;

//	if문을 이용하여 num2에 0을 입력하는 경우 메세지 출력
public class QuotientWithIf {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("2개 정수값을 입력하세요.");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		
		if(num2 != 0) {
			System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
		} else {
			System.out.println("분모에 해당하는 정수에 0을 사용할 수 없습니다.");
			System.out.println("두번째 정수값으로 0이 아닌 정수를 입력하세요.");
		}
		input.close();
	}
}
