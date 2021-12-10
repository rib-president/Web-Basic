package p02.superclass_constructor3;

public class ConstructorEx {
	public static void main(String[] args) {
		Child c = new Child(21);
		
		System.out.println("집 전화번호 = " + c.homePhoneNumber);
		
		c.printParentInformation();
		
	}
}
