package p01.vector_ex;

import java.util.Vector;

public class PointVectorEx {
	public static void main(String[] args) {
		Vector<Point> v = new Vector<>();
		
		v.add(new Point(2, 3));
		v.add(new Point(-5, 20));
		v.add(new Point(30, -8));
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		System.out.println();
		v.remove(1);	//	원소 삭제한느 메소드

		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		
		for(Point p : v) {
			System.out.println(p);
		}
		
	}
}
