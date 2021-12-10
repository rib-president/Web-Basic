package p05.throw_exception;

public class ThrowEx2 {
	public static void main(String[] args) throws ClassNotFoundException {
		findClass();
		System.out.println("정상 처리됨");
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class cls = Class.forName("java.lang.String2");

	}
}
