package p01.basic;

//	array에서 for문 사용
//	1.배열에서 for문을 사용하여 코딩량을 대폭 줄일 수 있음
//		-배열 원소의 시작 index값: 0, 배열 마지막 원소의 index값: arr.length-1
//		-배열 원소의 개수에 변동이 생겨도 for문 자체 코딩을 수정하지 않아도 됨
//	향상된 for문
public class ArrayBasic2 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60};
		double[] arr2 = {1.0, 2.0, 3.0, 4.0};
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr[" + i + "] = " + arr[i] );
		}
			for(int i=0;i<arr2.length;i++) {
				System.out.println("arr2[" + i + "] = " + arr2[i] );				
		}
		
		//	element : arr배열의 원소값을 저장한느 임시 변수
		//	=> arr 원소 개수만큼 for문 반복 실행
		//	1.int element : arr == int i=0;i<arr.length;i++
		//	2.element는 arr[i]	
		for (int element : arr) {
			System.out.println(element);
		}
		
		for (double elem : arr2) {
			System.out.println(elem);
		}
			
	}
}