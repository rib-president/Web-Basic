package practice_2;

import java.util.Scanner;

//	Math.random()을 사용하여 1~100까지의 숫자 중 한 개를 생성한 후,
//	사용자가 숫자를 추측하여 맞추는 게임을 만드시오.
public class Question05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int randNum = (int)(Math.random()*100) + 1;
		int guessNum;
		System.out.println(randNum);
//		while (true) {
//			System.out.println("1~100까지 숫자를 추측해 보세요?");
//			guessNum = input.nextInt();
//			
//			if(guessNum==randNum) {
//				System.out.println("숫자 " + randNum + "을 정확히"
//						+ " 맞추었습니다.");
//				break;
//			} else if(guessNum < randNum) {
//				System.out.println("당신이 추측한 숫자보다 큽니다.");
//			} else {
//				System.out.println("당신이 추측한 숫자보다 작습니다.");
//			}
//		}

		do {
			System.out.println("1~100까지 숫자를 추측해 보세요?");
			guessNum = input.nextInt();	
			
			if(guessNum < randNum) {
				System.out.println("당신이 추측한 숫자보다 큽니다.");
			} else if(guessNum > randNum) {
				System.out.println("당신이 추측한 숫자보다 작습니다.");
			}			
		
		} while(guessNum!=randNum);
		
		System.out.println("숫자 " + randNum + "을 정확히"
						+ " 맞추었습니다.");

		input.close();
	}
}
