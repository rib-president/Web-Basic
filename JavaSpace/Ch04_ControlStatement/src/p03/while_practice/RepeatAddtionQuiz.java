package p03.while_practice;

import java.util.Scanner;

//	0~9 사이의 두 개의 숫자를 random number로 만든 후 두 수의 덧셈 결과를
//	console로 받아서, 덧셈 결과가 맞을 때까지 while문을 반복 수행
public class RepeatAddtionQuiz {
	public static void main(String[] args) {
		int number1 = (int)(Math.random() * 10);
		int number2 = (int)(Math.random() * 10);

		Scanner input = new Scanner(System.in);
		System.out.println(number1 + "과 " + number2 + "의 합계는 ?");
		
		int answer = input.nextInt();
		
		//	while 수행 기준 : 정답이 틀린 경우에만 while이 반복 수행
		//	(number1 + number2) == answer인 경우는 while문을 빠져 나옴
		while((number1 + number2) != answer) {
			System.out.println("정답이 아닙니다. 다시 시도해 보세요.");						
			System.out.println(number1 + "과 " + number2 + "의 합계는 ?");
			answer = input.nextInt();
		}

		System.out.println("예, 정답입니다. 잘 맞추셨습니다.~~");
		input.close();
	}
}
