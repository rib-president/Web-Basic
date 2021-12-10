package practice_2;

import java.util.Scanner;

//	console에서 전체 학생수와 각 학생별 점수를 입력받아 전체 학생 중 최고점수를 출력하시오
public class Question08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("전체 학생수를 입력하세요.");
		int student = input.nextInt();
		int score = 0;
		int maxScore = 0;
		
//		for(int i=0;i<student;i++) {
//			System.out.println("두 자리수 점수를 입력하시오.");
//			score = input.nextInt();
//			if(score > maxScore) {
//				maxScore = score;
//			}
//		}
		
		while(student>0) {
			System.out.println("두 자리수 점수를 입력하시오.");
			score = input.nextInt();
			if(score > maxScore) {
				maxScore = score;
			}
			student--;
		}
		

		System.out.println("최고 점수는 = " + maxScore + "점 입니다.");
		input.close();
	}
}
