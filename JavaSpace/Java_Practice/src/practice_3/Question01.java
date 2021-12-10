package practice_3;

import java.util.Scanner;

//	console에서 두 문자로 구성된 문자열을 입력받아 학생이 소속된 과이름과 학년을 출력하시오
//	입력문자열 : 영어 1글자 + 숫자 1글자 입력(예: I2)
//		- 영어 1글자 : I, A, C만 가능(I: 정보학과, A: 회계학과, C: 컴퓨터학과)
//		- 숫자 1글자 : 1, 2, 3, 4만 가능(1 : 1학년)
//	I2의 경우 "정보학과 2학년입니다."를 console 화면에 출력
public class Question01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String check = "IAC1234";
		char majorCode, grade;

		char[] majorCodeArr = {'I', 'A', 'C'};
		String[] majorArr = {"정보학과", "회계학과", "컴퓨터학과"};
		
		while(true) {
			System.out.println("영어는 I, A, C 중 택1 / 숫자는 1, 2, 3, 4 중 택1");
			System.out.println("위 조건에 따라 두 문자를 조합하여 입력해주세요. 예.A3");
		
			String studentInfo = input.nextLine();
			majorCode = studentInfo.charAt(0);
			grade = studentInfo.charAt(1);
			
			if ((check.substring(0,3).indexOf(majorCode) != -1) && 
					(check.substring(3,7).indexOf(grade) != -1))
				break;			
		}
				
		for(int i=0;i<majorCodeArr.length;i++) {
			if(majorCodeArr[i] == majorCode) {
				System.out.println(majorArr[i] + " " + grade + "학년 입니다.");				
			}
		}	
		input.close();
	}
}
