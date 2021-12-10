package p08.pass_object;

//	method의 parameter로 class instance를 넘기는 방법
public class TestPassObject {
	public static void main(String[] args) {
		
		Circle myCircle = new Circle(1);
		
		int times = 5;

		System.out.println("Radius \t\t Area");
		while (times >= 1) {
			System.out.println(myCircle.getRadius() + "\t\t" + 
					myCircle.getArea());
			myCircle.setRadius(myCircle.getRadius()+1);
			times--;
		}
	}
}
