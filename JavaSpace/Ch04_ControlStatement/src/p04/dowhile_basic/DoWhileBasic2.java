package p04.dowhile_basic;

import java.util.Scanner;

//	입력한 숫자들을 do~while문을 사용하여 반복영역에서 console에서 입력한 숫자를
// 읽어서 기존에 읽었던 숫자들과 합계를 구함
//	단, do~while문을 빠져나올 수 있는 경우는 숫자 0을 입력하면 더이상 합계를
//	구하지 않고 빠져나옴
public class DoWhileBasic2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		int input_number;
		
		do {
			System.out.println("덧셈할 숫자를 입력하세요. 단, 입력한 숫자가 "
					+ "0이면 종료합니다.");
			input_number = input.nextInt();

			sum += input_number;
			
		} while(input_number != 0);
		
		
//		System.out.println("덧셈할 숫자를 입력하세요. 단, 입력한 숫자가 "
//				+ "0이면 종료합니다.");
//		input_number = input.nextInt();
//		while(input_number != 0) {
//			sum += input_number;
//			
//			System.out.println("덧셈할 숫자를 입력하세요. 단, 입력한 숫자가 "
//					+ "0이면 종료합니다.");			
//			input_number = input.nextInt();
//
//			
//		} 	
	
		System.out.println("전체 합계는 = " + sum + " 입니다.");
	}
}
