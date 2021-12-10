package p03.while_basic;


// 1) 1,2,3,...,9까지 짝수인 숫자만 출력
// 2) 1,2,3,...,9까지 짝수인 합을 계산하여 출력
public class WhileBasic3 {
	public static void main(String[] args) {
		int sum = 0;
		int number = 1;
		
		while (number < 10) {
			if ((number % 2) == 0) {
				System.out.println("짝수 number = " + number);
				sum += number;
			}
			number++;
		}
		System.out.println("1~9사이의 짝수 숫자의 합 = " + sum);
	}
}
