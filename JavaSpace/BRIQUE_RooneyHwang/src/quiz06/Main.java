package quiz06;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		// ex)띄어쓰기로 구분하여 1 2 3 4 5 형태로 입력해주세요
		System.out.print("Input: ");
		Tower tower = new Tower(scn.nextLine());
		tower.getResult();
		
		scn.close();
	}
}
