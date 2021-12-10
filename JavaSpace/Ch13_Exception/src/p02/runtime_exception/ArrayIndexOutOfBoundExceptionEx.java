package p02.runtime_exception;

public class ArrayIndexOutOfBoundExceptionEx {
	public static void main(String[] args) {
//		int[] a = {1, 2, 3};
//		
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		System.out.println(a[3]);

		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0] = " + data1);
		System.out.println("args[1] = " + data2);
	}
}
