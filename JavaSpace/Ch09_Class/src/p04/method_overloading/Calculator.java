package p04.method_overloading;

public class Calculator {
	//	정사각형 넓이
	double areaRectangle(double width) {
		return width*width;
	}
	
	//	직사각형 넓이
	double areaRectangle(double width, double height) {
		return width*height;
	}
}
