package p07.default_method_use;

public interface MyInterface {
	void method1();
	
	//	interface에서 default method 추가
	default void method2() {
		System.out.println("MyInterface - default method 실행");
	}
}
