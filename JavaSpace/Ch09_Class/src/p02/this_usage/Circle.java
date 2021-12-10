package p02.this_usage;

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

	public Circle(String newName, double newRadius) {
		//System.out.println("Circle(String newName, double newRadius) 호출함");
		name = newName;
		radius = newRadius;
		System.out.println("Circle(String newName, double newRadius) this = " + System.identityHashCode(this));
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
	
	public void printCircleInfomation() {
		System.out.println("피자이름 = " + name + ", 반지름 = " + radius
				+ ", 피자 면적 = " + getArea() + ", 피자 둘레 = " + getPerimeter() );
	}
}
