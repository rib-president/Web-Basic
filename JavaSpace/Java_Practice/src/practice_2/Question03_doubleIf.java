package practice_2;

import java.util.Scanner;

public class Question03_doubleIf {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("정수값 3개를 입력해주세요.");		
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		
		int nMax = 0;
		int nMid = 0;
		int nMin = 0;
		
		if ((num1 > num2) && (num1 > num3)) {
			nMax = num1;
			if (num2 > num3) {
				nMid = num2;
				nMin = num3;
			} else {
				nMid = num3;
				nMin = num2;
			}
		} else if ((num2 > num1) && (num2 > num3)) {
			nMax = num2;
			if (num1 > num3) {
				nMid = num1;
				nMin = num3;
			} else {
				nMid = num3;
				nMin = num1;
			}
		} else {
			nMax = num3;
			if (num1 > num2) {
				nMid = num1;
				nMin = num2;
			} else {
				nMid = num2;
				nMin = num1;
			}
		}
		
		System.out.println(nMax + " " + nMid + " " + nMin);			
		input.close();
	}
}
