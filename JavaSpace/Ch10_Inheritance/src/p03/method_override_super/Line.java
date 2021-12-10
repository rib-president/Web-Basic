package p03.method_override_super;

public class Line extends Shape {
	//String name;
	
	@Override
	public void draw() {
		System.out.println("name : " + name);
	}
}
