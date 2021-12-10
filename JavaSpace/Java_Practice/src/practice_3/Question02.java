package practice_3;

import java.util.Scanner;

//	console에서 입력된 사원번호가 맞는지 체크하여 체크 결과를 출력하시오.
//	사원번호 입력할 때 숫자와 '-'만 입력된다고 가정
public class Question02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String empNum;
		int firstHyphen = -1;
		int secondHyphen = -1;		
		
		while(true) {
			System.out.println("형식에 맞게 사원번호를 입력하시오.");
			System.out.println("DDD-DD-DDDD (D: 0~9사이의 숫자)");		
			empNum = input.nextLine();
			
			int count = 0;
			for(int i=0;i<empNum.length();i++) {
				char word = empNum.charAt(i);
				if(Character.isDigit(word)) {
					count++;
				} else break;
			}
			
			firstHyphen = empNum.indexOf('-');
			secondHyphen = empNum.lastIndexOf('-');
			
			if((count == 9) && (firstHyphen == 3) && (secondHyphen == 6)) {
				System.out.println(empNum + "는 사원 번호 형식이 맞습니다.");
				break;
			}else {
				System.out.println(empNum + "는 사원 번호 형식이 아닙니다.");
			}
		}
		input.close();
	}
}
