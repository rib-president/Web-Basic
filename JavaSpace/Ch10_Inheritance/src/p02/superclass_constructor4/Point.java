package p02.superclass_constructor4;

// 좌표상의 Point 점(x, y)을 color를 입혀 상속 실습
public class Point {
	int x, y;

	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
}
