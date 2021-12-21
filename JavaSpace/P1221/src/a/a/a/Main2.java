package a.a.a;

public class Main2 {
	public static void main(String[] args) {
		AAA obj1 = new AAA();
		AAA obj2 = new AAA();
		
		obj1.a = 10;
		obj2.a = 20;
		
		obj1.print();
		obj2.print();
		
		AAA.c = 10;
		AAA.test2();
	}
}

class MyUtil {
	//기능과 관련
}


class AAA {
	int a;
	int b;
	static int c;
	
	void print() {
		System.out.println(this.a);
	}
	
	void test1() {
		// this가 존재
		a = 10;
	}
	
	static void test2() {
		// this 없음
		//a = 10;
	}
}