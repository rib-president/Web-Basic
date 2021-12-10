package p01.basic2;

public class Circle {
	double radius = 1;
	String name = "플레인피자";
	
	
	public Circle() {
		
	}
	
	public Circle(double newRadius) {
		radius = newRadius;
	}
	
	public Circle(String newName) {
		name = newName;
	}
	
	public Circle(double newRadius, String newName) {
		radius = newRadius;
		name = newName;
	}
	
	public double getArea() {
		return radius*radius*Math.PI;
	}
	
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
}
