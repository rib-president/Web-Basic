package p12.access_modifier.package1;

public class B {
	A a1 = new A();
	A a2 = new A(1);
	//A a3 = new A(1.0); private으로 선언된 생성자는 다른 class에서 사용불가

	// public default constructor
	public B() {
		a1.a = 1;
		a1.b = 2;
		//a1.c = 3; A.c는 private field
		
		a1.printDefault();
		a1.printPublic();
		//a1.printPrivate(); private method
	}
}
