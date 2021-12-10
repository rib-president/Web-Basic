package p06.static_variable;

//	class 이름 : Circle(원을 class로 만든 것)
//	field를 static으로 선언
public class Circle {
	double radius = 1;
	static int numberOfObjects = 0;	// new로 생성된 인스턴스 개수를 관리
	
	//	constructor
	public Circle() {
		this.radius = 1;
		numberOfObjects++;
	}
	
	public Circle(double newRadius) {
		this.radius = newRadius;
		numberOfObjects++;
	}
	//	원의 면적
	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}
	//	원의 둘레 계산
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	//	원의 반지름 값 변경하기
	public void setRadius(double newRadius) {
		this.radius = newRadius;
	}
	
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
}
