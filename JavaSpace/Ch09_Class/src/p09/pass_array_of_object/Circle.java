package p09.pass_array_of_object;

//	class 이름 : Circle(원을 class로 만든 것)
//	field를 static으로 선언
public class Circle {
	private double radius = 1;
	private static int numberOfObjects = 0;	// new로 생성된 인스턴스 개수를 관리
	
	//	constructor
	public Circle() {
		this.radius = 1;
		numberOfObjects++;
	}
	
	public Circle(double newRadius) {
		this.radius = newRadius;
		numberOfObjects++;
	}

	// getter : field의 값을 읽어오는 method
	public double getRadius() {
		return radius;
	}

	// setter : field의 값을 변경하는 method
	public void setRadius(double radius) {
		if (radius >= 0) {
			this.radius = radius;
		} else {
			this.radius = 0;
		}
	}

	//	getter method
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}

	public double getArea() {
		//printHello();
		return this.radius*this.radius*Math.PI;
	}
	
	private void printHello() {
		System.out.println("Hello");
	}
	
}
