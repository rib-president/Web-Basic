package practice_2;

import java.util.Scanner;

//	while문을 이용하여 입력된 정수들에 대해 입력한 양수의 전체 개수, 음수의 전체 개수,
//	전체 평균값을 구하여 출력하시오.
public class Question06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int positive = 0;
		int negative = 0;
		int sum = 0;
		int average = 0;
		int num;

		while(true) {
			System.out.println("정수를 입력하시오.(0 입력시 종료)");
			num = input.nextInt();
			if(num == 0) {
				break;
			} else if(num > 0) {
				positive++;
			} else {
				negative++;
			}			
			sum += num;
		}
		
		if((positive+negative)!=0) {
			average = sum / (positive+negative);
		}
		System.out.println("양수의 개수 = " + positive);
		System.out.println("음수의 개수 = " + negative);
		System.out.println("전체 합 = " + sum);
		System.out.println("전체 평균 = " + average);
		
		input.close();

	}
}	