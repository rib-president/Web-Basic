
class Atom {
	Atom() {
		System.out.print("atom ");
	}
}

class Rock extends Atom {
	Rock(String type) {
		System.out.print(type);
	}
}

public class Mountain extends Rock {
	Mountain() {
		super("granite ");
		new Rock("granite ");
	}
	
	public static void main(String[] args) {
		//new Mountain();
		
		StringBuilder sb1 = new StringBuilder("123");
		String s1 = "123";
		
		sb1.append("abc");

		s1 = s1.concat("abc");
		System.out.println(sb1 + " " + s1);;
	}

}


class Line {
	public class Point { public int x, y; }
	public Point getPoint() {return new Point();}
}

class Triangle {
	public Triangle() {
		//Line.Point p = (new Line()).getPoint();
		//Point p = Line.getPoint();
		//Line.Point p = Line.getPoint();
		//Point p = (new Line()).getPoint();
	}
}