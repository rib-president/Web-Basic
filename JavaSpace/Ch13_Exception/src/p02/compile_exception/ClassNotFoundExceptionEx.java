package p02.compile_exception;

//	Class.forName() 메소드 선언부 끝에 throws 키워드 있음
//	=> try~catch 또는 throws를 이용해 예외처리해야함
public class ClassNotFoundExceptionEx {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("java.lang.String2");
			System.out.println("클래스가 존재합니다.");
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
}
