package p01.basic2;

public class ColorPointEx {
	public static void main(String[] args) {
		Point p = new Point();
		p.set(1,  2);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
//		cp.set(3,  4);
//		cp.setColor("red");
		cp.setColorAndPoint("red", 3, 4);
		cp.showColorPoint();
		
	}
}
