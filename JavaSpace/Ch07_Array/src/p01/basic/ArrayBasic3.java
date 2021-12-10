package p01.basic;

import java.util.Scanner;

//	console에서 배열크기와 각 배열 원소의 값을 읽어 오기
//	1.배열 생성방법 : 배열 변수만 생성하고 나중에 배열크기와 원소값을 저장하는 방법
public class ArrayBasic3 {
	public static void main(String[] args) {
		double[] myList;
		
		Scanner input = new Scanner(System.in);
		System.out.println("배열의 크기를 입력하세요.");
		int arrLength = input.nextInt();
		
		myList = new double[arrLength];
		
		for(int i=0;i<myList.length;i++) {
			System.out.println((i+1) + "번째 원소를 입력하세요.");
			myList[i] = input.nextDouble();
		}
		
		for(int i=0;i<myList.length;i++) {
			System.out.println("myList[" + i + "] = " + myList[i]);
		}
		
		input.close();
	}
}
