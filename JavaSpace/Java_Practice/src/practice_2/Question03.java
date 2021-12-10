package practice_2;

import java.util.Scanner;

//	3개의 정수값을 키보드로부터 읽어 오름차순으로 정렬하여 결과를 출력하시오.
public class Question03 {
	public static void main(String[] args) {
		int nMax = 0;
		int nMid = 0;
		int nMin = 0;
		
		Scanner input = new Scanner(System.in);
		
		for (int i=0;i<3;i++) {
			System.out.println("정수값을 입력해주세요.");
			int num = input.nextInt();	
			if (num > nMax) {
				nMin = nMid;
				nMid = nMax;
				nMax = num;
			} else if(num > nMid) {
				nMin = nMid;
				nMid = num;
			} else {
				nMin = num;
			}
		}		
		System.out.println(nMax + " " + nMid + " " + nMin);		
		input.close();
	}	
}
