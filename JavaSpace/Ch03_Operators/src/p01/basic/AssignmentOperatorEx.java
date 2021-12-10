package p01.basic;

public class AssignmentOperatorEx {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = n1;
		int result = 0;
		
		System.out.println("n1 = " + n1);
		// n1 = n1 + 10;
		n1 += 10;
		System.out.println("n1 = " + n1);
		
		// n1 = n1 - 5;
		n1 -= 5;
		System.out.println("n1 = " + n1);
		
		// n1 = n1 * 2;
		n1 *= 2;
		System.out.println("n1 = " + n1);
		
		// n1 = n1 / 3;
		n1 /= 3;
		System.out.println("n1 = " + n1);

	}

}
