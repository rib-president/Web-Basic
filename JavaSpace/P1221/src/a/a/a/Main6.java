package a.a.a;

public class Main6 {
	public static void main(String[] args) {
		TestSomeClass c1 = TestSomeClass.getInstance();
		TestSomeClass c2 = TestSomeClass.getInstance();
		TestSomeClass c3 = TestSomeClass.getInstance();
		TestSomeClass c4 = TestSomeClass.getInstance();
		TestSomeClass c5 = TestSomeClass.getInstance();
		//...
		
		c1.test();
	}
}


// 객체가 단 한번만 생성되어야함(싱글톤)
// 본인 객체 생성(private static), 생성자(private), 메소드(static)
class TestSomeClass {
	// field...
	private static TestSomeClass instance = new TestSomeClass();
	// constructor
	private TestSomeClass() {
		
	}
	
	// method...
	public static TestSomeClass getInstance() {
		return instance;
	}
	
	public void test() {
		System.out.println("야호~! 집에 갈 시간....");
	}
}
