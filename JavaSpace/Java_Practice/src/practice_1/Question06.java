package practice_1;

import java.util.Scanner;

//	2개의 double 실수를 키보드로부터 읽어 2개의 실수값 모두 0과 1사이에 있는지
//	check하고 메시지를 출력하시오.
public class Question06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("2개의 실수를 입력하시오.");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		
		boolean bNum1 = (num1 > 0) && (num1 < 1);
		boolean bNum2 = (num2 > 0) && (num2 < 1);
		
		
		if (bNum1 && bNum2) {
				System.out.println("두 수 모두 0과 1사이에 있습니다.");
		} else {
			System.out.println("두 수 모두 0과 1사이에 있지 않습니다.");
		}
	}
}
