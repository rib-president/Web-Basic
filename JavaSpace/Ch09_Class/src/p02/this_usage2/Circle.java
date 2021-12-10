package p02.this_usage2;

public class Circle {
	double radius;
	String name;
	
	public Circle() {
		this("플레인피자", 10);
		System.out.println("Circle() this = " + System.identityHashCode(this));
	}

	public Circle(double newRadius) {
		this("플레인피자", newRadius);
		System.out.println("Circle(double newRadius) this = " + System.identityHashCode(this));
	}

	public Circle(String name, double radius) {
		//System.out.println("Circle(String newName, double newRadius) 호출함");
		this.name = name;
		this.radius = radius;
		System.out.println("Circle(String newName, double newRadius) this = " + System.identityHashCode(this));
	}
	
	public double getArea() {
		return this.radius*this.radius*Math.PI;
	}
	
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void printCircleInfomation() {
		System.out.println("피자이름 = " + this.name + ", 반지름 = " + this.radius
				+ ", 피자 면적 = " + getArea() + ", 피자 둘레 = " + getPerimeter() );
	}
}
