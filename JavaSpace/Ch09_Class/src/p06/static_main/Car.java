package p06.static_main;

public class Car {
	int speed;
	String name;
	static String color;
	
	public static void main(String[] args) {
		// static method에서는 static field, static method 사용 가능
		color = "red";
		printHello();
		
		//	instance field, instance method는 static method에서 사용 불가
		//speed = 0;
		//printInstanceHello();
		Car car = new Car();
		car.speed = 0;
		car.printInstanceHello();
	}
	
	public static void printHello() {
		System.out.println("Hello, static method");
	}
	
	public void printInstanceHello() {
		name = "Honggildong";
		System.out.println("Hello, instance method");
	}
}