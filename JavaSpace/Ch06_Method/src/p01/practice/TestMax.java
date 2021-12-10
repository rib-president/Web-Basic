package p01.practice;

public class TestMax {
	public static void main(String[] args) {
		int i = 5;
		int j = 2;
		int k = max(i,j);
		
		System.out.println(i + " 와 " + j + " 중 최대값은 " + k + "입니다.");
		
		return;
	}
	
	//	2개의 숫자 중에 최대값(max)을 구하는 메소드를 정의
	public static int max(int num1, int num2) {
		int result;
		if(num1 > num2) {
			result = num1;
		} else {
			result = num2;
		}

		return result;
	}
}
