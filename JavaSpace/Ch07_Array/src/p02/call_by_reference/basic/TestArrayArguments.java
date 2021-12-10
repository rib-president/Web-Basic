package p02.call_by_reference.basic;

public class TestArrayArguments {
	public static void main(String[] args) {
		int x = 1;
		int[] y = new int[10];
		
		for(int i=0;i<y.length;i++) {
			y[i] = 0;
		}
		
		testArgument(x, y);
		
		System.out.println("x = " + x);
		System.out.println("y[0] = " + y[0]);
	}
	
public static void testArgument(int number, int[] numbers) {
	number = 1001;
	numbers[0] = 3333;
	}
}
