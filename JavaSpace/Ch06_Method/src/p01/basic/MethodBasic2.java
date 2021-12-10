package p01.basic;

public class MethodBasic2 {
	public static void main(String[] args) {
		System.out.println("1과 10사이의 합 = " + sum(1, 10));
		System.out.println("1과 10사이의 합 = " + sum(27, 37));
		System.out.println("1과 10사이의 합 = " + sum(35, 49));
	}

	
	public static int sum(int startValue, int endValue) {
		int result = 0;
		
		for(int i=startValue;i<=endValue;i++) {
			result += i;
		}
		return result;
	}
}
