package p02.call_by_reference.practice;

public class TestPassArray {
	public static void main(String[] args) {
		int[] a = {1, 2};
		
		System.out.println("swaping 이전");
		System.out.println("a[0] = " + a[0] + ", a[1] = " + a[1]);		
		swap(a[0], a[1]);
		System.out.println("swaping 이후");
		System.out.println("a[0] = " + a[0] + ", a[1] = " + a[1]);
		
		swapInArray(a);
		System.out.println("배열을 넘기는 swap 메소드 호출 이후");
		System.out.println("a[0] = " + a[0] + ", a[1] = " + a[1]);
	}
	
	public static void swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}
	
	public static void swapInArray(int[] num) {
		int temp = num[0];
		num[0] = num[1];
		num[1] = temp;
	}
}
