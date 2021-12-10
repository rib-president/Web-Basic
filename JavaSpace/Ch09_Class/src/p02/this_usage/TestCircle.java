package p02.this_usage;

public class TestCircle {
	public static void main(String[] args) {
		Circle plainPizza = new Circle();
		System.out.println("plainPizza 참조 주소값 = " + System.identityHashCode(plainPizza));		
		plainPizza.printCircleInfomation();
		
		System.out.println();
		
		Circle largePizza = new Circle(12);
		System.out.println("largePizza 참조 주소값 = " + System.identityHashCode(largePizza));		
		largePizza.printCircleInfomation();
		
		System.out.println();
		
		Circle supremePizza = new Circle("슈퍼슈프림피자", 15);
		System.out.println("supremePizza 참조 주소값 = " + System.identityHashCode(supremePizza));		
		supremePizza.printCircleInfomation();

	}
}
