package practice_8.Question07;

public class ExceptionTest6 {
	public void exceptionMethod() throws Exception{
		// 일반예외가 발생했는데 예외처리하지 않아 컴파일오류 발생
		throw new Exception("강제로 throw Exception을 발생시킴");
	}
	
	public static void main(String[] args) {
		ExceptionTest6 et = new ExceptionTest6();
		try {
			et.exceptionMethod();
		} catch (Exception e) {
			System.out.println("호출한 메소드에서 예외처리함");
			System.out.println(e);
		}
	}
}
