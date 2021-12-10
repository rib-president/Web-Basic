package p11.arrays_method;

import java.util.Arrays;

public class ArrayCopyEx {
	public static void main(String[] args) {
		char[] arr1 = {'J', 'A', 'V', 'A'};
		
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(arr2);
		
		char[] arr3 = Arrays.copyOfRange(arr1,  1, 3);
		System.out.println(arr3);
		
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		for(int i=0;i<arr4.length;i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);
		}
	}
}
