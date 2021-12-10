package practice_2;

import java.util.Scanner;

//	console에서 사람의 체중, 키를 입력받아 비만도를 체크하여 건강 관련 내용을 출력하시오
//	체중(kg 단위), 키(meter 단위) => 소수점 존재
//	18.5 | BMI | 25  | 30  |
//	저체중    정상체중  과체중  비만
public class Question02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("체중을 입력하세요(kg단위) : ");
		double weight = input.nextDouble();
		System.out.print("키를 입력하세요(meter단위) : ");
		double height = input.nextDouble();
		
		double bmi = weight / (height * height);
		
		if (bmi < 18.5) {
			System.out.println("저체중 입니다.");
		} else if (bmi < 25) {
			System.out.println("정상 체중 입니다.");
		} else if (bmi < 30) {
			System.out.println("과체중 입니다.");
		} else {
			System.out.println("비만 입니다.");
		}
		input.close();
	}
}
