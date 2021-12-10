package practice_2;

import java.util.Scanner;

//	Math.random()으로 0,1,2 값을 갖는 3개의 정수를 random하게 생성한 후
//	console에서 사용자가 0,1,2 중 하나를 입력받아 컴퓨터가 승리했는지 
//	사용자가 승리했는지 결과를 출력하시오
//	가위 : 0, 바위 : 1, 보 : 2
public class Question04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int pcNum = (int)(Math.random()*3);	

		System.out.println("숫자 0(가위), 1(바위), 2(보) 중 하나를"
				+ " 입력하세요.");
		int userNum = input.nextInt();
		
		if(userNum == pcNum) {
			System.out.println("비겼습니다.");
		} else if(((userNum-pcNum)==1) || ((userNum-pcNum)==-2)) {
			System.out.println("당신이 이겼습니다.");
		} else {
			System.out.println("당신이 졌습니다.");
		}
		
		input.close();
	}
}
