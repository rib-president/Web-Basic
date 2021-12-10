package p03.object_method_practice;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point)obj;
			if(this.x == p.x && this.y == p.y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ("Point x = " + x + ", y = " + y);
	}
}
