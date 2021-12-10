package p07.data_field_encapsulation;

public class TestCircleWithPrivateDataFields {
	public static void main(String[] args) {
		Circle myCircle = new Circle();
		
		//	Circle class에서 private으로 선언된 field는 사용불가
		//myCircle.radius = 10;
		//myCircle.numberOfObjects = 20;
		//Circle.numberOfObjects = 20;
		//System.out.println(myCircle.numberOfObjects);
		
		System.out.println("myCircle의 radius = " + myCircle.getRadius()
				 + ", area = " + myCircle.getArea() + " , numOfObjects = " + 
				myCircle.getNumberOfObjects());
		myCircle.setRadius(10);
		System.out.println("myCircle의 radius = " + myCircle.getRadius()
				+ " area = " + myCircle.getArea() + ", numOfObjects = " + 
				Circle.getNumberOfObjects());
		
		//Circle.printHello();
		
	}
}
