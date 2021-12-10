package p04.polymorphism2;

public class Car {
	Tire[] tires = {
			new HankookTire(),
			new HankookTire(),
			new HankookTire(),
			new HankookTire()
	};
	
	void run() {
		for (Tire tire : tires) {
			tire.roll();
		}
		
//		for(int i=0;i<tires.length;i++) {
//			tires[i].roll();
//		}
	}
}
