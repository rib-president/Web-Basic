package p07.default_method_inheritance;

public class ChildInterfaceEx {
	public static void main(String[] args) {
		ChildInterface1 ci1 = new ChildInterface1() {
			
			@Override
			public void method1() {
				System.out.println("method1 실행");
			}
			
			@Override
			public void method3() {
				System.out.println("method3 실행");			
			}
		};
		ci1.method1();
		ci1.method2();
		ci1.method3();
	}
}
