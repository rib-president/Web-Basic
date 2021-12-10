package practice_4.Question03;

//	Rectangle class를 만들고 테스트하시오.
public class Rectangle {
	double width = 1;
	double height = 1;
	
	Rectangle() {
		
	}
	
	double getArea() {
		double area = this.width * this.height;
		return area;
	}
	
	double getPerimeter() {
		double perimeter = (this.width + this.height) * 2;
		return perimeter;
	}
}
