package p02.superclass_constructor2;

public class Parent {
	int homePhoneNumber;
	
	public Parent() {
		System.out.println("Parent - default constructor 호출");
	}
	
	public Parent(int homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
		System.out.println("Parent - Parent(int homePhoneNumber)" + 
					" constructor 호출");
	}
}
