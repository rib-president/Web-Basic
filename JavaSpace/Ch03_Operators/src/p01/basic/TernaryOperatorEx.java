package p01.basic;

public class TernaryOperatorEx {

	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 10;
		int max;
		
		System.out.println("n1 > n2 = " + (n1 > n2));
		max = (n1 > n2) ? n1 : n2;
		
		System.out.println("max = " + max);
		
		int result;
		
		result = (n1 > n2) ? (n1 + n2) : (n1 - n2);
		System.out.println("Result = " + result);

	}

}
