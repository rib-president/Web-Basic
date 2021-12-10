package p01.basic2;

// 좌표상의 Point 점(x, y)을 color를 입혀 상속 실습
public class Point {
	int x, y;

	public Point() {
		
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("x = " + this.x + ", y = " + this.y);
	}
}
