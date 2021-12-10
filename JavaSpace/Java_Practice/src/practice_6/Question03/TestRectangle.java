package practice_6.Question03;

public class TestRectangle {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(3, 4);
		Rectangle rect2 = new Rectangle(3, 4);
		Rectangle rect3 = new Rectangle(3, 5);
		
		if(rect1.equals(rect2)) {
			System.out.println("rect1과 rect2는 같습니다.");
		} else System.out.println("rect1과 rect2는 다릅니다.");

		if(rect1.equals(rect3)) {
			System.out.println("rect1과 rect3는 같습니다.");
		} else System.out.println("rect1과 rect3는 다릅니다.");

		System.out.println();
		System.out.println("<rect1> " + rect1);
		System.out.println("<rect2> " + rect2);
		System.out.println("<rect3> " + rect3);		
	}
}
