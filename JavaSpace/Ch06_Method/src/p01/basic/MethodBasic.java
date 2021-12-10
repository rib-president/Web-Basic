package p01.basic;

//	Method가 왜 필요한지, 예제를 통해 설명
//	문제 : 코딩할 때 합계처럼 거의 유사한 코드를 반복해서 코딩하는 경우, 소스코드
//	양도 늘어나고 copy&paste로 에러 발생 소지도 있음
public class MethodBasic {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i=1;i<=10;i++) {
			sum += i;
		}
		System.out.println("1과 10사이의 합 = " + sum);
		
		sum = 0;
		for (int i=27;i<=37;i++) {
			sum = sum + i;
		}
		System.out.println("27과 37사이의 합 = " + sum);

		sum = 0;
		for (int i=35;i<=49;i++) {
			sum = sum + i;
		}
		System.out.println("35과 49사이의 합 = " + sum);
	}
}
