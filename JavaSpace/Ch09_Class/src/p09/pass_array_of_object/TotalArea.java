package p09.pass_array_of_object;

//	1.1차원 배열 int[] numbers; => 원소타입이 integer인 1차원 배열 선언
//	2.String[] args => 원소타입이 String인 1차원 배열
//	3.실습목적 : Circle[] circleArray; => 원소타입이 Circle인 1차원 배열 선언
public class TotalArea {
	public static void main(String[] args) {
		Circle[] circleArray = createCircleArray();
		System.out.println("main에서의 circleArray 주소 = " 
				+ System.identityHashCode(circleArray));
			printCircleArray(circleArray);
	}
	
	public static Circle[] createCircleArray() {
		Circle[] circleArray = new Circle[5];
		
		for(int i=0;i<circleArray.length;i++) {
			circleArray[i] = new Circle(Math.random()*100);
		}
		
		System.out.println("createCircleArray 안에서의 circleArray 주소 = " 
				+ System.identityHashCode(circleArray));
		return circleArray;
	}
	
	public static void printCircleArray(Circle[] ciArr) {
		System.out.println("printCircleArray 안에서의 circleArray 주소 = " 
				+ System.identityHashCode(ciArr));
		
		System.out.println("Radius \t\t\t\t Area");
		for(int i=0;i<ciArr.length;i++) {
			System.out.println(ciArr[i].getRadius() + " \t\t " + 
							ciArr[i].getArea());
		}
	}
}
