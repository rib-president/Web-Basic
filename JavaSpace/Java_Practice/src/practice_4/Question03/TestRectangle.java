package practice_4.Question03;

//	width 4, height 40 / width 3.5, height 35.9인 instance 두 개를 만들고
//	해당 인스턴스들의 정보를 출력하시오.
public class TestRectangle {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle();
		rect1.width = 4;
		rect1.height = 40;
		
		Rectangle rect2 = new Rectangle();
		rect2.width = 3.5;
		rect2.height = 35.9;
		
		System.out.println("객체명 \t width \t height \t area \t\t perimeter");
		System.out.println("rect1 \t " + rect1.width + "\t" + rect1.height + 
				"\t" + rect1.getArea() + "\t\t\t" + rect1.getPerimeter());
		System.out.println("rect2 \t " + rect2.width + "\t" + rect2.height + 
				"\t" + rect2.getArea() + "\t" + rect2.getPerimeter());
	}
}
