package p03.method_override2;

public class Computer extends Calculator {
	
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 인스턴스의 areaCircle() 메소드 실행");
	
		return Math.PI * r * r;
	}
}
