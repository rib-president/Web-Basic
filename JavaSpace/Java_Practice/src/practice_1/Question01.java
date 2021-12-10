package practice_1;

import java.util.Scanner;

//	0과 1000사이의 3자리 정수를 키보드에서 읽어, 정수의 각 자리의 수를
//	모두 더한 값을 출력하시오.
public class Question01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("세 자리 정수를 입력해주세요.");
		int integer = input.nextInt();
		if ((integer>=0) && (integer <1000)) {
			int units = integer % 10;
			integer /= 10;
			int tens = integer % 10;
			integer /= 10;
			int hundreds = integer % 10;
			
			int result = units + tens + hundreds;
			
			System.out.println(integer + "의 각 자리 수를 모두 더한 값은 : "
					+ result + "입니다.");
		} else {
			System.out.println("입력 값은 0과 1000사이의 세 자리수여야 합니다.");
		}
		
	}
}
