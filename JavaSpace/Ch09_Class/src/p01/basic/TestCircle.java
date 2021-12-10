package p01.basic;

//	Circle class 사용 방법
//	1.new Circle() 명령어를 사용하여 Circle class 객체인 c 변수 생성
//	2.Circle class 객체인 c 변수를 사용하여, Circle class의 field와 
//	method 사용
//	3.Circle c = new Class이름()의 기계어 관점의 내부 실행 순서
//	 1) new를 실행 : heap memory Circle class의 객체를 만들고 객체의 주소값
//		을 갖고 있음
//	 2) Circle class의 생성자 method인 public Circle() {}를 실행함
//	 3) heap memory에서 생성된 Circle class 객체의 주소값 변수 c로 넘겨줌
//	4.TestCircle이름을 가진 class에서 Circle class(부품)의 속성(field)과
//	method를 사용
public class TestCircle {
	public static void main(String[] args) {
		Circle c = new Circle();
		//	class circle의 field인 radius에 접근하여 값을 읽어올 수 있음
		System.out.println("Circle class 객체인 c의 반지름 = " + c.radius);
		//	class circle의 method인 getArea(), getPerimeter()를 사용
		System.out.println("Circle class 객체인 c의 면적 = " + c.getArea());
		System.out.println("Circle class 객체인 c의 둘레 = " + c.getPerimeter());
		
		c.setRadius(3);
		System.out.println("반지름 변경후의 Circle class 객체인 c의 반지름 = "
				 + c.radius);
		System.out.println("반지름 변경후의 Circle class 객체인 c의 면적 = "
				 + c.getArea());
		System.out.println("반지름 변경후의 Circle class 객체인 c의 둘레 = "
				 + c.getPerimeter());

		System.out.println();
		
		Circle c2 = new Circle(2);
		//	class circle의 field인 radius에 접근하여 값을 읽어올 수 있음
		System.out.println("Circle class 객체인 c2의 반지름 = " + c2.radius);
		//	class circle의 method인 getArea(), getPerimeter()를 사용
		System.out.println("Circle class 객체인 c2의 면적 = " + c2.getArea());
		System.out.println("Circle class 객체인 c2의 둘레 = " + c2.getPerimeter());
	}
}
