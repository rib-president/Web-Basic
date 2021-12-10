package p05.for_basic;

//	for문에서 증감단위가 소숫점인 경우도 있는데, 소수점 사용가능
//	1.실제 코딩할 때 추천하지 않음
//		- 비추천 사유 : 소숫점 연산할 때 오차가 있어서 정확한 값을 도출할 수 없음
//					프로그래머가 예측한 결과값이 나오기 어려울 때가 많음
//	2.실수 값을 이용하여 for문을 사용해야되는 경우가 발생하면, 실수=>정수로 변환한 후
//		정수로 for문을 실행하고 마지막에 정수=>실수로 변환
public class ForBasic4 {
	public static void main(String[] args) {
		float fSum = 0.0f;

		for (float i=0.01f;i<=1.0f;i+=0.01f) {
			fSum += i;

		}
		System.out.println("fSum = " + fSum);
		
		double x = 0.001;
		double dSum = 0.0;
		for (double i=0.01;i<=1.0;i=i+0.01+x) {
			dSum += i;
		}
		System.out.println("dSum = " + dSum);
	}
}
