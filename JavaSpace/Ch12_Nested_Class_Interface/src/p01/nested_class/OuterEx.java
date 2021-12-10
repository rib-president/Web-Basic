package p01.nested_class;

public class OuterEx {
	public static void main(String[] args) {
		Outer o = new Outer();
		
		//	Inner_Instance class 사용 예
		Outer.Inner_Instance oi = o.new Inner_Instance();
		oi.field1 = 3;
		oi.method1();
		
		//	Inner_Static class 사용 예
		Outer.Inner_Static os = new Outer.Inner_Static();
		os.field1 = 3;
		os.field2 = 5;
		Outer.Inner_Static.field2 = 6;
		os.method1();
		os.method2();
		Outer.Inner_Static.method2();
		
		//	LocalClass 클래스 사용 예
		o.outer_method();
	}
}
