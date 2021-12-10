package p02.superclass_constructor3;

public class Parent {
	int homePhoneNumber;
	String name;
	int age;
	
	public Parent() {
		System.out.println("Parent - default constructor 호출");
	}
	
	public Parent(int homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
		System.out.println("Parent - Parent(int homePhoneNumber)" + 
					" constructor 호출");
	}
}
