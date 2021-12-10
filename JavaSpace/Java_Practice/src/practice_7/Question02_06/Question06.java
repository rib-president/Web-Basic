package practice_7.Question02_06;

import java.util.*;

public class Question06 {
	public static void main(String[] args) {
		int number1 = (int)(Math.random() * 10);
		int number2 = (int)(Math.random() * 10);

		// Create an set
		Set<Integer> answers = new HashSet<Integer>();

		// 1. Scanner를 통해 두 숫자의 합계의 추측값을 입력 받을 것
		// 2. while문을 수행하면서 만약 합계가 맞으면 정답이라고 출력할 것
		//    - 정답이 아니면, 정답이 아니라고 출력하면서 다시 입력하라고 메세지를 출력할 것
		//    - 정답이 아닌 경우는 answers에 입력할 것 
		//      (단, answers에 이미 이전에 입력했으면 이미 입력했다는 메세지를 출력할 것
		Scanner input = new Scanner(System.in);
		int correct = number1 + number2;
		while(true) {
			System.out.println("두 난수의 합을 추측해보시오.");
			int answer = input.nextInt();
			if(answer == correct) {
				System.out.println("정답");
				break;
			}
			System.out.println("정답이 아닙니다. 다시 입력하세요.");
			if(answers.contains(answer)) {
				System.out.println("이미 입력했던 답입니다.");
			} else {
				answers.add(answer);
			}
		}
		input.close();
	}
}
