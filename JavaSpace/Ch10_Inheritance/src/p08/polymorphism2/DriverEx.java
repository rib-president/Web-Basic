package p08.polymorphism2;

public class DriverEx {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		Sedan sedan = new Sedan();
		
		Vehicle v;
		
		v = bus;
		driver.drive(v);
		v = taxi;
		driver.drive(v);
		v = sedan;
		driver.drive(v);
		
		driver.drive(bus);
		driver.drive(taxi);
		driver.drive(sedan);
	}
}
