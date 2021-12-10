package p02.call_by_reference.practice;

//	parameter로 배열을 넘기는 장점과 표기법
//	1.여러개의 primitive값들을 비교하여 예로, 최대값 구하는 메소드를 구현할 때
//	비교하고자하는 parameter 개수가 변동될 때마다 기능이 비슷한 메소드를 여러개 생성해야함
//	2.1번의 문제점을 해결하는 것은 parameter로 배열을 이용하는 것
//	3.배열과 유사한 다른 표기법 => '...' 사용하는 표기법
public class VarArgsDemo {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		int[] numbers = new int[3];
		
//		printMaxOfTwoParameter(a, b);
//		printMaxOfTwoParameter(a, b, c);

		numbers[0] = a;
		numbers[1] = b;
		numbers[2] = c;

		printMax(numbers);
		printMax(a,b);
		printMax(a,b,c);
		printMax(1,2,3,4,5,6,7);
	
	}
	
//	public static void printMax(int[] num) {
//		int max = -99999999;
//		
//		for(int i=0;i<num.length;i++) {
//			if (num[i] > max) {
//				max = num[i];
//			}
//		}
//		System.out.println("max = " + max);
//	}
	
	public static void printMax(int... num) {
		int max = -99999999;
		
		for(int i=0;i<num.length;i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		System.out.println("max = " + max);
	}	
	
	public static void printMaxOfTwoParameter(int a, int b) {
		int max;
		if (a > b) {
			max = a;
		} else {
			max = b;
		}
		System.out.println("max = " + max);
	}
	
	public static void printMaxOfTwoParameter(int a, int b, int c) {
		int max = 0;
		
		//	3개의 값 중에 최대를 구하는 로직 코딩
	}
}
