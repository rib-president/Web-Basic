package p01.practice;

import java.util.Scanner;

//	최대공약수(GCD " Greatest Common Divisor) 메소드 구현 예제
public class GreatestCommonDivisorMethod {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("첫번째 정수값을 입력하세요. ");
		int n1 = input.nextInt();

		System.out.println("두번째 정수값을 입력하세요. ");
		int n2 = input.nextInt();
		
		System.out.println("입력된 정수 " + n1 + "와 " + n2  +
				"의 최대공약수는 " + gcd(n1, n2) + "입니다.");
		
		input.close();
	}

	//	2개의 정수값 a, b에 대해서 2부터 시작해서 1씩 증가시키면서 a,b 둘다 나눠지는지 확인
	private static int gcd(int n1, int n2) {
		int gcd = 1;
		int k = 2;	//	gcd 계산할 때 시작 정수값
		
		while (k <= n1 && k <= n2) {
			if (n1 % k ==0 && n2 % k == 0) {
				gcd = k;
//				System.out.println("임시 gcd값 " + gcd);
			}
			k++;
		}		
		return gcd;
	}
	
}
