package practice_3;

import java.util.Scanner;

//	Web site에서 password를 check하는 메소드를 만들고 console에서 password
//	문자열을 입력하여 password가 유효한지 결과를 출력하시오.
public class Question06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//	password는 최소 10자리 이상
		//	password는 영문자와 숫자만 가능
		//	password는 최소 3개의 숫자를 가져야 함
		System.out.println("설정할 유효 Password를 입력하시오.");
		String password = input.nextLine();
		
		checkPassword(password);
		
		input.close();	
	}
	
	public static void checkPassword(String password) {
		if(length(password) && letterOrDigit(password) && countNum(password)>=3) {
			System.out.println(password + "은 유효합니다.");
		} else {
			System.out.println(password + "은 유효하지 않습니다.");
		}
	}
	
	public static boolean length(String password) {
		if (password.length() >= 10) return true;
		return false;
	}
	
	public static boolean letterOrDigit(String password) {
		for(int i=0;i<password.length();i++) {
			char word = password.charAt(i);
			if(!Character.isLetterOrDigit(word) ||
					!checkEngDigit(word)) {			
				return false;
			}
		}

		return true;
	}
	
	public static boolean checkEngDigit(char c) {
		if((c>=65 && c<=90) || (c>=97 && c<=122) || Character.isDigit(c)) {
			return true;
		}	
		return false;
	}
	
	public static int countNum(String password) {
		int count = 0;
		for (int i=0;i<password.length();i++) {
			if(Character.isDigit(password.charAt(i))) {
				count++;
			}
		}
		return count;
	}
}
