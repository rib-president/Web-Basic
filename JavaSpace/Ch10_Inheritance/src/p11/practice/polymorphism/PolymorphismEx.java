package p11.practice.polymorphism;

public class PolymorphismEx {
	public static void main(String[] args) {
		displayObject(new Circle("red", false, 1));
		displayObject(new Rectangle("blue", true, 4, 2));
}
	
	public static void displayObject(GeometricObject geoObj) {
		System.out.println("Object 정보 : " + geoObj.toString());
	}
}
