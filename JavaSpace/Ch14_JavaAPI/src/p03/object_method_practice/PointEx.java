package p03.object_method_practice;

public class PointEx {
	public static void main(String[] args) {
		Point p1 = new Point(2, 3);
		Point p2 = new Point(2, 3);
		Point p3 = new Point(1, 3);
		
		if(p1.equals(p2)) {
			System.out.println("Point p1과 p2는 같습니다.");
		} else {
			System.out.println("Point p1과 p2는 다릅니다.");
		}

		if(p1.equals(p3)) {
			System.out.println("Point p1과 p3는 같습니다.");
		} else {
			System.out.println("Point p1과 p3는 다릅니다.");
		}	
		
//		System.out.println(p1.toString());
//		System.out.println(p2.toString());
//		System.out.println(p3.toString());
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);		
	}
}
