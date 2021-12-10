package practice_3;

import java.util.Scanner;

//	console에서 정수를 입력 받아 입력된 정수 숫자의 각 digit를 더한 값을 구하는
//	메소드를 만드시오.
public class Question09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수를 입력하시오.");
		long n = input.nextLong();
		int sum = sumDigits(n);
		
		System.out.println(n + "의 각 digit을 더한 값은 = " + sum + "입니다.");
		
		input.close();
	}
	
	public static int sumDigits(long n) {
		int sum = (int)n % 10;
		while(n/10 > 0) {
			n = n / 10;			
			sum += n % 10;
		}
		return sum;
	}
}
