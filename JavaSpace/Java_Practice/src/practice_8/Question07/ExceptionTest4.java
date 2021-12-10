package practice_8.Question07;

public class ExceptionTest4 {
	public void exceptinoMethod(String[] args) {
		try {
			int num = Integer.parseInt(args[0]);
			int result = 10/num;
			System.out.println("result = " + result);
			return;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인자를 하나 입력해 주세요.");
		} catch(NumberFormatException e) {
			System.out.println("인자를 정수 타입으로 입력해 주세요.");		
		} catch(ArithmeticException e) {
			System.out.println("정수를 0으로 나누면 안 돼요.");
		} finally {
			System.out.println("반드시 실행될 영역");
		}
	}
	
	public static void main(String[] args) {
		ExceptionTest4 et4 = new ExceptionTest4();
		et4.exceptinoMethod(args);
	}
}

