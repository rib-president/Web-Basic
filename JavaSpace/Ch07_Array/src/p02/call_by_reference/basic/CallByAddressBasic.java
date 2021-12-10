package p02.call_by_reference.basic;

public class CallByAddressBasic {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 10;
		String name = "honggildong";
		int[] arr = {1, 2, 3};
		int[] arr1 = {1, 2, 3};
		
		System.out.println("1과 10사이의 합 = " + sum(1, 10));
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		
		//	배열 주소값 출력(16진수)
		System.out.println("arr = " + arr);
		System.out.println("arr1 = " + arr1);
		
		//	배열 해시코드 출력(10진수)
		System.out.println(System.identityHashCode(arr));
		System.out.println(System.identityHashCode(arr1));
	}
	
	public static int sum(int startValue, int endValue) {
		int result = 0;
		
		for(int i=startValue;i<=endValue;i++) {
			result += i;
		}
		return result;
	}	
}
