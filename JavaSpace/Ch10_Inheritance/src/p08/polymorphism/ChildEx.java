package p08.polymorphism;

public class ChildEx {
	public static void main(String[] args) {
		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();
		
		//	부모->자식으로 자동형변환(promotion)
		Parent parent = child;
		
		parent.method1();
		parent.method2();	//	overriding된 Child class method 호출
//		parent.method3();	overriding 안된 Child class method 호출불가
	
	}
}
