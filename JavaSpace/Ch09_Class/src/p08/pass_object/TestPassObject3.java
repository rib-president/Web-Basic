package p08.pass_object;

//	method의 parameter로 class instance를 넘기는 방법
public class TestPassObject3 {
	public static void main(String[] args) {
		
		//Circle myCircle = new Circle(1);
		Circle myCircle = createCircleInstance(1);
		System.out.println("myCircle 주소 = " + System.identityHashCode(myCircle));
		
		int n = 5;
		printAreas(myCircle, n);

	}
		
	public static void printAreas(Circle c, int times) {
		System.out.println("Radius \t\t Area");
		while (times >= 1) {
			System.out.println(c.getRadius() + "\t\t" + 
					c.getArea());
			c.setRadius(c.getRadius()+1);
			times--;
		}
	}
	
	public static Circle createCircleInstance(double radius) {
		Circle c = new Circle(radius);
		System.out.println("c 주소 = " + System.identityHashCode(c));
		
		return c;
	}
}
