package p01.basic;

//	class 이름 : Circle(원을 class로 만든 것)
//	1.class 속성(field) : radius
//	2.class 생성자(constructor) : Circle(), Circle(double newRadius)
//	3.class method : getArea(), getPerimeter(), setRadius()
//	4.생성자(constructor) overloading : method의 overloading과 동일 개념
public class Circle {
	double radius = 1;
	
	//	constructor
	public Circle() {
		System.out.println("Circle 생성자 호출하였습니다.");
	}
	
	public Circle(double newRadius) {
		System.out.println("Circle(double newRadius) 생성자 호출하였습니다.");

		radius = newRadius;
	}
	//	원의 면적
	public double getArea() {
		return radius * radius * Math.PI;
	}
	//	원의 둘레 계산
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	//	원의 반지름 값 변경하기
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
}
