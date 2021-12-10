package p01.practice;

//	배열 복사(A배열 원소의 값 전체를 B배열 원소로 값을 복사)
//	- 예로 sourceArray의 값 전체를 targetArray로 복사
public class ArrayCopy {
	public static void main(String[] args) {
		int[] sourceArray = {2, 3, 1, 5, 10, 7};
		int[] targetArray = new int[sourceArray.length];
		
		//	복사방법 1.for문을 사용하여 단순 복사
		for(int i=0;i<sourceArray.length;i++) {
			targetArray[i] = sourceArray[i];
		}
		
		for (int i=0;i<targetArray.length;i++) {
			System.out.println("targetArray[" + i + "] = " + 
						targetArray[i]);
		}
	}
}
