package p01.basic2;

public class ColorPoint extends Point {
	private String color;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setColorAndPoint(String color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public void showColorPoint() {
		System.out.print("color = "  + color + ", ");
		showPoint();
	}
}
