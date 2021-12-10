package p01.nested_class;

public class Outer {
	public Outer() {
		System.out.println("Outer class 인스턴스 생성됨");
	}
	
	//	중첩클래스인 instance class 선언
	class Inner_Instance {
		int field1;
		//static int field2;
		
		public Inner_Instance() {
			System.out.println("Inner_Instance class 인스턴스 생성됨");
		}
		
		void method1() {
			
		}
		
//		static void method2() {
//			
//		}
	}
	
	//	중첩클래스인 static class 선언
	static class Inner_Static {
		int field1;
		static int field2;
		
		public Inner_Static() {
			System.out.println("Inner_Static class 인스턴스 생성됨");
		}
		
		void method1() {	}
		
		static void method2() {	}
	}
	
	void outer_method() {
		//	중첩클래스인 local class (method 안에서 선언된 클래스)
		class LocalClass {
			int field1;
			//static int field2;
			
			public LocalClass() {
				System.out.println("Local class 인스턴스 생성됨");
			}
			
			void method1() {	}
			
			//static void method2() {	}
		}
		
		LocalClass l = new LocalClass();
		l.field1 = 3;
		l.method1();
	}
}
