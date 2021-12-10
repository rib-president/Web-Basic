package practice_8.Question07;
// 여러개의 예외처리한 경우
public class ExceptionTest3 {
	public static void main(String[] args) {
		try {
			int num = Integer.parseInt(args[0]);
			int result = 10/num;
			System.out.println("result = " + result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인자를 하나 입력해 주세요.");
		} catch(NumberFormatException e) {
			System.out.println("인자를 정수 타입으로 입력해 주세요.");		
		} catch(ArithmeticException e) {
			System.out.println("정수를 0으로 나누면 안 돼요.");
		} 
		System.out.println("프로그램 계속 실행됨");

	}
}
