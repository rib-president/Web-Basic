package p05.java_library;

import java.util.Scanner;

//	Point2D class 사용 : 수학에서 (x1, y1)과 (x2, y2) 두 점사이의 거리,
//	중간값 => 현재 버전에 java.awt.geom.Point2D가 없어서 보류
public class TestPoint2D {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("첫 번째 점인 x1, y1 값을 입력하세요.");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		
		System.out.println("두 번째 점인 x2, y2 값을 입력하세요.");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		input.close();
	}
}
