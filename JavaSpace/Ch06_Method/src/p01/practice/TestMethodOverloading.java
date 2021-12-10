package p01.practice;

//	method overloading 개념 설명 실습
//	- method signature가 다른 경우 JVM이 다른 method로 인식하는 것
//	- 예 : max(int num1, int num2), max(double num1, double num2),
//		max(double num1, double num2, double num3)
public class TestMethodOverloading {
	public static void main(String[] args) {
//		System.out.println("3과 4의 최대값 = " + max(3, 4));
//
//		System.out.println("3.0과 5.4의 최대값 = " + max(3.0, 5.4));

		System.out.println("3.0과 5.4, 10.4 중 최대값 = " + max(3.0, 5.4, 10.4));
	
	}
	
	public static int max(int num1, int num2) {
		if(num1 > num2) {
			return num1;
		}
		return num2;
	}
	
	public static double max(double num1, double num2) {
		System.out.println("num1 = " + num1 + " num2 = " + num2);

		if(num1 > num2) {
			return num1;
		}
		return num2;
	}
	
	public static double max(double num1, double num2, double num3) {
		double result;
		
		System.out.println("num1 = " + num1 + " num2 = " + num2 + 
				" num3 = " + num3);
		//	max(max(num1, num2), num3)의 기계어 명령어 실행
		//	1.max(num1, num2)를 먼저 실행하여 결과값 5.4를 가져옴
		//	2.max(5.4, num3)를 실행하여 결과값 10.4를 가져옴
		//	3.결과값 10.4를 result 변수에 넘겨줌
		result = max(max(num1, num2), num3);
		return result;
	}	
}
