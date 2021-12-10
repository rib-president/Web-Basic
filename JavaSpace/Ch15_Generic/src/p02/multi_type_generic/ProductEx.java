package p02.multi_type_generic;

class Tv {}
class Car {}

public class ProductEx {
	public static void main(String[] args) {
		Product<Tv, String> p1 = new Product<>();
		p1.setKind(new Tv());
		p1.setModel("스마트TV");
		Tv tv = p1.getKind();
		String tvModel = p1.getModel();
		
		Product<Car, String> p2 = new Product<>();
		p2.setKind(new Car());
		p2.setModel("디젤");
		Car car = p2.getKind();
		String carModel = p2.getModel();
	}
}
