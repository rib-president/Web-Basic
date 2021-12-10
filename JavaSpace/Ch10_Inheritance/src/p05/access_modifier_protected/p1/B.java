package p05.access_modifier_protected.p1;

public class B {
	public void method() {
		A a = new A();
		a.field = "value";
		a.method();
	}
}
