package p08.default_method_abstract;

//	부모 인터페이스에서 선언된 디폴트메소드를 자식 인터페이스에서 추상메소드로 재선언
public class ChildInterfaceEx {
	public static void main(String[] args) {
		ChildInterface1 ci1 = new ChildInterface1() {
			
			@Override
			public void method1() {
				System.out.println("method1 실행");
			}
			
			@Override
			public void method2() {
				System.out.println("method2 실행");
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
