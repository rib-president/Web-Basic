package practice_6.Question01;

public class Square extends GeometricObject implements Colorable {
	private double side;
	
	public Square() {
		this.side = 1.0;
	}
	
	public Square(double side) {
		super("black", false);
		this.side = side;
	}
	
	public Square(double side, String color, boolean filled) {
		super(color, filled);
		this.side = side;
	}
	
	public double getSide() {
		return this.side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	public double getArea() {
		return side * side;
	}
	
	public double getPerimeter() {
		return side * 4;
	}
	
	@Override
	public String howToColor() {
		return "모든 변을 색칠하기";
	}
	
	public String toString() {
		return super.toString() + "\nSide: " + side + "\nArea : " + 
				getArea() + "\nPerimeter : " + getPerimeter();
	}
}
