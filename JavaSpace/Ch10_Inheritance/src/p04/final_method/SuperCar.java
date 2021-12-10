package p04.final_method;


public class SuperCar extends Car {
	@Override
	public void speedUp() {
		speed += 10;
	}
//	final로 선언된 메소드를 오버라이딩할 수 없음	
//	@Override
//	public void stop() {
//		System.out.println("스포츠카를 멈춤");
//		speed = 0;
//	}
}
