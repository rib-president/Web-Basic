package practice_8.Question07;

public class ExceptionTest5 {
	public void exceptionMethod() {
		// 일반예외가 발생했는데 예외처리하지 않아 컴파일오류 발생
//		throw new ClassNotFoundException();
	}
	
	public static void main(String[] args) {
		ExceptionTest5 et = new ExceptionTest5();
		et.exceptionMethod();
	}
}
