package practice_3;

import java.util.Scanner;

//	console에서 두 개의 문자열을 읽어 두 번째 문자열이 첫 번째 문자열의 substring인지 
//	여부를 출력하시오.
public class Question03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("첫 번째 문자열을 입력하시오.");
		String firstStr = input.nextLine();
		
		System.out.println("두 번째 문자열을 입력하시오.");
		String secondStr = input.nextLine();
		
		if(firstStr.indexOf(secondStr) != -1) {
			System.out.println(secondStr + "는 " + firstStr + 
					"의 substring입니다.");
		} else {
			System.out.println(secondStr + "는 " + firstStr + 
					"의 substring이 아닙니다.");
		}
		
		input.close();
	}
}
