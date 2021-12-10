package p11.practice.basic;

public class TestCircleRectangle {
	public static void main(String[] args) {
		Circle circle = new Circle(1);
		
		System.out.println("Circle 정보 = " + circle.toString());
		System.out.println("Circle color = " + circle.getColor());
		System.out.println("Circle radius = " + circle.getRadius());
		System.out.println("Circle area = " + circle.getArea());
		System.out.println("Circle diameter = " + circle.getDiameter());
		
		Rectangle rectangle = new Rectangle(2, 4);
		System.out.println("Rectangle 정보 = " + rectangle.toString());
		System.out.println("Rectangle area = " + rectangle.getArea());
		System.out.println("Rectangle perimeter = " + rectangle.getPerimeter());
		
	}
}
