package p03.method_override;

public class MethodOverridingEx2 {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.paint();
		
		Line line = new Line();
		line.paint();
		
		Rect rect = new Rect();
		rect.paint();
		
		Circle circle = new Circle();
		circle.paint();
	}
}
