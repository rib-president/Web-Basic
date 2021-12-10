package p03.method_override.super2;

public class SupersonicAirplaneEx {
	public static void main(String[] args) {
		SuperSonicAirplane s = new SuperSonicAirplane();
		
		s.takeOff();
		s.fly();
		s.flyMode = SuperSonicAirplane.SUPERSONIC;
		s.fly();
		s.flyMode = SuperSonicAirplane.NORMAL;
		s.fly();
		s.land();		
	}
}
