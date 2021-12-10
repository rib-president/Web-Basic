package practice_8.Question06;

public class CasioCal implements Calculator {

	@Override
	public void add(int num1, int num2) {
		System.out.println("합 은: " + (num1 + num2));
	}

	@Override
	public void sub(int num1, int num2) {
		System.out.println("빼기는: " + (num1 - num2));
	}

	@Override
	public void divide(int num1, int num2) {
		if(num2 != 0) {
			System.out.println("나누기는: " + (num1 / num2));
		} else System.out.println("0으로 나눌 수 없습니다.");
	}

	@Override
	public void multiple(int num1, int num2) {
		System.out.println("곱하기는: " + (num1 * num2));
	}
}
