package a.a.a;

public class Main1 {
	public static void main(String[] args) {
//		AAA a1 = new AAA();
//		BBB b1 = new BBB();
//		CCC c1 = new CCC();
//		
//		a1.testA();
//		b1.testB();
//		c1.testA();
		
		AAA a1 = new AAA();
		//BBB b1 = new AAA();
		BBB b1 = new BBB();		// 다형성X
		AAA b2 = new BBB();		// 다형성O
		
		CCC c1 = new CCC();
		AAA c2 = new CCC();		// 다형성O
		
		//BBB b1 = new CCC();

		QQQ q1 = new QQQ();
		QQQ q2 = new AAA();
		QQQ q3 = new BBB();
		QQQ q4 = new CCC();
		
		// 신경써야될 점
		BBB b3 = new BBB();
		b3.b1 = 10;
		
		AAA a3 = new BBB();
		//a3.b1 = 20;
		
		AAA a4 = new AAA();
		BBB b4 = new BBB();
		CCC c4 = new CCC();
		
		AAA[] arr = new AAA[3];
		arr[0] = a4;
		arr[1] = b4;
		arr[2] = c4;
		
		QQQ q5 = new QQQ();
		q5.test1();
		
		AAA a5 = new AAA();
		a5.test1();
		
		BBB b5 = new BBB();
		b5.test1();
		
		QQQ q6 = new QQQ();
		q6.test1();
		
		QQQ a6 = new AAA();
		a6.test1();
		
		QQQ b6 = new BBB();
		b6.test1();
		
		//////////////////////////////////////////
		
		//DDD d1 = new DDD();	추상클래스는 인스턴스 생성x
		DDD d1 = new EEE();
		DDD d2 = new FFF();
		
		d1.testD();
		d2.testD();
		d1.testDD();
		d2.testDD();
		
		EEE e1 = new EEE();
		e1.testE();
	}
}

abstract class DDD {
	int d1;
	int d2;
	
	abstract void testD();
	
	void testDD() {
		System.out.println("DDD의 메소드...");
	}
}

class EEE extends DDD {
	void testD() {
		System.out.println("EEE의 메소드...");
	}
	
	void testE() { }
}

class FFF extends DDD {
	void testD() {
		System.out.println("FFF의 메소드...");
	}
}


class QQQ {
	void test1() {
		System.out.println("QQQ의 메소드 호출됨");
	}
}

class AAA extends QQQ {
	int a1;
	int a2;
	void testA() { }
	
	void testAA() { }
	
	void test1() {
		System.out.println("AAA의 메소드 호출됨");
	}
}

class BBB extends AAA {
	int b1;
	int b2;	
	void testB() { }
	
	void test1() {
		System.out.println("BBB의 메소드 호출됨");
	}
}

class CCC extends AAA {
	int c1;
}