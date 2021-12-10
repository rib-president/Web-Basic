package p02.superclass_constructor3;

public class Child extends Parent {
	
	public Child() {
		System.out.println("Child - default constructor 호출");
	}
	public Child(int homePhoneNumber) {
		super(homePhoneNumber);
		
		System.out.println("Child - Child(int homePhoneNumber)" + 
					" constructor 호출");
	}
	
	public void printParentInformation() {
		super.name = "홍아버지";
		super.age = 55;
		System.out.println("Parent 이름 = " + super.name  + " Parent 나이 = "
				 + super.age);
		
		System.out.println(System.identityHashCode(this));
	}
}
