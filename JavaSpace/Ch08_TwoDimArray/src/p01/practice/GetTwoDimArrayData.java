package p01.practice;

import java.util.Scanner;

public class GetTwoDimArrayData {
	public static void main(String[] args) {
		int[][] numbers = new int[2][3];
		
		Scanner input = new Scanner(System.in);
		System.out.println("2행 3열 데이터에 대하여 행 단위로 space로 구분된 "
				+ "데이터를 enter key를 쳐서 입력하시오.");
		
		for(int row=0;row<numbers.length;row++) {
			for(int column=0;column<numbers[row].length;column++) {
				numbers[row][column] = input.nextInt();
			}
		}

		for(int row=0;row<numbers.length;row++) {
			for(int column=0;column<numbers[row].length;column++) {
				System.out.print(numbers[row][column] + " ");
			}
			System.out.println();
		}	
		input.close();
	}
}