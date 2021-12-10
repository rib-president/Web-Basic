package p07.default_method_use;

public class MyClassB implements MyInterface {

	@Override
	public void method1() {
		System.out.println("MyClassB - method1실행");
	}
	@Override
	public void method2() {
		System.out.println("MyClassB - default method 실행");
	}	
}
