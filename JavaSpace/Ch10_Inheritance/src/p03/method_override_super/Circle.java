package p03.method_override_super;

public class Circle extends Shape {
	String name;
	
	@Override
	public void draw() {
		name = "Circle";
		super.name = "Shape_new";
		super.draw();
		System.out.println("name : " + name);
	}
}
