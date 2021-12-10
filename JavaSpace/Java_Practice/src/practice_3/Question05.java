package practice_3;

import java.util.Scanner;

//	문자열에서 영문자의 숫자를 세는 메소드를 만들고 사용 결과를 출력하시오.
//	A~Z : 65~90, a~z : 97~122
public class Question05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("문자열을 입력하시오.");
		String letters = input.nextLine();
		int count = countLetters(letters);
		
		System.out.println("전체 문자 개수는 " + count + "입니다.");
		
		input.close();
	}
	
	public static int countLetters(String s) {
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			char letter = s.charAt(i);
			if((Character.isLetter(letter)) && (checkEng(letter))) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean checkEng(char c) {
		if((c>=65 && c<=90) || (c>=97 && c<=122)) {
			return true;
		}
		return false;
	}
}
