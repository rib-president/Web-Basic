package p01.basic;

//	배열(Array) 생성 방법
public class ArrayBasic {
	public static void main(String[] args) {
		// 배열 변수 선언과 동시에 배열 생성, 원소 저장
		int[] arr = {10, 20, 30, 40};
		
		System.out.println("arr의 첫번째 원소 = " + arr[0]);
		System.out.println("arr의 두번째 원소 = " + arr[1]);
		System.out.println("arr의 세번째 원소 = " + arr[2]);
		System.out.println("arr의 네번째 원소 = " + arr[3]);
		System.out.println("arr 배열 전체 원소 갯수 = " + arr.length);

		int arr1[] = {50, 60, 70, 80};
		
		System.out.println("arr1의 첫번째 원소 = " + arr1[0]);
		System.out.println("arr1의 두번째 원소 = " + arr1[1]);
		System.out.println("arr1의 세번째 원소 = " + arr1[2]);
		System.out.println("arr1의 네번째 원소 = " + arr1[3]);
		System.out.println("arr1 배열 전체 원소 갯수 = " + arr1.length);
		
		double[] arr2 = {1.0, 2, 3, 4};
		System.out.println("arr2의 첫번째 원소 = " + arr2[0]);
		System.out.println("arr2의 두번째 원소 = " + arr2[1]);
		System.out.println("arr2의 세번째 원소 = " + arr2[2]);
		System.out.println("arr2의 네번째 원소 = " + arr2[3]);
		System.out.println("arr2 배열 전체 원소 갯수 = " + arr2.length);
		
		//	배열만 선언하고 나중에 초기값 넣는 방법
		int[] arr3;
		arr3 = new int[] {5,6,7,8,9};
		System.out.println("arr3의 첫번째 원소 = " + arr3[0]);
		System.out.println("arr3의 두번째 원소 = " + arr3[1]);
		System.out.println("arr3의 세번째 원소 = " + arr3[2]);
		System.out.println("arr3의 네번째 원소 = " + arr3[3]);
		System.out.println("arr3의 다섯번째 원소 = " + arr3[4]);
		System.out.println("arr3 배열 전체 원소 갯수 = " + arr3.length);	

		//	배열 원소의 값이 없이 일정 크기의 배열만 생성
		//	arr4에 원소의 type이 int인 공간 4개 생성 => 4bytes * 4 = 16bytes
		int[] arr4 = new int[4];
		arr4[0] = 10;
		arr4[1] = 20;
		arr4[2] = 30;
		arr4[3] = 40;
		System.out.println("arr4 배열 전체 원소 갯수 = " + arr4.length);
		
		
	}
}
