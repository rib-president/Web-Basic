package p03.while_basic;

//	1부터 100까지의 합을 계산
public class WhileBasic2 {
	public static void main(String[] args) {
		int sum = 0;
		int number = 1;
		
		while (number <= 10) {
			sum = sum + number;
			System.out.println("중간 number 값 = " + number);
			System.out.println("중간 Sum 값 = " + sum);
			number++;
		}
		
		System.out.println("1~10까지의 합 " + sum);
	}
}
