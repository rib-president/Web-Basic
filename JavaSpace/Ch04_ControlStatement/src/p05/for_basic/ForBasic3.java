package p05.for_basic;

//	3개의 for문이 중첩된 경우 예
//	1.전체 실행 횟수 ?, 3개 이상의 중첩된 for문을 사용하면 프로그램 실행 속도를 크게
//	저하시킬 수 있어 사용하는데 조심해야 함
//	2.실무에서 중첩 for문을 사용할 경우, 가능하면 2단으로 코딩하고 3단으로 코딩은 피해라
//	3.쩔 수 없이 중첩된 3개의 for문을 사용할 경우 반드시 전에 반복 횟수 확인하고 할 것 
public class ForBasic3 {
	public static void main(String[] args) {

		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				for (int k=0;k<10;k++) {
					//	아래 명령어를 총 1000번 실행(i가 10회 * j가 10회
					//	* k가 10회)
					System.out.println("3개 숫자의 곱 = " + (i*j*k));

				}
			}
		}
		
//		for (int i=0;i<10000;i++) {
//			for (int j=0;j<10000;j++) {
//				for (int k=0;k<10000;k++) {
//					//	아래 명령어를 총 1조번 실행(i가 10000회 * 
//					//	j가 10000회	* k가 10000회)
//					System.out.println("3개 숫자의 곱 = " + (i*j*k));
//				}
//			}
//		}
	}
}
