package p12.access_modifier.package1;

//	생성자 이름에 public, private이 없는 경우 기본 default access modifier
public class A {
	int a = 10;	// a : default access modifier로 선언된 field
	public int b = 20;	// b : public access modifier로 선언된 field
	private int c = 30;	// c : private access modifier로 선언된 field
	
	// default access modifier
	A() {
		
	}
	// public access modifier
	public A(int a) {
		
	}
	// private access modifier	
	private A(double d) {
		
	}
	// public access modifier method
	public void printPublic() {
		System.out.println("public method");
	}
	// default access modifier method
	void printDefault() {
		System.out.println("default method");
	}
	// private access modifier method
	private void printPrivate() {
		System.out.println("private method");
	}
}
