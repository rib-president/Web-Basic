package p02.superclass_constructor;

public class Child extends Parent {
	public Child() {
		System.out.println("Child - default constructor 호출");
	}
	public Child(int homePhoneNumber) {
		System.out.println("Child - Child(int homePhoneNumber)" + 
					" constructor 호출");
	}
}
