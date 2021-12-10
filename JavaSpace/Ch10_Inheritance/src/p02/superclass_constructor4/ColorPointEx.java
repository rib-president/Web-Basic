package p02.superclass_constructor4;

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
		
		ColorPoint cp1 = new ColorPoint(5, 6);
		cp1.setColor("yellow");
		cp1.showColorPoint();
		
		ColorPoint cp2 = new ColorPoint("blue", 7, 8);
		cp2.showColorPoint();
	}
}
