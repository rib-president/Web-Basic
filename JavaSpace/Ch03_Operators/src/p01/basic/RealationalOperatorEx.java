package p01.basic;

public class RealationalOperatorEx {

	public static void main(String[] args) {
		int a1 = 5;
		int a2 = 10;
		int a3 = 5;
		boolean bResult;
		
		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2);
		System.out.println("a3 = " + a3);

		System.out.println("a1 == a2 " + (a1 == a2));
		System.out.println("a1 == a3 " + (a1 == a3));

		bResult = (a1 == a2);
		System.out.println("bResult = " + bResult);
		bResult = (a1 == a3);
		System.out.println("bResult = " + bResult);
		
		System.out.println("a1 != a2 : " + (a1 != a2));
		System.out.println("a1 != a3 : " + (a1 != a3));
		
		System.out.println("a1 > a2 : " + (a1 > a2));
		System.out.println("a1 < a2 : " + (a1 < a2));
		
	}

}
