package p06.static_variable;

public class TestCircleWithStaticField {
	public static void main(String[] args) {
		System.out.println("new로 인스턴스 생성 전의 Circle 인스턴스의 "
				+ "개수 = " + Circle.numberOfObjects);
		
		Circle c1 = new Circle();		
		System.out.println("new로 c1 인스턴스 생성 후의 Circle 인스턴스의 "
				+ "개수 = " + c1.numberOfObjects);
		
		Circle c2 = new Circle(5);
		c1.radius = 9;

		//c1.numberOfObjects = 10;
		System.out.println("new로 c2 인스턴스 생성하고 c1 인스턴스 속성값 "
				+ "수정 후");
		System.out.println("c1 반지름 = " + c1.radius + "Circle 인스턴스의 " 
				+ "갯수 = " + c1.numberOfObjects);
		System.out.println("c2 반지름 = " + c2.radius + "Circle 인스턴스의 " 
				+ "갯수 = " + c2.numberOfObjects);		
		
		System.out.println("static method를 사용한 Circle 인스턴스의 "
				+ "갯수 = " + Circle.getNumberOfObjects());
		System.out.println("static method를 사용한 Circle 인스턴스의 "
				+ "갯수(c1) = " + c1.getNumberOfObjects());
		System.out.println("static method를 사용한 Circle 인스턴스의 "
				+ "갯수(c2) = " + c2.getNumberOfObjects());
		
	}
}
