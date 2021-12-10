package practice_8.Question06;

import java.util.Scanner;

public class MainEx {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Calculator calc = new CasioCal();
		
		while(true) {
			System.out.println("------------------------------------------");
			System.out.println("1.더하기 | 2.빼기 | 3.나누기 | 4.곱하기 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");
			int command = input.nextInt();
			
			if(command == 5) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			} else if(command < 1 || command > 5) {
				System.out.println("메뉴 중에서 선택하세요");
				continue;
			}
			System.out.println("첫번째 숫자를 입력하세요.");
			int num1 = input.nextInt();
			System.out.println("두번째 숫자를 입력하세요.");
			int num2 = input.nextInt();
			switch(command) {
			case 1:
				calc.add(num1, num2);
				break;
			case 2:
				calc.sub(num1, num2);
				break;
			case 3:
				calc.divide(num1, num2);
				break;
			case 4:
				calc.multiple(num1, num2);
				break;
			}
		}
		input.close();
	}
}
