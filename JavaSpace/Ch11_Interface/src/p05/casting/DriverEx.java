package p05.casting;

public class DriverEx {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();	// Bus->Vehicle promotion
		
		vehicle.run();
//		vehicle.checkFare();
		
		Bus bus = (Bus)vehicle;		// Vehicle->Bus casting
		bus.checkFare();	
	}
}
