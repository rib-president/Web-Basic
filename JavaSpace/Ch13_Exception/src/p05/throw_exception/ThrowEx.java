package p05.throw_exception;

public class ThrowEx {
	public static void main(String[] args) {
		try {
		findClass();
		System.out.println("정상 처리됨");
		} catch(ClassNotFoundException e) {
			System.out.println("compile-time exception 처리");
		}
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class cls = Class.forName("java.lang.String2");

	}
}
