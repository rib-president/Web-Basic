package practice_6.Question01;

import java.util.Scanner;

public class TestSquare {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("변의 길이(double)를 입력하시오: ");
		double side = input.nextDouble();		
		input.nextLine();
		System.out.print("color를 입력하시오: ");
		String color = input.nextLine();
		System.out.print("filled(boolean) 입력하시오: ");
		boolean filled = input.nextBoolean();
		
		
		Square square1 = new Square();
		System.out.println("\n<기본생성자로 생성됨>");
		System.out.println(square1);
		

		Square square2 = new Square(side);
		System.out.println("\n<side 값만 받아 생성됨>");
		System.out.println(square2);


		Square square3 = new Square(side, color, filled);
		System.out.println("\n<side, color, filled 값을 받아 생성됨>");
		System.out.println(square3);
		
		input.close();
	}
}
