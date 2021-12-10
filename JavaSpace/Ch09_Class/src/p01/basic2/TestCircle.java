package p01.basic2;

public class TestCircle {
	public static void main(String[] args) {
		Circle pizza = new Circle(10, "자바피자");
		
		double area = pizza.getArea();
		
		System.out.println(pizza.name + "의 면적은 " + area + "입니다.");
		
		//	슈퍼슈프림피자로 만들고 싶음(반지름 12)
		pizza.radius = 12;
		pizza.name = "슈퍼슈프림피자";
		
		area = pizza.getArea();
		
		System.out.println(pizza.name + "의 면적은 " + area + "입니다.");
		
		Circle pineApplePizza = new Circle(11, "파인애플피자");
		area = pineApplePizza.getArea();
		System.out.println(pineApplePizza.name + "의 면적은 " + area + "입니다.");
		
		
		Circle donut = new Circle();	// radius 1, name 플레인피자
		donut.name = "도넛";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area + "입니다.");
		System.out.println();
	}
}
