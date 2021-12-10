package p03.realnumber_problem;

public class RealNumberWrongUseEx {
	public static void main(String[] args) {
		float f1 = 0.1f;
		double d1 = 0.1;
		
		System.out.println("f1 = " + f1);
		System.out.println("d1 = " + d1);
		System.out.println("f1 == d1 : " + (f1 == d1));
		
		int apple = 1;
//		double pieceUnit = 0.1;
		float pieceUnit = 0.1f;
		int number = 7;
		
		double result = apple - (number * pieceUnit);
		
		System.out.println("사과 한개에서 ");
		System.out.println("0.7 조각을 빼면, ");
		System.out.println(result + "조각이 남는다.");

	}
}
