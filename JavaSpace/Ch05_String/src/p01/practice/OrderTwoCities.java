package p01.practice;

import java.util.Scanner;

//	2개의 도시 이름을 알파벳 순서로 정렬
public class OrderTwoCities {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("첫번째 도시를 입력하세요.");
		String city1 = input.nextLine();
		System.out.println("두번째 도시를 입력하세요.");
		String city2 = input.nextLine();
		//	city1 < city2
		if (city1.compareTo(city2) < 0) {
			System.out.println("2개 city의 알파벳 오름차순 = " +
					city1 + " " + city2);
		} else {	//	>= 0
			System.out.println("2개 city의 알파벳 오름차순 = " +
					city2 + " " + city1);			
		}
	}
}
