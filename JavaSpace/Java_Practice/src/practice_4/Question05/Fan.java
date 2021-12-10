package practice_4.Question05;

//	선풍기 Fan class를 만들고 테스트 하시오.
public class Fan {
	static final int SLOW = 1;
	static final int MEDIUM = 2;
	static final int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	
	Fan() {
		
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		if(this.getOn()) {
			if(speed >= SLOW && speed <= FAST) {
				this.speed = speed;
			} else {
				System.out.println("설정 가능한 speed는 " + SLOW + ", " + 
						MEDIUM + ", " + FAST + "입니다.");
			}
		} else {
			System.out.println("speed는 전원이 켜진 상태에서 설정가능합니다.");
		}
	}
	
	public boolean getOn() {
		return this.on;
	}
	
	public void setOn(boolean on) {
		if(this.on != on) {
			if(on) System.out.println("선풍기 전원을 켭니다.");
			else System.out.println("선풍기 전원을 종료합니다.");
		} 
		this.on = on;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		if(this.getOn()) {
			if(radius > 0) {
				this.radius = radius;
			} else {
				System.out.println("radius는 양수여야 합니다.");
			}
		} else {
			System.out.println("radius는 전원이 켜진 상태에서 설정가능합니다.");			
		}
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void printFanInformation() {
		if(this.on) {
			System.out.println("<현재 선풍기 상태>");
			System.out.println("speed: " + this.getSpeed());
			System.out.println("radius: " + this.getRadius());
			System.out.println("color: " + this.getColor());
		} else {
			System.out.println("선풍기가 꺼져 있습니다.");
		}
		System.out.println();
	}
}
