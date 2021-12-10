package p06.use_static_instance;

public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		
		Circle c2 = new Circle(5);
		
		c1.radius = 9;
		
		System.out.println("new로 c2 인스턴스 생성하고 c1 인스턴스 속성값 수정 후");
		System.out.println("c1 반지름 = " + c1.radius + ", Circle 인스턴스의 갯수 = " + c1.numberOfObjects);
		System.out.println("c2 반지름 = " + c2.radius + ", Circle 인스턴스의 갯수 = " + c2.numberOfObjects);

		System.out.println("static method를 사용한 Circle 인스턴스의 갯수 = " + Circle.getNumberOfObjects());
		System.out.println("static method를 사용한 Circle 인스턴스의 갯수(c1) = " + c1.getNumberOfObjects());
		System.out.println("static method를 사용한 Circle 인스턴스의 갯수(c2) = " + c2.getNumberOfObjects());

	}
}
