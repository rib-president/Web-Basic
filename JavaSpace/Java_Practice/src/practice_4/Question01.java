package practice_4;

import java.util.Scanner;

//	console로 부터 3 x 4 2차원 배열 값을 입력받아온 후, 각 행의 합계를 구해 출력하시오
public class Question01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] doubleArr = new double[3][4];		
		
		for(int i=0;i<doubleArr.length;i++) {
			System.out.println((i+1) + "행의 값을 4개 입력하시오.(double type)");
			for(int j=0;j<doubleArr[i].length;j++) {
				doubleArr[i][j] = input.nextDouble();
			}
		}
		
		for(int i=0;i<doubleArr.length;i++) {
			double sum = 0;
			for(int j=0;j<doubleArr[i].length;j++) {
				sum += doubleArr[i][j];
			}
			String korOddNum = matchKorOddNum(i);
			System.out.println(korOddNum + "번째 행의 합계는 " + sum + "입니다.");
		}
		input.close();
	}
	
	static String matchKorOddNum(int i) {
		String[] korOddNumArr = {"첫", "두", "세"};
		
		return korOddNumArr[i];
	}
}
