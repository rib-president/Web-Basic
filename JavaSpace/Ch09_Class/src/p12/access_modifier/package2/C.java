package p12.access_modifier.package2;

import p12.access_modifier.package1.A;

public class C {
	//A a1 = new A(); default로 선언된 생성자는 다른 package에서 사용 불가
	A a2 = new A(1);	// public으로 선언된 생성자는 다른 package의 class에서도 사용 가능
	//A a3 = new A(1.0); private으로 선언된 생성자는 다른 class에서 사용불가

	// public default constructor
	public C() {
		//a2.a = 1; A.a는 default field
		a2.b = 2;
		//a2.c = 3; A.c는 private field
		
		//a2.printDefault(); default method
		a2.printPublic();
		//a2.printPrivate(); private method
	}
}
