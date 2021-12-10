package p04.final_class;

public final class Car {
	public int speed;
	
	public void speedUp() {
		speed++;
	}
	
	public void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
