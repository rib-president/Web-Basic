package p07.default_method_use;

public class DefaultMethodEx {
	public static void main(String[] args) {
		//	기존 고객용 변수
		MyInterface mi1 = new MyClassA();
		
		mi1.method1();
		mi1.method2();
		
		//	신규 고객용 변수
		MyInterface mi2 = new MyClassB();
		mi2.method1();
		mi2.method2();
		
	}
}
