package practice_1;

import java.util.Scanner;

//	분 단위의 숫자를 키보드에서 읽어, 일의 수와 년의 수를 구하여
//	console에 출력하시오.
public class Question02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("분단위의 정수를 입력해주세요.");
		int minutes = input.nextInt();
		
//		int remainderMinute = minutes % 60;
		int totalHours = minutes / 60;
//		int remainderHour = totalHours % 24;
		int totalDays = totalHours / 24;
		int totalYears = totalDays / 365;
		int remainderDay = totalDays % 365;
		
//		System.out.println(minutes + "분은 년으로 " + totalYears
//				+ "년 일로 " + totalDays + "일 입니다.");
		
		System.out.println(minutes + "분은 총 " + totalYears
				+ "년 " + remainderDay + "일 입니다.");

//		System.out.println(minutes + "분은 총 " + totalYears
//				+ "년 " + remainderDay + "일 " + remainderHour + 
//				"시 " + remainderMinute + "분 입니다.");

	
	}
}
