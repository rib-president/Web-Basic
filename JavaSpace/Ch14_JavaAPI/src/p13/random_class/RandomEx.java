package p13.random_class;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		
		System.out.println("선택번호 : ");
		for(int i=0;i<selectNumber.length;i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		int[] winNumber = new int[6];
		random = new Random(3);
		
		System.out.println("당첨번호 : ");
		for(int i=0;i<winNumber.length;i++) {
			winNumber[i] = random.nextInt(45) + 1;
			System.out.print(winNumber[i] + " ");
		}
		System.out.println();
	}
}
