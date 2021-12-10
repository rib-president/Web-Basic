package p03.method_override_super;

public class MethodOverridingEx {
	public static void main(String[] args) {
//		Shape shape = new Shape();
//		shape.name = "shape_instance";
//		shape.draw();
//		
		Line line = new Line();
//		line.name = "line_instance";
		line.draw();
//		
//		Rect rect = new Rect();
//		rect.name = "rect_instance";
//		rect.draw();
		
		Circle circle = new Circle();
		circle.draw();
	}
}
