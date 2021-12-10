package p02.inc_dec;

public class DecrementOperatorEx {
	public static void main(String[] args) {
		int n1 = 10;
		int result;
		
		System.out.println("n1 = " + n1);
		n1--;		// n1 = n1 -1;
		System.out.println("n1 = " + n1);
		
		--n1;		// n1 = n1 - 1;
		System.out.println("n1 = " + n1);

		result = n1--;
//		result = n1;
//		n1 = n1 - 1;
		System.out.println("result = " + result);
		System.out.println("n1 = " + n1);

		result = --n1;
//		n1 = n1 - 1;
//		result = n1;
		System.out.println("result = " + result);
		System.out.println("n1 = " + n1);

		
	}
}
