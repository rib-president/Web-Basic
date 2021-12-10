package practice_5.Question01;

import java.util.Scanner;

public class TestTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("삼각형 세 변의 길이를 입력하시오.");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		input.nextLine();
		
		System.out.println("삼각형의 색을 입력하시오.");
		String color = input.nextLine();
		
		System.out.println("삼각형이 채워져있으면 true, 아니면 false를 입력하시오.");
		boolean filled = input.nextBoolean();
		
		Triangle triangle1 = new Triangle();
		
		Triangle triangle2 = new Triangle(side1, side2, side3);
		triangle2.setColor(color);
		triangle2.setFilled(filled);
		
		System.out.println("<triangle1 infomation>");
		System.out.println(triangle1.toString() + "\nArea = " + triangle1.getArea()
				+ ", Perimeter = " + triangle1.getPerimeter());
		System.out.println();
		System.out.println("<triangle2 infomation>");
		System.out.println(triangle2.toString() + "\nArea = " + triangle2.getArea()
				+ ", Perimeter = " + triangle2.getPerimeter());
		
		input.close();
	}
}
