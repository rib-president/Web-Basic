package p06.use_static_instance;

public class Circle {
	double radius;
	static int numberOfObjects = 0;
	
	public Circle() {
		radius = 1;
		numberOfObjects++;
	}

	public Circle(double newRadius) {
		this.radius = newRadius;
		numberOfObjects++;
	}
	
	static int getNumberOfObjects() {
		//printHello();
		//getArea();
		//getPerimeter();
		//this.radius = 10;
		return numberOfObjects;
	}

	
	public double getArea() {
//		printHello();
//		numberOfObjects = 20;
		return this.radius*this.radius*Math.PI;
	}
	
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	private void printHello() {
		System.out.println("Hello, static variable");
	}
	
}
